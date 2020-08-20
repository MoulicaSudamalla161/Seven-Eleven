package com.microservices.hr.service;

import com.microservices.hr.dao.HRRepository;
import com.microservices.hr.model.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRService {
    @Autowired
    HRRepository repository;

    public String saveEmployee(HR hr) {
        repository.save(hr);
//        System.out.println("adsfdg");
        return "saved successfully";
    }

    public List<HR> getEmployee() {
        return repository.findAll();
    }


    public HR getEmployeeById(int id) {
        HR h = repository.findAll().stream()
                .filter(hr -> id == hr.getId())
                .findAny()
                .orElse(null);
//        System.out.println(h.getId());
        return h;

    }

}
