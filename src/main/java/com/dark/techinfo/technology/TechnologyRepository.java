package com.dark.techinfo.technology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
    
    @Query("SELECT t FROM Technology t WHERE (:idList IS NOT NULL AND t.id IN :idList)")
    List<Technology> getTechnologiesById(@Param("idList") List<Long> idList);
    
    Technology getTechnoLogyById(Long id);
    
}
