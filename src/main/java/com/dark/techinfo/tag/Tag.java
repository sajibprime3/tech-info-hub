package com.dark.techinfo.tag;

import com.dark.techinfo.technology.Technology;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String name;
    
    @ManyToMany(mappedBy = "tags")
    Set<Technology> technologies;
    
}
