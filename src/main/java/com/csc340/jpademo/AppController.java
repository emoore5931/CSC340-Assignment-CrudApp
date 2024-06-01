package com.csc340.jpademo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "/index"})
    public String home(){
        return "redirect:/goals/";
    }
}
