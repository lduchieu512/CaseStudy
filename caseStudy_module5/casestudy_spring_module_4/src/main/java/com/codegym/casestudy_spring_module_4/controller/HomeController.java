package com.codegym.casestudy_spring_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("error") Optional<String> error, Model model) {
        if (error.isPresent()) {
            model.addAttribute("error", error.get());
        }
        return "login";
    }

    @GetMapping("/deny")
    public String denied() {
        return "denied";
    }
}
