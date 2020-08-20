package com.microservices.administration.controller;


//import com.microservices.administration.config.MyUserDetailsService;
import com.microservices.administration.exception.PatientNotFoundException;
import com.microservices.administration.model.*;
import com.microservices.administration.service.AdminService;
//import com.microservices.administration.util.JwtTokenUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.method.P;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//    @Autowired
//    private JwtTokenUtil jwtUtil;

    @PostMapping("/savePatient")
    public String savePatient(@RequestBody Admin admin) {
        return adminService.savePatient(admin);
    }

    @GetMapping("/getPatientList")
    public List<Admin> getPatientList() {
        return adminService.getPatientList();
    }

    @GetMapping("/getPatientByContact/{contact}")
    public  Admin getByContact(@PathVariable int contactNumber) {
        return  adminService.getByContact(contactNumber);
    }

    @DeleteMapping("/deleteById/{id}")
    public String  deleteById(@PathVariable int id)  {
        return adminService.deleteById(id);
    }

    @PutMapping("/updateById/{id}")
    public Admin updateById(@PathVariable int id, @RequestBody Admin admin) {
//           Admin admin1 = adminService.updateById(id, admin);
           return  adminService.updateById(id,admin);
//           return   adminService.updateById(id,admin);
//            return admin1;
    }
    @GetMapping("/physicians")
    @HystrixCommand(fallbackMethod = "getFallBackPhysicianList")
    public PhysicianList getEmployee() {
          PhysicianList physicianList = restTemplate.getForObject("http://localhost:9082/getemployee",PhysicianList.class);
          return  physicianList;
    }

    @GetMapping("/remedy")
    @HystrixCommand(fallbackMethod = "getFallBackDiseaseList")
    public DiagnosisList getDiseaseList() {
        DiagnosisList dianosisList = restTemplate.getForObject("http://localhost:8081/getDiseasesList",DiagnosisList.class);
        return  dianosisList;
    }
    public PhysicianList getFallBackPhysicianList () {
//         List<HR> hrList = new ArrayList<E>(Arrays.asList("No","Id","found","in List"));
//        ArrayList<String > hrList = new ArrayList<>();
//         hrList.add("No Physicians available right now ");
//        return  "Server is unavailable right now";
        List<HR> hrs = new ArrayList<HR>();
//       / hrs.add(null);
        PhysicianList physicianList = new PhysicianList();
        physicianList.setHrs(Arrays.asList(new HR(0,"No Physicians found",0,"right now")));
        return physicianList;
    }
    public DiagnosisList getFallBackDiseaseList(){
        List<Disease> diseaseList = new ArrayList<Disease>();
        DiagnosisList diagnosisList = new DiagnosisList();
        diagnosisList.setDiseaseList(Arrays.asList(new Disease(0,"Server unavailable","Right now")));
//        return diagnosisList;
//        DiagnosisList diagnosisList = new DiagnosisList();
//           diagnosisList.serverOff();
//   System.out.println(diagnosisList);
        return  diagnosisList;
    }




}
