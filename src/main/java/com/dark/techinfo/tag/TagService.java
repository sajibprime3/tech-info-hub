package com.dark.techinfo.tag;

import com.dark.techinfo.tag.dto.CreateTagRequestDto;
import com.dark.techinfo.tag.dto.TagDto;

import java.util.List;

public interface TagService {
    
    void addTag(CreateTagRequestDto requestDto);
    
    void addTags(List<CreateTagRequestDto> requestDtoList);
    
    List<TagDto> getAllTags();
    
    TagDto getTagById(Long id);
    
    List<TagDto> getTagsByIds(List<Long> ids);
    
}
