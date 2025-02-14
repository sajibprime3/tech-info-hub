package com.dark.techinfo.company.mapper;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.dto.CompanyDto;
import com.dark.techinfo.company.dto.CompanyRegistrationRequestDto;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.mapper.TechnologyMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class CompanyMapper {
    
    public static final Function<CompanyDto, Company> toEntity = dto -> Company.builder()
            .id(dto.getId())
            .name(dto.getName())
            .location(dto.getLocation())
            .technologies(dto.getTechnologies().stream().map(TechnologyMapper.toEntity).collect(Collectors.toSet()))
            .build();
    
    public static final BiFunction<CompanyRegistrationRequestDto, Set<Technology>, Company> parseRequestToEntity = (requestDto, technologies) -> Company.builder()
            .name(requestDto.getName())
            .location(requestDto.getLocation())
            .technologies(technologies)
            .build();
    
    public static final Function<Company, CompanyDto> toDto = company -> CompanyDto.builder()
            .id(company.getId())
            .name(company.getName())
            .location(company.getLocation())
            .technologies(company.getTechnologies().stream().map(TechnologyMapper.toDto).collect(Collectors.toSet()))
            .build();
    
    
    
    
}
