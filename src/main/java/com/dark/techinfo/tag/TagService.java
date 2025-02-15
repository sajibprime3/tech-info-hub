package com.dark.techinfo.tag;

import java.util.List;

public interface TagService {
    
    void addTag(Tag tag);
    
    void addTags(List<Tag> tagList);
    
    List<Tag> getAllTags();
    
    Tag getTagById(Long id);
    
}
