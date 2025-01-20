package com.dark.techinfo.technology.impl;

import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.TechnologyRepository;
import com.dark.techinfo.technology.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TechnologyServiceImpl implements TechnologyService {
    
    private final TechnologyRepository technologyRepository;
    
    @Override
    public void addTechnology(Technology technology) {
        technologyRepository.save(technology);
        
    }

    @Override
    public void addTechologies(List<Technology> technologyList) {
        technologyRepository.saveAll(technologyList);
    }
}
