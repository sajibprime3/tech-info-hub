package com.dark.techinfo.company;

import com.dark.techinfo.technology.Technology;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    Long id;
    
    String name;
    
    String location;
    
    
    
    @ManyToMany
    @JoinTable(
            name = "company_technology",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    Set<Technology> technologies;
    
    
    
}
