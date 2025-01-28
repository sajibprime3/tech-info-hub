package com.dark.techinfo.company.impl;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyRepository;
import com.dark.techinfo.company.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
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

    @Override
    public List<Company> getAllCompanies() {
        
        return companyRepository.findAll();
    }

    @Override
    public List<Company> searchCompany(String query) {

        String[] queryParts = query.split(" ");
        String companyName = null;
        List<String> TagNames = new ArrayList<>();
        
        for (String part: queryParts) {
            if (part.startsWith("#")) {
                TagNames.add(part.substring(1).toLowerCase());
            } else {
                if (companyName == null) {
                    companyName = part;
                    continue;
                }
                companyName = companyName.concat(" ").concat(part);
            }
        }

        Set<Company> results = new TreeSet<>(Comparator.comparing(Company::getId));
        if (companyName != null) {
            results.addAll(companyRepository.findByCompanyName(companyName));
        }
        
        results.addAll(companyRepository.findByTagNames(TagNames));
        
        
        log.info(companyName);
        log.info(Arrays.toString(TagNames.toArray()));
        log.info(results.toString());
        log.info("\n");
        
        return results.stream().toList();
    }

}
