package com.microservices.hr.controller;

import com.microservices.hr.model.HR;
import com.microservices.hr.model.PhysicianList;
import com.microservices.hr.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HRController {

    @Autowired
    private HRService hrService;

    @PostMapping("/saveemployee")
    public  String saveEmployee(@RequestBody HR hr) {
        return hrService.saveEmployee(hr);
    }


    @GetMapping("/getemployee")
    public PhysicianList getEmployee() {
         PhysicianList physicianList = new PhysicianList();
         physicianList.setHrs(hrService.getEmployee());
         return physicianList;
//        return hrService.getEmployee();
    }

    @GetMapping("/getemployeebyId/{id}")
    public HR getEmployeeById(@PathVariable int id) {
        return hrService.getEmployeeById(id);
    }
}

