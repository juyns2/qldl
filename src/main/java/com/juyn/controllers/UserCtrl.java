package com.juyn.controllers;

import com.juyn.pojo.User;
import com.juyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author FPT SHOP
 */
@Controller
public class UserCtrl {

    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") User user) {
        if (this.userDetailsService.addUser(user) == true)
            return "redirect:/login";
        return "register";
    }
}
