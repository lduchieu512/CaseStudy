package com.codegym.casestudy_spring_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class    HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
