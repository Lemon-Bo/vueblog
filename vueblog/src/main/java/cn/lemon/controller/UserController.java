package cn.lemon.controller;


import cn.lemon.common.lang.Result;
import cn.lemon.entity.User;
import cn.lemon.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemon:柠檬
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        return Result.succ(200,"操作成功",userService.getById(1L));
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        return Result.succ(user);
    }

}
