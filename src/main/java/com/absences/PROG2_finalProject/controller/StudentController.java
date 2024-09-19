package com.absences.PROG2_finalProject.controller;

import com.absences.PROG2_finalProject.entity.Student;
import com.absences.PROG2_finalProject.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) throws SQLException {
        studentService.createStudent(student);
        return "Student created";
    }

    @GetMapping
    public List<Student> getAllStudent () throws SQLException {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable String studentId) throws SQLException {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public String updateStudent(@PathVariable String studentId, @RequestBody Student student) throws SQLException {
        studentService.updateStudent(studentId, student);
        return "Student updated";
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable String studentId) throws SQLException {
        studentService.deleteStudent(studentId);
        return "Student deleted";
    }
}
