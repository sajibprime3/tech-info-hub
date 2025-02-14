package com.dark.techinfo.company;

import com.dark.techinfo.company.dto.CompanyRegistrationRequestDto;
import com.dark.techinfo.technology.Technology;

import java.util.List;

public interface CompanyService {
    
    void addCompany(CompanyRegistrationRequestDto companyRequestDto);
    
    void addCompaniesExact(List<Company> companyList);
    
    void addCompanies(List<CompanyRegistrationRequestDto> companyRequestDtoList);
    
    List<Company> getAllCompanies();
    
    Company getCompany(Long id);
    
    List<Company> searchCompany(String query);
    
}
