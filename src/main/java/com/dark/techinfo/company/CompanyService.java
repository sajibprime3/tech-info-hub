package com.dark.techinfo.company;

import com.dark.techinfo.technology.Technology;

import java.util.List;

public interface CompanyService {
    
    void addCompany(Company company);
    
    void addCompanies(List<Company> companyList);
    
    List<Company> getAllCompanies();
    
    List<Company> searchCompany(String query);
    
}
