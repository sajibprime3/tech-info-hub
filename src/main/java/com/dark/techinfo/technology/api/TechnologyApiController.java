package com.dark.techinfo.technology.api;

import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.TechnologyService;
import com.dark.techinfo.technology.dto.TechnologyDto;
import com.dark.techinfo.technology.mapper.TechnologyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technology")
public class TechnologyApiController {
    
    private final TechnologyService technologyService;

    @GetMapping
    public List<TechnologyDto> getAllTechnologies() {
        
        return technologyService.getTechnologies().stream().map(TechnologyMapper.toDto).toList();
    }

    // Get a technology by ID
    @GetMapping("/{id}")
    public Technology getTechnologyById(@PathVariable Long id) {
        return technologyService.getTechnology(id);
    }
    
    @PostMapping
    ResponseEntity<String> createTechnology(@RequestBody Technology technology) {
        technologyService.addTechnology(technology);
        
        return ResponseEntity.ok("Successfully Created a technology.");
    }
    
    
    
}
