package com.dark.techinfo.technology.impl;

import com.dark.techinfo.tag.TagRepository;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.TechnologyRepository;
import com.dark.techinfo.technology.TechnologyService;
import com.dark.techinfo.technology.dto.CreateTechnologyRequestDto;
import com.dark.techinfo.technology.dto.TechnologyDto;
import com.dark.techinfo.technology.mapper.TechnologyMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TechnologyServiceImpl implements TechnologyService {
    
    private final TechnologyRepository technologyRepository;
    
    private final TagRepository tagRepository;

    @Override
    public List<TechnologyDto> getTechnologies() {
        List<TechnologyDto> technologyDtoList = technologyRepository.findAll().stream().map(TechnologyMapper.toDto).toList();
        return technologyDtoList;
    }

    @Override
    @Transactional
    public List<TechnologyDto> getTechnologiesByIds(List<Long> ids) {
        List<TechnologyDto> technologyDtoList = technologyRepository.findAllById(ids).stream().map(TechnologyMapper.toDto).toList();
        return technologyDtoList;
    }

    @Override
    public TechnologyDto getTechnology(Long id) {
        TechnologyDto technologyDto = TechnologyMapper.toDto.apply(technologyRepository.findById(id).orElseThrow());
        return technologyDto;
    }
    
    @Override
    @Transactional
    public void addTechnology(CreateTechnologyRequestDto requestDto) {
        Technology technology = TechnologyMapper.parseRequestToEntity.apply(
                requestDto, 
                tagRepository.findAllById(requestDto.getTags())
        );
        technologyRepository.save(technology);
    }

    @Override
    public void addTechnologies(List<CreateTechnologyRequestDto> requestDtoList) {
        List<Technology> technologyList = requestDtoList.stream().map(
                requestDto -> TechnologyMapper.parseRequestToEntity.apply(
                        requestDto, 
                        tagRepository.findAllById(requestDto.getTags())
                )).toList();
        technologyRepository.saveAll(technologyList);
    }
}
