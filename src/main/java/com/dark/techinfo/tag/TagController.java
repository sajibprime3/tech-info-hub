package com.dark.techinfo.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tag")
public class TagController {
    
    private final TagService tagService;
    
    @GetMapping("/selector")
    public String showSelector(Model model) {
        model.addAttribute("tagDtoList", tagService.getAllTags());
        
        
        return "fragment/tagSelector";
    }
    
    @GetMapping("/form")
    public String showForm() {
        return "page/tagForm";
    }
    
}
