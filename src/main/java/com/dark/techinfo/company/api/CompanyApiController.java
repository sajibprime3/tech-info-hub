package com.dark.techinfo.company.api;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyService;
import com.dark.techinfo.company.dto.CompanyDto;
import com.dark.techinfo.company.dto.CreateCompanyRequestDto;
import com.dark.techinfo.company.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/company")
public class CompanyApiController {
    
    public final CompanyService companyService;
    
    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }
    
    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable Long id) {
        return companyService.getCompany(id);
    }
    
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody CreateCompanyRequestDto requestDto) {
        companyService.addCompany(requestDto);

        return ResponseEntity.ok("Successfully Created a Company.");
    }
    
    
}
