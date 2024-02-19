package com.example.companyservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Company implements Serializable {
    private Long cid;
    private String name;
    private String domain;
    private String location;
    private List<String> students;
}
