package com.dark.techinfo;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.company.CompanyService;
import com.dark.techinfo.tag.Tag;
import com.dark.techinfo.tag.TagService;
import com.dark.techinfo.technology.Technology;
import com.dark.techinfo.technology.TechnologyService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
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
    public void run(String... args) throws Exception {
        
        List<Tag> tagList = IntStream.rangeClosed(1, 25)
                .mapToObj(i -> new Tag(faker.programmingLanguage().name())).toList();

        List<String> techs = Arrays.asList(
                "Java", "Python", "JavaScript", "C#", "Ruby", "Go", "PHP", "Swift", "Kotlin", "TypeScript", "React", "Angular", "Node.js", "Docker", "Kubernetes"
        );
        
        List<Technology> technologyList = techs.stream().map(name -> Technology.builder()
                .name(name)
                .imageUrl(faker.internet().url())
                .tags(
                        IntStream.rangeClosed(1, random.nextInt(1, 3))
                                .mapToObj(i -> tagList.get(random.nextInt(1,25))).collect(Collectors.toSet())
                )
                .build()).toList();
        
        List<Company> companyList = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> Company.builder()
                        .name(faker.company().name())
                        .location(faker.address().fullAddress())
                        .technologies(
                                IntStream.rangeClosed(1, random.nextInt(1, 5))
                                        .mapToObj(j -> technologyList.get(random.nextInt(technologyList.size()-1))).collect(Collectors.toSet())
                        )
                        .build()).toList();
        
        
        tagService.addTags(tagList);
        technologyService.addTechologies(technologyList);
        companyService.addCompanies(companyList);
    }
}
