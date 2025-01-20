package com.dark.techinfo.tag.impl;

import com.dark.techinfo.tag.Tag;
import com.dark.techinfo.tag.TagRepository;
import com.dark.techinfo.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    
    private final TagRepository tagRepository;
    
    @Override
    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void addTags(List<Tag> tagList) {
        tagRepository.saveAll(tagList);
    }
}
