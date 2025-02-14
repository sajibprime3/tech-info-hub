package com.dark.techinfo.company.dto;

import com.dark.techinfo.technology.dto.TechnologyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRegistrationRequestDto {
    
    String name;
    
    String location;
    
    Set<Long> technologies;
}
