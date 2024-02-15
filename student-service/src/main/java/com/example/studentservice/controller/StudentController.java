package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @GetMapping("/company/{pcid}")
    public List<Student> findStudentsByPlacementCompanyId(@PathVariable Long pcid) {
        return studentRepository.findStudentsByPlacementCompanyId(pcid);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
