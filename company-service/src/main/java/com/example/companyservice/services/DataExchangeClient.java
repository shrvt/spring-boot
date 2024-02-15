package com.example.companyservice.services;

import com.example.companyservice.model.Company;
import com.example.companyservice.model.Student;
import com.example.companyservice.repository.CompanyRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DataExchangeClient {

    private final RestClient restClient;
    private final CompanyRepository companyRepository;


    public DataExchangeClient(CompanyRepository companyRepository, EurekaClient eurekaClient) {
        this.companyRepository = companyRepository;
        final String studentServiceBaseUrl =
                eurekaClient.getNextServerFromEureka("student-service", false)
                        .getHomePageUrl();
        this.restClient = RestClient.builder()
                .baseUrl(studentServiceBaseUrl)
                .build();
    }

    public List<Company> findAllCompaniesWithStudentsPlaced() {
        final List<Student> studentList = this.restClient.get()
                .uri("/student")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Student>>() {
                });

        if (null == studentList || studentList.isEmpty()) {
            return null;
        }

        final List<Company> companyList = companyRepository.findALl();

        companyList.forEach(company -> {
            final List<String> studentNames = studentList
                    .stream()
                    .filter(student -> student.placementCompanyId().equals(company.getCid()))
                    .map(Student::name).toList();
            company.setStudents(studentNames);
        });
        return companyList;
    }
}
