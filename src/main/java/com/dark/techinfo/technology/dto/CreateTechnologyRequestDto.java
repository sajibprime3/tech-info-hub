package com.dark.techinfo.technology.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CreateTechnologyRequestDto {
    
    String name;
    
    String imageUrl;
    
    List<Long> tags;
    
}
