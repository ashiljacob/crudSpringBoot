package com.example.crudRestApi.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String gstin;
    private float outstandingBalance;

    public static String customerNotFound(){
        return "Not Found";
    }
}
