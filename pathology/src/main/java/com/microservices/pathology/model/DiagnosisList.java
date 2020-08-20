package com.microservices.pathology.model;

import java.util.List;

public class DiagnosisList {

    public List<Disease> diseaseList;

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }


    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }



}
