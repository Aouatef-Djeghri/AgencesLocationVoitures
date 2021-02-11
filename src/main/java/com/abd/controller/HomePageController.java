package com.abd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("/")
public class HomePageController {

    @RequestMapping("/")
    public String index() {    
    	System.out.println("jkjkkjkjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        return "index";
    }
}
