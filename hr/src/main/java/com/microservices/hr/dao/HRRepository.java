package com.microservices.hr.dao;

import com.microservices.hr.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRRepository extends JpaRepository<HR,Integer> {
}
