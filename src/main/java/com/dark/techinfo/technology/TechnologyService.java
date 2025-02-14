package com.dark.techinfo.technology;


import java.util.List;

public interface TechnologyService {

    List<Technology> getTechnologies();
    
    List<Technology> getTechnologiesById(List<Long> id);

    Technology getTechnology(Long id);
    
    Technology getTechnologyById(Long id);
    
    void addTechnology(Technology technology);
    
    void addTechnologies(List<Technology> technologyList);

    
}
