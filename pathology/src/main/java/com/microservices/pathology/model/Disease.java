package com.microservices.pathology.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;
    private String disease;
    private  String treatment;
}
