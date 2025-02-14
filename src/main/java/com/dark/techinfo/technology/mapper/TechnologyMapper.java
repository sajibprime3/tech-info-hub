package com.dark.techinfo.technology.mapper;

import com.dark.techinfo.tag.mapper.TagMapper;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.dto.TechnologyDto;

import java.util.function.Function;
import java.util.stream.Collectors;

public class TechnologyMapper {
    
    public static final Function<TechnologyDto, Technology> toEntity = dto -> Technology.builder()
            .name(dto.getName())
            .imageUrl(dto.getImageUrl())
            .tags(dto.getTags().stream().map(TagMapper.toEntity).collect(Collectors.toSet()))
            .build();
    
    public static final Function<Technology, TechnologyDto> toDto = technology -> TechnologyDto.builder()
            .name(technology.getName())
            .imageUrl(technology.getImageUrl())
            .tags(technology.getTags().stream().map(TagMapper.toDto).collect(Collectors.toSet()))
            .build();
    
}
