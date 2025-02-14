package com.dark.techinfo.company.impl;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyRepository;
import com.dark.techinfo.company.CompanyService;
import com.dark.techinfo.company.dto.CompanyRegistrationRequestDto;
import com.dark.techinfo.company.mapper.CompanyMapper;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.TechnologyService;
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
    
    private final TechnologyService technologyService;
    
    @Override
    public void addCompany(CompanyRegistrationRequestDto companyRequestDto) {
        Company company = CompanyMapper.parseRequestToEntity.apply(
                companyRequestDto, 
                new HashSet<>(technologyService.getTechnologiesById(companyRequestDto.getTechnologies().stream().toList()))
        );
        
        
        companyRepository.save(company);
    }

    @Override
    public void addCompaniesExact(List<Company> companyList) {
        
        companyRepository.saveAll(companyList);
    }

    @Override
    public void addCompanies(List<CompanyRegistrationRequestDto> companyRequestDtoList) {
        List<Company> companyList = companyRequestDtoList.stream().map(requestDto -> CompanyMapper.parseRequestToEntity.apply(
                requestDto, 
                new HashSet<>(technologyService.getTechnologiesById(requestDto.getTechnologies().stream().toList()))
        )).toList();

        companyRepository.saveAll(companyList);
    }

    @Override
    public List<Company> getAllCompanies() {
        
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow();
        
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
        
        
        return results.stream().toList();
    }

}
