package com.geekster.Instademoapp.Controller;

import com.geekster.Instademoapp.Model.User;
import com.geekster.Instademoapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("SIGNUP")
    public String userSignUp(@RequestBody User user){
        return userService.userSignUp(user);
    }

    @PostMapping("SIGNING/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password){
        return userService.userSignIn(email, password);
    }

    @DeleteMapping("SIGNOUT/{email}")
    public String userSignOut(@PathVariable String email, @RequestParam String token){
        return userService.userSignOut(email,token);
    }
}
