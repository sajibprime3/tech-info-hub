package com.dark.techinfo.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/company")
public class CompanyController {
    
    private final CompanyService companyService;
    
    @GetMapping("search")
    String searchCompany(@RequestParam(name = "s") String query, Model model) {
        List<Company> companyList = companyService.searchCompany(query);
        model.addAttribute("companyList", companyList);

        return "fragment/searchResult";
    }
    
    
    
    
    
}
