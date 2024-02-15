package com.example.studentservice.model;

import java.util.List;

public record Student(Long sid, String name, String gender, List<String> languages, Long placementCompanyId) {
}
