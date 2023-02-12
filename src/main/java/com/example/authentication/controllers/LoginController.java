package com.example.authentication.controllers;

import com.example.authentication.models.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/")
    public String loginPost(String username, String password, Model model){
        loginProcessor.setName(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if (loggedIn){
            model.addAttribute("message","You are How logged in");
        }else {
            model.addAttribute("message", "Login failed!");
        }
        return "login";
    }
}
