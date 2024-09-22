package com.absences.PROG2_finalProject.repository;

import com.absences.PROG2_finalProject.entity.CourseUnit;
import com.absences.PROG2_finalProject.entity.Teacher;
import com.absences.PROG2_finalProject.service.TeacherService;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CourseUnitDAO {
    private DatabaseConnection db;
    private TeacherService teacherService;

    public CourseUnitDAO(DatabaseConnection db, TeacherService teacherService) {
        this.db = db;
        this.teacherService = teacherService;
    }

    public void addCourse(CourseUnit courseUnit) throws SQLException {
        String sql = "INSERT INTO course_unit (course_id, teacher_id) VALUES (?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, courseUnit.getCourseId());
            statement.setString(2, courseUnit.getTeacher().getTeacherId());
            statement.executeUpdate();
        }
    }

    public List<CourseUnit> getAllCourseUnits() throws SQLException {
        List<CourseUnit> courseUnits = new ArrayList<>();
        String sql = "SELECT * FROM course_unit";
        Teacher teacher = null;
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql);
             ResultSet res = statement.executeQuery()) {
            for(Teacher t : teacherService.getAllTeachers()){
                if (Objects.equals(t.getTeacherId(), res.getString("teacher_id"))){
                    teacher = t;
                }
            }
            while (res.next()) {
                courseUnits.add(new CourseUnit(
                        res.getString("course_id"),
                        teacher
                ));
            }
        }
        return courseUnits;
    }

    public CourseUnit getCourseById(String courseId) throws SQLException {
        String sql = "SELECT * FROM course_unit WHERE course_id = ?";
        Teacher teacher = null;
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, courseId);
            try (ResultSet res = statement.executeQuery()) {
                for(Teacher t : teacherService.getAllTeachers()){
                    if (Objects.equals(t.getTeacherId(), res.getString("teacher_id"))){
                        teacher = t;
                    }
                }
                if (res.next()) {
                    return new CourseUnit(
                            res.getString("course_id"),
                            teacher
                    );
                }
            }
        }
        return null;
    }

    public void deleteCourse(String courseId) throws SQLException {
        String sql = "DELETE FROM course_unit WHERE course_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, courseId);
            statement.executeUpdate();
        }
    }
}
