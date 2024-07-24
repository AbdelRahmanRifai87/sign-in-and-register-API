package com.authorizationAPI.authorization.controller;

import org.springframework.web.bind.annotation.RestController;
import com.authorizationAPI.authorization.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/API")
public class AuthenController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String getMethodName(@RequestParam String name,@RequestParam String password) {
        authService.register(name, password);
        return "Done";
    }
    
    @PostMapping("/login")
    public String Authorized(@RequestParam String UserName,@RequestParam String password) {

        if (authService.login(UserName,password)) {
            return "Login Successful";
        } else
            return "user not found or password is incorrect";
    }
    
    @GetMapping("/print")
    public String print() {
        return authService.printList();
    }
    
}
