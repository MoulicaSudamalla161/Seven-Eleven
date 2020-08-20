package com.microservices.administration.service;

import com.microservices.administration.dao.AdministrationRepository;
import com.microservices.administration.exception.PatientNotFoundException;
import com.microservices.administration.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService {
    @Autowired
    private AdministrationRepository administrationRepository;

    public String savePatient(Admin admin) {
        administrationRepository.save(admin);
        return "saved details succefully";
    }

    public List<Admin> getPatientList() {
        List<Admin> adminList = (List<Admin>)administrationRepository.findAll();
        if(adminList.size()>0)
            return  adminList;
        else
        return new ArrayList<Admin>();
    }

    public Admin getByContact(int contactNumber) {

        return administrationRepository.findByContactNumber(contactNumber);
    }

    public String  deleteById(int id)  {
//        List<Admin> adminList = administrationRepository.deleteById(id);
//        Admin admin =administrationRepository.findById(id)
//                .orElseThrow(()->new PatientNotFoundException("Id not found"));
//
//        if(admin!=null) {
//            administrationRepository.deleteById(id);
//            return  admin;
//        }
//
//        else
//          throw new PatientNotFoundException("Id is not available in the list");
        administrationRepository.deleteById(id);
        return "deleted succefully";

    }

    public Admin updateById(int id, Admin admin) {

        Admin a = administrationRepository.findById(id).orElse(null);
//        a.setId(admin.getId());
        a.setFirstName(admin.getFirstName());
        a.setLastName(admin.getLastName());
        a.setContactNumber(admin.getContactNumber());
        a.setBloodGroup(admin.getBloodGroup());
        Admin admin1 = administrationRepository.save(a);
        return admin1;
    }
}
