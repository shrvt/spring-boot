package com.example.companyservice.repository;

import com.example.companyservice.model.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {

    private final List<Company> companyList = new ArrayList<>();

    public Company addCompany(Company company) {
        companyList.stream().filter(c -> c.getCid().equals(company.getCid())).findAny().ifPresentOrElse(
                s -> {
                },
                () -> companyList.add(company)
        );
        return company;
    }

    public Company findById(Long cid) {
        return companyList.stream().filter(company -> cid.equals(company.getCid())).findFirst().orElseThrow();
    }

    public List<Company> findALl() {
        return companyList;
    }
}
