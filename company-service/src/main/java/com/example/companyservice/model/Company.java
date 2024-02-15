package com.example.companyservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private Long cid;
    private String name;
    private String domain;
    private String location;
    private List<String> students;
}
