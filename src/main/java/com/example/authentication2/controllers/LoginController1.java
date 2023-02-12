package com.example.authentication2.controllers;

import com.example.authentication2.modeles.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController1 {
   private final com.example.authentication2.modeles.LoginProcessor loginProcessor;

    public LoginController1(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/")
    public String loginPost(String username, String password, Model model){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();
        if (loggedIn) {
            return "redirect:/main";
        }
        model.addAttribute("message", "Login failed!");
        return "login.html";
    }


}
