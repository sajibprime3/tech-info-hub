package com.dark.techinfo.tag.impl;

import com.dark.techinfo.tag.Tag;
import com.dark.techinfo.tag.TagRepository;
import com.dark.techinfo.tag.TagService;
import com.dark.techinfo.tag.dto.CreateTagRequestDto;
import com.dark.techinfo.tag.dto.TagDto;
import com.dark.techinfo.tag.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    
    private final TagRepository tagRepository;
    
    @Override
    public void addTag(CreateTagRequestDto requestDto) {
        Tag tag = TagMapper.parseRequestToEntity.apply(requestDto);
        tagRepository.save(tag);
    }

    @Override
    public void addTags(List<CreateTagRequestDto> requestDtoList) {
        List<Tag> tagList = requestDtoList.stream().map(TagMapper.parseRequestToEntity).toList(); 
        tagRepository.saveAll(tagList);
    }

    @Override
    public List<TagDto> getAllTags() {
        List<TagDto> tagDtoList = tagRepository.findAll().stream().map(TagMapper.toDto).toList();
        return tagDtoList;
    }

    @Override
    public TagDto getTagById(Long id) {
        TagDto tagDto = TagMapper.toDto.apply(tagRepository.findById(id).orElseThrow());
        return tagDto;
    }

    @Override
    public List<TagDto> getTagsByIds(List<Long> ids) {
        List<TagDto> tagDtoList = tagRepository.findAllById(ids).stream().map(TagMapper.toDto).toList();
        return tagDtoList;
    }
}
