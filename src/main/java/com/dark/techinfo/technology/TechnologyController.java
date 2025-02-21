package com.dark.techinfo.technology;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/technology")
public class TechnologyController {
    
    private final TechnologyService technologyService;
    
    @GetMapping("/form")
    public String showForm() {
        
        
        return "fragment/technologyForm";
    }
    
    @GetMapping("/selector")
    public String showSelector(Model model) {
        model.addAttribute("technologyDtoList", technologyService.getTechnologies());
        
        return "fragment/technologySelector";
    }
    
}
