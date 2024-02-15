package com.example.companyservice.controller;

import com.example.companyservice.model.Company;
import com.example.companyservice.repository.CompanyRepository;
import com.example.companyservice.services.DataExchangeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(CompanyController.class);
    private final DataExchangeClient dataExchangeClient;

    private final CompanyRepository companyRepository;

    public CompanyController(DataExchangeClient dataExchangeClient, CompanyRepository companyRepository) {
        this.dataExchangeClient = dataExchangeClient;
        this.companyRepository = companyRepository;
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        LOGGER.info("company added {}", company);
        return companyRepository.addCompany(company);
    }

    @GetMapping("/{cid}")
    public Company findById(@PathVariable Long cid) {
        LOGGER.info("find company id={}", cid);
        return companyRepository.findById(cid);
    }

    @GetMapping
    public List<Company> findALl() {
        LOGGER.info("find all companies");
        return companyRepository.findALl();
    }

    @GetMapping("/complete")
    public List<Company> findAllCompaniesWithStudentsPlaced() {
        return this.dataExchangeClient.findAllCompaniesWithStudentsPlaced();
    }
}
