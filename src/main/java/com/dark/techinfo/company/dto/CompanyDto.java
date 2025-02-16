package com.dark.techinfo.company.dto;

import com.dark.techinfo.technology.dto.TechnologyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {
    
    Long id;
    
    String name;
    
    String location;
    
    List<TechnologyDto> technologies;
    
    
    
}
