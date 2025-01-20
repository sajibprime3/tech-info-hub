package com.dark.techinfo.technology;

import com.dark.techinfo.company.Company;
import com.dark.techinfo.tag.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    Long id;
    
    String imageUrl;
    
    @ManyToMany(mappedBy = "technologies")
    Set<Company> companies;
    
    @ManyToMany
    @JoinTable(
            name = "technology_tag",
            joinColumns = @JoinColumn(name = "technology_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tags;
    
    
    
    
}
