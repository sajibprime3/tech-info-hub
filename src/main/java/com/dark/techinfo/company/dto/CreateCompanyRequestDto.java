package com.dark.techinfo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCompanyRequestDto {
    
    String name;
    
    String location;
    
    List<Long> technologies;
}
