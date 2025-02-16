package com.dark.techinfo;

import com.dark.techinfo.company.CompanyService;
import com.dark.techinfo.company.dto.CreateCompanyRequestDto;
import com.dark.techinfo.tag.TagService;
import com.dark.techinfo.tag.dto.CreateTagRequestDto;
import com.dark.techinfo.technology.TechnologyService;
import com.dark.techinfo.technology.dto.CreateTechnologyRequestDto;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {
    
    private final CompanyService companyService;
    
    private final TechnologyService technologyService;
    
    private final TagService tagService;
    
    private final Faker faker;
    
    private final Random random = new Random();
    
    @Override
    public void run(String... args) {
        
        List<CreateTagRequestDto> tagRequestDtoList = IntStream.rangeClosed(1, 25)
                .mapToObj(i -> new CreateTagRequestDto(faker.programmingLanguage().name())).toList();

        List<String> techs = Arrays.asList(
                "Java", "Python", "JavaScript", "C#", "Ruby", "Go", "PHP", "Swift", "Kotlin", "TypeScript", "React", "Angular", "Node.js", "Docker", "Kubernetes"
        );
        
        List<CreateTechnologyRequestDto> technologyRequestDtoList = techs.stream().map(name -> CreateTechnologyRequestDto.builder()
                .name(name)
                .imageUrl(faker.internet().image())
                .tags(IntStream.rangeClosed(1, random.nextInt(1, 3))
                        .mapToObj(i -> random.nextLong(tagRequestDtoList.size()-1)).toList()
                )
                .build()).toList();
        
        List<CreateCompanyRequestDto> companyRequestDtoList = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> CreateCompanyRequestDto.builder()
                        .name(faker.company().name())
                        .location(faker.address().fullAddress())
                        .technologies(
                                IntStream.rangeClosed(1, random.nextInt(1, 5))
                                        .mapToObj(j -> random.nextLong(technologyRequestDtoList.size()-1)).toList())
                                .build()
                        ).toList();
        
        
        tagService.addTags(tagRequestDtoList);
        technologyService.addTechnologies(technologyRequestDtoList);
        companyService.addCompanies(companyRequestDtoList);
    }
}
