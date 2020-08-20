package com.microservices.hr.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HR {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;
    private String name;
    private int experience;
    private String designation;




}