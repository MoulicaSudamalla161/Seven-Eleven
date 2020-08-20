package com.microservices.pathology.controller;

import com.microservices.pathology.model.DiagnosisList;
import com.microservices.pathology.model.Disease;
import com.microservices.pathology.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @PostMapping("/saveDisease")
    public String saveDisease(@RequestBody Disease disease) {
        return  diseaseService.saveDisease(disease);

    }
    @GetMapping("/getDiseasesList")
    public DiagnosisList  getDiseaseList() {
             DiagnosisList diagnosisList = new DiagnosisList();
             diagnosisList.setDiseaseList(diseaseService.getList());
             return diagnosisList;
//        return diseaseService.getList();
    }
    @GetMapping("/getDiseaseById/{id}")
    public Disease getDiseaseById(@PathVariable int id) {
        return diseaseService.getDiseaseById(id);
    }
}
