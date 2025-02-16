package com.dark.techinfo.technology;


import com.dark.techinfo.technology.dto.CreateTechnologyRequestDto;
import com.dark.techinfo.technology.dto.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    List<TechnologyDto> getTechnologies();
    
    List<TechnologyDto> getTechnologiesByIds(List<Long> ids);

    TechnologyDto getTechnology(Long id);
    
    void addTechnology(CreateTechnologyRequestDto requestDto);
    
    void addTechnologies(List<CreateTechnologyRequestDto> requestDtoList);

    
}
