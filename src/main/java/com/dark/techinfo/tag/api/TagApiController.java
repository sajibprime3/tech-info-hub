package com.dark.techinfo.tag.api;

import com.dark.techinfo.tag.TagService;
import com.dark.techinfo.tag.dto.CreateTagRequestDto;
import com.dark.techinfo.tag.dto.TagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tag")
public class TagApiController {
    
    private final TagService tagService;
    
    @GetMapping
    public List<TagDto> getAllTags() {
        return tagService.getAllTags();
    }
    
    @GetMapping("/{id}")
    public TagDto getTag(@PathVariable Long id) {
        return tagService.getTagById(id);
    }
    
    @PostMapping
    public String createTag(@RequestBody CreateTagRequestDto requestDto) {
        tagService.addTag(requestDto);
        return "Successfully created Tag";
    }
    
    
}
