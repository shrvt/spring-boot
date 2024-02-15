package com.example.studentservice.repository;

import com.example.studentservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> studentList = new ArrayList<>();

    public Student addStudent(Student student) {
        studentList.stream().filter(s -> s.sid().equals(student.sid())).findAny().ifPresentOrElse(
                s -> {
                },
                () -> studentList.add(student)
        );
        return student;
    }

    public List<Student> findStudentsByPlacementCompanyId(Long placementCompanyId) {
        return studentList
                .stream()
                .filter(student -> placementCompanyId.equals(student.placementCompanyId()))
                .collect(Collectors.toList());
    }

    public List<Student> findAll() {
        return studentList;
    }

}
