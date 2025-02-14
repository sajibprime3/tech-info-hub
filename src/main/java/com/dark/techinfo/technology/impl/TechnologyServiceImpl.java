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
    public List<Technology> getTechnologies() {
        
        return technologyRepository.findAll();
    }

    @Override
    public List<Technology> getTechnologiesById(List<Long> id) {
        return technologyRepository.getTechnologiesById(id);
    }

    @Override
    public Technology getTechnology(Long id) {
        
        return technologyRepository.findById(id).orElseThrow();
    }

    @Override
    public Technology getTechnologyById(Long id) {
        return technologyRepository.getTechnoLogyById(id);
    }

    @Override
    public void addTechnology(Technology technology) {
        technologyRepository.save(technology);
        
    }

    @Override
    public void addTechnologies(List<Technology> technologyList) {
        technologyRepository.saveAll(technologyList);
    }
}
