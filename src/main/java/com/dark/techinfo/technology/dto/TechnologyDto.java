package com.dark.techinfo.technology.dto;

import com.dark.techinfo.tag.dto.TagDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TechnologyDto {
    
    Long id;
    
    String name;
    
    String imageUrl;
    
    List<TagDto> tags;
    
}
