package com.dark.techinfo.technology;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.tag.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Technology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    Long id;
    
    String name;
    
    String imageUrl;
    
    @ManyToMany(mappedBy = "technologies")
    List<Company> companies;
    
    @ManyToMany
    @JoinTable(
            name = "technology_tag",
            joinColumns = @JoinColumn(name = "technology_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    List<Tag> tags;
    
    
    
    
}
