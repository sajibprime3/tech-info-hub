package com.dark.techinfo.company;

import com.dark.techinfo.company.dto.CompanyDto;
import com.dark.techinfo.company.dto.CreateCompanyRequestDto;

import java.util.List;

public interface CompanyService {
    
    void addCompany(CreateCompanyRequestDto companyRequestDto);
    
    void addCompanies(List<CreateCompanyRequestDto> companyRequestDtoList);
    
    List<CompanyDto> getAllCompanies();
    
    CompanyDto getCompany(Long id);
    
    List<CompanyDto> searchCompany(String query);
    
}
