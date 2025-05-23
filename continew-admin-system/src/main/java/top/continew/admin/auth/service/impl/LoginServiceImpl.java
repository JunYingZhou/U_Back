/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.auth.service.impl;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.zhyd.oauth.model.AuthUser;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.continew.admin.auth.model.req.SignUpReq;
import top.continew.admin.auth.model.resp.LoginResp;
import top.continew.admin.auth.model.resp.RouteResp;
import top.continew.admin.auth.service.LoginService;
import top.continew.admin.common.constant.CacheConstants;
import top.continew.admin.common.constant.RegexConstants;
import top.continew.admin.common.constant.SysConstants;
import top.continew.admin.common.context.RoleContext;
import top.continew.admin.common.context.UserContext;
import top.continew.admin.common.context.UserContextHolder;
import top.continew.admin.common.context.UserExtraContext;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.common.enums.GenderEnum;
import top.continew.admin.common.util.SecureUtils;
import top.continew.admin.system.enums.MenuTypeEnum;
import top.continew.admin.system.enums.MessageTemplateEnum;
import top.continew.admin.system.enums.MessageTypeEnum;
import top.continew.admin.system.enums.PasswordPolicyEnum;
import top.continew.admin.system.model.entity.DeptDO;
import top.continew.admin.system.model.entity.RoleDO;
import top.continew.admin.system.model.entity.UserDO;
import top.continew.admin.system.model.entity.UserSocialDO;
import top.continew.admin.system.model.req.MessageReq;
import top.continew.admin.system.model.resp.MenuResp;
import top.continew.admin.system.service.*;
import top.continew.starter.cache.redisson.util.RedisUtils;
import top.continew.starter.core.autoconfigure.project.ProjectProperties;
import top.continew.starter.core.util.ExceptionUtils;
import top.continew.starter.core.util.validate.CheckUtils;
import top.continew.starter.core.util.validate.ValidationUtils;
import top.continew.starter.extension.crud.annotation.TreeField;
import top.continew.starter.extension.crud.util.TreeUtils;
import top.continew.starter.messaging.websocket.util.WebSocketUtils;
import top.continew.starter.web.util.SpringWebUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static top.continew.admin.system.enums.PasswordPolicyEnum.PASSWORD_EXPIRATION_DAYS;

