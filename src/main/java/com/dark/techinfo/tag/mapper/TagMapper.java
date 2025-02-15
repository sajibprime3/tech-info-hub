package com.dark.techinfo.tag.mapper;

import com.dark.techinfo.tag.Tag;
import com.dark.techinfo.tag.dto.CreateTagRequestDto;
import com.dark.techinfo.tag.dto.TagDto;

import java.util.function.Function;

public class TagMapper {
    
    public static final Function<TagDto, Tag> toEntity = dto -> Tag.builder()
            .id(dto.getId())
            .name(dto.getName())
            .build();
    
    public static final Function<CreateTagRequestDto, Tag> parseRequestToEntity = requestDto -> Tag.builder()
            .name(requestDto.getName())
            .build();
    
    public static final Function<Tag, TagDto> toDto = tag -> TagDto.builder()
            .id(tag.getId())
            .name(tag.getName())
            .build();
    
}
