package com.dark.techinfo.company.impl;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyRepository;
import com.dark.techinfo.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    
    private final CompanyRepository companyRepository;
    
    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void addCompanies(List<Company> companyList) {
        companyRepository.saveAll(companyList);
    }
}
