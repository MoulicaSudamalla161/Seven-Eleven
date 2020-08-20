package com.microservices.pathology.dao;

import com.microservices.pathology.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease,Integer> {
}
