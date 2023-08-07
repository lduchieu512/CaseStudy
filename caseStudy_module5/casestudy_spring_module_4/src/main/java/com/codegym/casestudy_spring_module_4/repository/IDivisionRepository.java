package com.codegym.casestudy_spring_module_4.repository;

import com.codegym.casestudy_spring_module_4.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
