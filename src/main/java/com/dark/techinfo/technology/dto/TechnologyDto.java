package com.dark.techinfo.technology.dto;


import com.dark.techinfo.tag.dto.TagDto;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TechnologyDto {
    
    String name;
    
    String imageUrl;
    
    Set<TagDto> tags;
    
}
