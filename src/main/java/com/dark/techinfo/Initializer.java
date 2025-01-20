package com.dark.techinfo;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyService;
import com.dark.techinfo.tag.TagService;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {
    
    private final CompanyService companyService;
    
    private final TechnologyService technologyService;
    
    private final TagService tagService;
    
    @Override
    public void run(String... args) throws Exception {

        Technology technology = new Technology();
        technology.setImageUrl("hi");
        
        Company company = new Company();
        company.setName("Dark");
        company.setLocation("Dhaka");
        company.setTechnologies(Set.of(technology));
        
        companyService.addCompany(company);
        
    }
}
