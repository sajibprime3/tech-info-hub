package com.dark.techinfo.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    List<Company> findCompanyByNameContainsIgnoreCase(String name);
    
    @Query("SELECT DISTINCT c FROM Company c WHERE (:companyName IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :companyName, '%')))")
    List<Company> findByCompanyName(@Param("companyName") String companyName);

    @Query("SELECT DISTINCT c FROM Company c JOIN FETCH c.technologies t JOIN FETCH t.tags tag WHERE LOWER(tag.name) LIKE LOWER(CONCAT('%', :tagName, '%'))")
    List<Company> findByTagName(@Param("tagName") String tagName);

    @Query("SELECT DISTINCT c FROM Company c " +
            "JOIN FETCH c.technologies t " +
            "JOIN FETCH t.tags tag " +
            "WHERE (:tagNames IS NOT NULL AND LOWER(tag.name) IN :tagNames)")
    List<Company> findByTagNames(@Param("tagNames") List<String> tagNames);
    
}
