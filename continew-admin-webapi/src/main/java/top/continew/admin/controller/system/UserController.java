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

package top.continew.admin.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.util.ReUtil;
import com.github.xiaoymin.knife4j.annotations.Ignore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.continew.admin.common.constant.RegexConstants;
import top.continew.admin.common.util.SecureUtils;
import top.continew.admin.system.model.query.UserQuery;
import top.continew.admin.system.model.req.UserImportReq;
import top.continew.admin.system.model.req.UserPasswordResetReq;
import top.continew.admin.system.model.req.UserReq;
import top.continew.admin.system.model.req.UserRoleUpdateReq;
import top.continew.admin.system.model.resp.*;
import top.continew.admin.system.service.UserService;
import top.continew.starter.core.util.ExceptionUtils;
import top.continew.starter.core.util.validate.ValidationUtils;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.starter.extension.crud.enums.Api;
import top.continew.starter.extension.crud.model.resp.BaseIdResp;
import top.continew.starter.extension.crud.util.ValidateGroup;

import java.io.IOException;
import java.util.Date;

/**
 * 用户管理 API
 *
 * @author Charles7c
 * @since 2023/2/20 21:00
 */
@Tag(name = "用户管理 API")
@Validated
@RestController
@RequiredArgsConstructor
@CrudRequestMapping(value = "/system/user", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class UserController extends BaseController<UserService, UserResp, UserDetailResp, UserQuery, UserReq> {

    private final UserService userService;

    @SaIgnore
    @Override
    public BaseIdResp<Long> add(@RequestBody UserReq req) {
        String rawPassword = ExceptionUtils.exToNull(() -> SecureUtils.decryptByRsaPrivateKey(req.getPassword()));
        ValidationUtils.throwIfNull(rawPassword, "密码解密失败");
        ValidationUtils.throwIf(!ReUtil
            .isMatch(RegexConstants.PASSWORD, rawPassword), "密码长度为 8-32 个字符，支持大小写字母、数字、特殊字符，至少包含字母和数字");
        req.setPassword(rawPassword);
        req.setCreateTime(new Date());
        return super.add(req);
    }

    @Operation(summary = "下载用户导入模板", description = "下载用户导入模板")
    @SaCheckPermission("system:user:import")
    @GetMapping(value = "downloadImportUserTemplate", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadImportUserTemplate(HttpServletResponse response) throws IOException {
        userService.downloadImportUserTemplate(response);
    }

    @Operation(summary = "解析用户导入数据", description = "解析用户导入数据")
    @SaCheckPermission("system:user:import")
    @PostMapping(value = "parseImportUser")
    public UserImportParseResp parseImportUser(@NotNull(message = "文件不能为空") MultipartFile file) {
        ValidationUtils.throwIf(file::isEmpty, "文件不能为空");
        return userService.parseImportUser(file);
    }

    @Operation(summary = "导入用户", description = "导入用户")
    @SaCheckPermission("system:user:import")
    @PostMapping(value = "import")
    public UserImportResp importUser(@Validated @RequestBody UserImportReq req) {
        return userService.importUser(req);
    }

    @Operation(summary = "重置密码", description = "重置用户登录密码")
    @Parameter(name = "id", description = "ID", example = "1", in = ParameterIn.PATH)
    @SaCheckPermission("system:user:resetPwd")
    @PatchMapping("/{id}/password")
    public void resetPassword(@Validated @RequestBody UserPasswordResetReq req, @PathVariable Long id) {
        String rawNewPassword = ExceptionUtils.exToNull(() -> SecureUtils.decryptByRsaPrivateKey(req.getNewPassword()));
        ValidationUtils.throwIfNull(rawNewPassword, "新密码解密失败");
        ValidationUtils.throwIf(!ReUtil
            .isMatch(RegexConstants.PASSWORD, rawNewPassword), "密码长度为 8-32 个字符，支持大小写字母、数字、特殊字符，至少包含字母和数字");
        req.setNewPassword(rawNewPassword);
        baseService.resetPassword(req, id);
    }

    @Operation(summary = "分配角色", description = "为用户新增或移除角色")
    @Parameter(name = "id", description = "ID", example = "1", in = ParameterIn.PATH)
    @SaCheckPermission("system:user:updateRole")
    @PatchMapping("/{id}/role")
    public void updateRole(@Validated @RequestBody UserRoleUpdateReq updateReq, @PathVariable Long id) {
        baseService.updateRole(updateReq, id);
    }
}
