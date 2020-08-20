package com.microservices.administration.dao;


import com.microservices.administration.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrationRepository extends JpaRepository<Admin, Integer> {
    Admin findByContactNumber(int contactNumber);
//    Admin findByContact(int contactNumber);
}
