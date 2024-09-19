package com.absences.PROG2_finalProject.controller;

import com.absences.PROG2_finalProject.entity.CourseUnit;
import com.absences.PROG2_finalProject.service.CourseUnitService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CourseUnitController {
    private CourseUnitService courseUnitService;

    public CourseUnitController(CourseUnitService courseUnitService) {
        this.courseUnitService = courseUnitService;
    }

    @PostMapping
    public String createCourseUnit(@RequestBody CourseUnit courseUnit) throws SQLException {
        courseUnitService.createCourse(courseUnit);
        return "CourseUnit created";
    }

    @GetMapping
    public List<CourseUnit> getAllCourseUnits() throws SQLException {
        return courseUnitService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public CourseUnit getCourseUnitById(@PathVariable String courseId) throws SQLException {
        return courseUnitService.getCourseUnitById(courseId);
    }
    
    @DeleteMapping("/{courseId}")
    public String deleteCourseUnit(@PathVariable String courseId) throws SQLException {
        courseUnitService.deleteCourseUnit(courseId);
        return "CourseUnit deleted";
    }
}
