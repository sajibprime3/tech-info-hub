package com.dark.techinfo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
    
    @GetMapping("/")
    String home() {
        return "page/homepage";
    }
    
    
}
