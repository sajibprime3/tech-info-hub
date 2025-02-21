package com.dark.techinfo.company;

import com.dark.techinfo.company.dto.CompanyDto;
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
        List<CompanyDto> companyDtoList = companyService.searchCompany(query);
        model.addAttribute("companyDtoList", companyDtoList);
        return "fragment/searchResult";
    }
    
    @GetMapping("/form")
    String showForm() {
        return "fragment/companyForm";
    }
    
    
    
    
    
}
