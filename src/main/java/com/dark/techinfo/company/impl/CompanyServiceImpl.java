package com.dark.techinfo.company.impl;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyRepository;
import com.dark.techinfo.company.CompanyService;
import com.dark.techinfo.company.dto.CompanyDto;
import com.dark.techinfo.company.dto.CreateCompanyRequestDto;
import com.dark.techinfo.company.mapper.CompanyMapper;
import com.dark.techinfo.technology.TechnologyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {
    
    private final CompanyRepository companyRepository;
    
    private final TechnologyRepository technologyRepository;
    
    @Override
    @Transactional
    public void addCompany(CreateCompanyRequestDto companyRequestDto) {
        Company company = CompanyMapper.parseRequestToEntity.apply(
                companyRequestDto, 
                technologyRepository.findAllById(companyRequestDto.getTechnologies())
        );
        
        
        companyRepository.save(company);
    }
    
    @Override
    @Transactional
    public void addCompanies(List<CreateCompanyRequestDto> companyRequestDtoList) {
        List<Company> companyList = companyRequestDtoList.stream().map(companyRequestDto -> CompanyMapper.parseRequestToEntity.apply(
                companyRequestDto,
                technologyRepository.findAllById(companyRequestDto.getTechnologies())
        )).toList();
        companyRepository.saveAll(companyList);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<CompanyDto> companyDtoList = companyRepository.findAll().stream().map(CompanyMapper.toDto).toList();
        return companyDtoList;
    }

    @Override
    public CompanyDto getCompany(Long id) {
        CompanyDto companyDto = CompanyMapper.toDto.apply(companyRepository.findById(id).orElseThrow());
        return companyDto;
        
    }

    @Override
    @Transactional
    public List<CompanyDto> searchCompany(String query) {

        String[] queryParts = query.split(" ");
        String companyName = null;
        List<String> tagNames = new ArrayList<>();
        
        for (String part: queryParts) {
            if (part.startsWith("#")) {
                tagNames.add(part.substring(1).toLowerCase());
            } else {
                if (companyName == null) {
                    companyName = part;
                    continue;
                }
                companyName = companyName.concat(" ").concat(part);
            }
        }
        List<CompanyDto> companyDtoList = new ArrayList<>();
        if (companyName != null) {
            companyDtoList.addAll(companyRepository.findByCompanyName(companyName).stream().map(CompanyMapper.toDto).toList());
        }
        
        companyDtoList.addAll(companyRepository.findByTagNames(tagNames).stream().map(CompanyMapper.toDto).toList());
        
        return companyDtoList;
    }

}
