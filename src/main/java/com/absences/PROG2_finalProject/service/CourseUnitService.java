package com.absences.PROG2_finalProject.service;

import com.absences.PROG2_finalProject.entity.CourseUnit;
import com.absences.PROG2_finalProject.repository.CourseUnitDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CourseUnitService {
    private CourseUnitDAO courseUnitDAO;

    public CourseUnitService(CourseUnitDAO courseUnitDAO) {
        this.courseUnitDAO = courseUnitDAO;
    }

    public void createCourse(CourseUnit courseUnit) throws SQLException {
        courseUnitDAO.addCourse(courseUnit);
    }

    public List<CourseUnit> getAllCourses() throws SQLException {
        return courseUnitDAO.getAllCourseUnits();
    }

    public CourseUnit getCourseUnitById(String courseId) throws SQLException {
        return courseUnitDAO.getCourseById(courseId);
    }

    public void deleteCourseUnit(String courseId) throws SQLException {
        courseUnitDAO.deleteCourse(courseId);
    }
}
