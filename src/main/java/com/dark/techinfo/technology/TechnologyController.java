package com.dark.techinfo.technology;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/technology")
public class TechnologyController {
    
    @GetMapping("/form")
    public String showForm() {
        
        
        return "page/technologyForm";
    }
    
}
