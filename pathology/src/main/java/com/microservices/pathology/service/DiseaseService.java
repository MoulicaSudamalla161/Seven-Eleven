package com.microservices.pathology.service;

import com.microservices.pathology.dao.DiseaseRepository;
import com.microservices.pathology.model.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    public String saveDisease(Disease disease) {
        diseaseRepository.save(disease);
        return "saved succefully";
    }

    public Disease getDiseaseById(int id) {
        return diseaseRepository.findById(id).orElse(null);
    }

    public List<Disease> getList() {
        return diseaseRepository.findAll();
    }
}
