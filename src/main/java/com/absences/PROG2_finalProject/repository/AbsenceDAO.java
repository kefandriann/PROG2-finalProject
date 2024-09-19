package com.absences.PROG2_finalProject.repository;

import com.absences.PROG2_finalProject.entity.Absence;
import com.absences.PROG2_finalProject.entity.CourseUnit;
import com.absences.PROG2_finalProject.entity.Student;
import com.absences.PROG2_finalProject.service.CourseUnitService;
import com.absences.PROG2_finalProject.service.StudentService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbsenceDAO {
    private DatabaseConnection db;
    private StudentService studentService;
    private CourseUnitService courseService;

    public AbsenceDAO(DatabaseConnection db, StudentService studentService) {
        this.db = db;
        this.studentService = studentService;
    }

    public void addAbsence(String studentId, Absence absence) throws SQLException {
        String sql = "INSERT INTO absence (absence_id, absence_date, is_valid, student_id, course_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, absence.getAbsenceId());
            statement.setObject(2, absence.getAbsenceDate());
            statement.setBoolean(3, absence.isValid());
            statement.setString(4, studentId);
            statement.setString(5, absence.getCourseUnit().getCourseId());
            statement.executeUpdate();
        }
    }

    public List<Absence> getStudentAbsences(String studentId) throws SQLException {
        List<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM absence WHERE student_id = ?";
        Student student = null;
        CourseUnit courseUnit = null;
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, studentId);
            try (ResultSet res = statement.executeQuery()) {
                for(Student s : studentService.getAllStudents()){
                    if (Objects.equals(s.getStudentId(), res.getString("student_id"))){
                        student = s;
                    }
                }
                for(CourseUnit c : courseService.getAllCourses()){
                    if (Objects.equals(c.getCourseId(), res.getString("course_id"))){
                        courseUnit = c;
                    }
                }
                while (res.next()) {
                    absences.add(new Absence(
                            res.getString("absence_id"),
                            res.getObject("absence_date", LocalDate.class),
                            res.getBoolean("is_valid"),
                            student,
                            courseUnit
                    ));
                }
            }
        }
        return absences;
    }

    public Absence getAbsenceByIdForStudent(String studentId, String absenceId) throws SQLException {
        String sql = "SELECT * FROM absence WHERE student_id = ? AND absence_id = ?";
        Student student = null;
        CourseUnit courseUnit = null;
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, studentId);
            statement.setString(2, absenceId);
            try (ResultSet res = statement.executeQuery()) {
                for(Student s : studentService.getAllStudents()){
                    if (Objects.equals(s.getStudentId(), res.getString("student_id"))){
                        student = s;
                    }
                }
                for(CourseUnit c : courseService.getAllCourses()){
                    if (Objects.equals(c.getCourseId(), res.getString("course_id"))){
                        courseUnit = c;
                    }
                }
                if (res.next()) {
                    return new Absence(
                            res.getString("absence_id"),
                            res.getObject("absence_date", LocalDate.class),
                            res.getBoolean("is_valid"),
                            student,
                            courseUnit
                    );
                }
            }
        }
        return null;
    }

    public void deleteAbsence(String studentId, String absenceId) throws SQLException {
        String sql = "DELETE FROM absence WHERE student_id = ? AND absence_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, studentId);
            statement.setString(2, absenceId);
            statement.executeUpdate();
        }
    }
}
