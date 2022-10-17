package com.juyn.controllers;

import com.juyn.pojo.User;
import com.juyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FPT SHOP
 */
@Controller
public class Users {

    @Autowired
    private UserService userDetailsService;
    
    @RequestMapping("/user/info")
    public String info() {
        return "userInfo";
    }

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute(value = "user") com.juyn.pojo.User user) {
        if (this.userDetailsService.addUser(user) == true) {
            return "redirect:/user/login";
        }
        return "register";
    }
}
