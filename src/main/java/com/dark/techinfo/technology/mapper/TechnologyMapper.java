package com.dark.techinfo.technology.mapper;

import com.dark.techinfo.tag.Tag;
import com.dark.techinfo.tag.mapper.TagMapper;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.dto.CreateTechnologyRequestDto;
import com.dark.techinfo.technology.dto.TechnologyDto;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TechnologyMapper {
    
    public static final Function<TechnologyDto, Technology> toEntity = dto -> Technology.builder()
            .id(dto.getId())
            .name(dto.getName())
            .imageUrl(dto.getImageUrl())
            .tags(dto.getTags().stream().map(TagMapper.toEntity).toList())
            .build();
    
    public static final BiFunction<CreateTechnologyRequestDto, List<Tag>, Technology> parseRequestToEntity = (requestDto, tagList) -> Technology.builder()
            .name(requestDto.getName())
            .imageUrl(requestDto.getImageUrl())
            .tags(tagList)
            .build();
    
    public static final Function<Technology, TechnologyDto> toDto = technology -> TechnologyDto.builder()
            .id(technology.getId())
            .name(technology.getName())
            .imageUrl(technology.getImageUrl())
            .tags(technology.getTags().stream().map(TagMapper.toDto).toList())
            .build();
    
}
