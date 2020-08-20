package com.microservices.administration.model;

import java.util.List;

public class DiagnosisList {

    public String serverOff(){
        return "Server unavailable right now";
    }

    public List<Disease> diseaseList;

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    @Override
    public String toString() {

//        DiagnosisList dl =new DiagnosisList();
//         dl.serverOff();
        return  serverOff();
    }
}
