package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = {"students", "students_and_company"}, allEntries = true)
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @GetMapping("/company/{pcid}")
    @Cacheable(value = "students_and_company")
    public List<Student> findStudentsByPlacementCompanyId(@PathVariable Long pcid) {
        return studentRepository.findStudentsByPlacementCompanyId(pcid);
    }

    @GetMapping
    @Cacheable(value = "students")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