/**
 * 登录业务实现
 *
 * @author Charles7c
 * @since 2022/12/21 21:49
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final ProjectProperties projectProperties;
    private final PasswordEncoder passwordEncoder;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private final UserService userService;
    private final DeptService deptService;
    private final RoleService roleService;
    private final MenuService menuService;
    private final UserRoleService userRoleService;
    private final UserSocialService userSocialService;
    private final OptionService optionService;
    private final MessageService messageService;

    @Override
    public String accountLogin(String username, String password, HttpServletRequest request) {
        UserDO user = userService.getByUsername(username);
        System.out.println("密码对比"+password+","+user.getPassword()+","+passwordEncoder.encode(password));
        boolean isError = ObjectUtil.isNull(user) || !passwordEncoder.matches(password, user.getPassword());
        this.checkUserLocked(username, request, isError);
        CheckUtils.throwIf(isError, "用户名或密码错误");
        this.checkUserStatus(user);
        return this.login(user) + "id:" + user.getId();
    }

    @Override
    public String phoneLogin(String phone) {
        UserDO user = userService.getByPhone(phone);
        CheckUtils.throwIfNull(user, "此手机号未绑定本系统账号");
        this.checkUserStatus(user);
        return this.login(user);
    }

    @Override
    public String emailLogin(String email) {
        UserDO user = userService.getByEmail(email);
        CheckUtils.throwIfNull(user, "此邮箱未绑定本系统账号");
        this.checkUserStatus(user);
        return this.login(user);
    }

    @Override
    public String weiXinLogin(String openId) {
        // 1.查看是否存在当前用户
        UserDO user = userService.getByUsername("Wx" + openId);
        // 2.如果不存在就创建一个用户
        if (ObjectUtil.isNull(user)) {
            System.out.println("微信用户不存在，创建微信用户");
            UserDO iUser = new UserDO();
            iUser.setNickname("微信用户");
            iUser.setUsername("wx" + openId);
            iUser.setGender(GenderEnum.UNKNOWN);
            iUser.setIsSystem(Boolean.TRUE);
            iUser.setDeptId(SysConstants.SUPER_DEPT_ID);
            iUser.setPassword(passwordEncoder.encode("123456"));
            iUser.setCreateTime(LocalDateTime.now());
            Long add = userService.add(iUser);
            System.out.println("123123123"+openId);
            user = userService.getByUsername("Wx" + openId);
//            ArrayList<Long> arrayList = new ArrayList<>();
            RoleDO role = roleService.getByCode(SysConstants.ADMIN_ROLE_CODE);
            userRoleService.add(Collections.singletonList(role.getId()), add);
//            arrayList.add(547888897925840928L);
//            userRoleService.add(arrayList, add);
        }
        return this.login(user) +"id:" + user.getId();
    }

    @Override
    public String signUp(UserDO userDO) {
        // 1.查看是否存在当前用户
        UserDO user = userService.getByUsername(userDO.getUsername());
        // 2.如果不存在就创建一个用户
        if (ObjectUtil.isNull(user)) {
            System.out.println("注册用户不存在，创建微信用户");
            String rawPassword = ExceptionUtils.exToNull(() -> SecureUtils.decryptByRsaPrivateKey(userDO.getPassword()));
            ValidationUtils.throwIfNull(rawPassword, "密码解密失败");
            ValidationUtils.throwIf(!ReUtil
                    .isMatch(RegexConstants.PASSWORD, rawPassword), "密码长度为 8-32 个字符，支持大小写字母、数字、特殊字符，至少包含字母和数字");
            UserDO iUser = new UserDO();
            iUser.setNickname("用户");
            iUser.setUsername(userDO.getUsername());
            iUser.setGender(GenderEnum.UNKNOWN);
            iUser.setIsSystem(Boolean.TRUE);
            iUser.setDeptId(SysConstants.SUPER_DEPT_ID);
            iUser.setPassword(rawPassword);
//            String rawPassword = ExceptionUtils.exToNull(() -> SecureUtils.decryptByRsaPrivateKey(signUpReq.()));
//            iUser.setPassword(userDO.getPassword());
            iUser.setCreateTime(LocalDateTime.now());
            Long add = userService.add(iUser);
            user = userService.getByUsername(userDO.getUsername());
            RoleDO role = roleService.getByCode("normal");
            userRoleService.add(Collections.singletonList(role.getId()), add);
        }else {
            CheckUtils.throwIf(true, "用户已存在");
        }
        return this.login(user) +"id:" + user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String socialLogin(AuthUser authUser) {
        String source = authUser.getSource();
        String openId = authUser.getUuid();
        UserSocialDO userSocial = userSocialService.getBySourceAndOpenId(source, openId);
        UserDO user;
        if (null == userSocial) {
            String username = authUser.getUsername();
            String nickname = authUser.getNickname();
            UserDO existsUser = userService.getByUsername(username);
            String randomStr = RandomUtil.randomString(RandomUtil.BASE_CHAR, 5);
            if (null != existsUser || !ReUtil.isMatch(RegexConstants.USERNAME, username)) {
                username = randomStr + IdUtil.fastSimpleUUID();
            }
            if (!ReUtil.isMatch(RegexConstants.GENERAL_NAME, nickname)) {
                nickname = source.toLowerCase() + randomStr;
            }
            user = new UserDO();
            user.setUsername(username);
            user.setNickname(nickname);
            user.setGender(GenderEnum.valueOf(authUser.getGender().name()));
            user.setAvatar(authUser.getAvatar());
            user.setDeptId(SysConstants.SUPER_DEPT_ID);
            Long userId = userService.add(user);
            RoleDO role = roleService.getByCode(SysConstants.ADMIN_ROLE_CODE);
            userRoleService.add(Collections.singletonList(role.getId()), userId);
            userSocial = new UserSocialDO();
            userSocial.setUserId(userId);
            userSocial.setSource(source);
            userSocial.setOpenId(openId);
            this.sendSecurityMsg(user);
        } else {
            user = BeanUtil.copyProperties(userService.getById(userSocial.getUserId()), UserDO.class);
        }
        this.checkUserStatus(user);
        userSocial.setMetaJson(JSONUtil.toJsonStr(authUser));
        userSocial.setLastLoginTime(LocalDateTime.now());
        userSocialService.saveOrUpdate(userSocial);
        return this.login(user);
    }

    @Override
    public List<RouteResp> buildRouteTree(Long userId) {
        Set<String> roleCodeSet = roleService.listCodeByUserId(userId);
        if (CollUtil.isEmpty(roleCodeSet)) {
            return new ArrayList<>(0);
        }
        // 查询菜单列表
        Set<MenuResp> menuSet = new LinkedHashSet<>();
        if (roleCodeSet.contains(SysConstants.ADMIN_ROLE_CODE)) {
            menuSet.addAll(menuService.listAll());
        } else {
            roleCodeSet.forEach(roleCode -> menuSet.addAll(menuService.listByRoleCode(roleCode)));
        }
        List<MenuResp> menuList = menuSet.stream().filter(m -> !MenuTypeEnum.BUTTON.equals(m.getType())).toList();
        // 构建路由树
        TreeField treeField = MenuResp.class.getDeclaredAnnotation(TreeField.class);
        TreeNodeConfig treeNodeConfig = TreeUtils.genTreeNodeConfig(treeField);
        List<Tree<Long>> treeList = TreeUtils.build(menuList, treeNodeConfig, (m, tree) -> {
            tree.setId(m.getId());
            tree.setParentId(m.getParentId());
            tree.setName(m.getTitle());
            tree.setWeight(m.getSort());
            tree.putExtra("type", m.getType().getValue());
            tree.putExtra("path", m.getPath());
            tree.putExtra("name", m.getName());
            tree.putExtra("component", m.getComponent());
            tree.putExtra("redirect", m.getRedirect());
            tree.putExtra("icon", m.getIcon());
            tree.putExtra("isExternal", m.getIsExternal());
            tree.putExtra("isCache", m.getIsCache());
            tree.putExtra("isHidden", m.getIsHidden());
            tree.putExtra("permission", m.getPermission());
        });
        return BeanUtil.copyToList(treeList, RouteResp.class);
    }

    /**
     * 登录并缓存用户信息
     *
     * @param user 用户信息
     * @return 令牌
     */
    private String login(UserDO user) {
        Long userId = user.getId();
        CompletableFuture<Set<String>> permissionFuture = CompletableFuture.supplyAsync(() -> roleService
            .listPermissionByUserId(userId), threadPoolTaskExecutor);
        CompletableFuture<Set<RoleContext>> roleFuture = CompletableFuture.supplyAsync(() -> roleService
            .listByUserId(userId), threadPoolTaskExecutor);
        CompletableFuture<Integer> passwordExpirationDaysFuture = CompletableFuture.supplyAsync(() -> optionService
            .getValueByCode2Int(PASSWORD_EXPIRATION_DAYS.name()));
        CompletableFuture.allOf(permissionFuture, roleFuture, passwordExpirationDaysFuture);
        UserContext userContext = new UserContext(permissionFuture.join(), roleFuture
            .join(), passwordExpirationDaysFuture.join());
        BeanUtil.copyProperties(user, userContext);
        // 登录并缓存用户信息
        StpUtil.login(userContext.getId(), SaLoginConfig.setExtraData(BeanUtil
            .beanToMap(new UserExtraContext(SpringWebUtils.getRequest()))));
        UserContextHolder.setContext(userContext);
        return StpUtil.getTokenValue();
    }


    /**
     * 检查用户状态
     *
     * @param user 用户信息
     */
    private void checkUserStatus(UserDO user) {
        CheckUtils.throwIfEqual(DisEnableStatusEnum.DISABLE, user.getStatus(), "此账号已被禁用，如有疑问，请联系管理员");
        DeptDO dept = deptService.getById(user.getDeptId());
        CheckUtils.throwIfEqual(DisEnableStatusEnum.DISABLE, dept.getStatus(), "此账号所属部门已被禁用，如有疑问，请联系管理员");
    }

    /**
     * 检测用户是否已被锁定
     *
     * @param username 用户名
     * @param request  请求对象
     * @param isError  是否登录错误
     */
    private void checkUserLocked(String username, HttpServletRequest request, boolean isError) {
        // 不锁定
        int maxErrorCount = optionService.getValueByCode2Int(PasswordPolicyEnum.PASSWORD_ERROR_LOCK_COUNT.name());
        if (maxErrorCount <= SysConstants.NO) {
            return;
        }
        // 检测是否已被锁定
        String key = CacheConstants.USER_PASSWORD_ERROR_KEY_PREFIX + RedisUtils.formatKey(username, JakartaServletUtil
            .getClientIP(request));
        int lockMinutes = optionService.getValueByCode2Int(PasswordPolicyEnum.PASSWORD_ERROR_LOCK_MINUTES.name());
        Integer currentErrorCount = ObjectUtil.defaultIfNull(RedisUtils.get(key), 0);
        CheckUtils.throwIf(currentErrorCount >= maxErrorCount, "账号锁定 {} 分钟，请稍后再试", lockMinutes);
        // 登录成功清除计数
        if (!isError) {
            RedisUtils.delete(key);
            return;
        }
        // 登录失败递增计数
        currentErrorCount++;
        RedisUtils.set(key, currentErrorCount, Duration.ofMinutes(lockMinutes));
        CheckUtils.throwIf(currentErrorCount >= maxErrorCount, "密码错误已达 {} 次，账号锁定 {} 分钟", maxErrorCount, lockMinutes);
    }

    /**
     * 发送安全消息
     *
     * @param user 用户信息
     */
    private void sendSecurityMsg(UserDO user) {
        MessageReq req = new MessageReq();
        MessageTemplateEnum socialRegister = MessageTemplateEnum.SOCIAL_REGISTER;
        req.setTitle(socialRegister.getTitle().formatted(projectProperties.getName()));
        req.setContent(socialRegister.getContent().formatted(user.getNickname()));
        req.setType(MessageTypeEnum.SECURITY);
        messageService.add(req, CollUtil.toList(user.getId()));
        List<String> tokenList = StpUtil.getTokenValueListByLoginId(user.getId());
        for (String token : tokenList) {
            WebSocketUtils.sendMessage(token, "1");
        }
    }
}
