package top.continew.admin.news.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.news.model.AntiUserDO;
import top.continew.admin.system.service.UserService;

//@Log(module = "登录")
@Tag(name = "用户 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/anti/user")
public class AntiUserController {

    private final UserService userService;

    @PostMapping("/update")
    public void login(@RequestBody AntiUserDO user) {
//        log.info("用户登录");
//        return userService.login(user);
        System.out.println("用户更新" + user);
    }
}
