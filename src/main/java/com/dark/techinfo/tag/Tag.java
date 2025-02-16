package com.dark.techinfo.tag;

import com.dark.techinfo.technology.Technology;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String name;
    
    @ManyToMany(mappedBy = "tags")
    List<Technology> technologies;

    public Tag(String name, List<Technology> technologies) {
        this.name = name;
        this.technologies = technologies;
    }

    public Tag(String name) {
        this.name = name;
    }
}
