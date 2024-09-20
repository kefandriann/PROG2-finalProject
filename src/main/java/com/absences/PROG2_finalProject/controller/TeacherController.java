package com.absences.PROG2_finalProject.controller;

import com.absences.PROG2_finalProject.entity.Teacher;
import com.absences.PROG2_finalProject.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public String createTeacher(@RequestBody Teacher teacher) throws SQLException {
        teacherService.createTeacher(teacher);
        return "Teacher created";
    }

    @GetMapping
    public List<Teacher> getAllTeachers() throws SQLException {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable String teacherId) throws SQLException {
        return teacherService.getTeacherById(teacherId);
    }

    // Delete a specific teacher by ID
    @DeleteMapping("/{teacherId}")
    public String deleteTeacher(@PathVariable String teacherId) throws SQLException {
        teacherService.deleteTeacher(teacherId);
        return "Teacher deleted";
    }
}
