package com.absences.PROG2_finalProject.repository;

import com.absences.PROG2_finalProject.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherDAO {
    private DatabaseConnection db;

    public TeacherDAO(DatabaseConnection db) {
        this.db = db;
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        String sql = "INSERT INTO teacher (teacher_id, first_name, last_name) VALUES (?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, teacher.getTeacherId());
            statement.setString(2, teacher.getFirstName());
            statement.setString(3, teacher.getLastName());
            statement.executeUpdate();
        }
    }

    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teacher";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql);
             ResultSet res = statement.executeQuery()) {
            while (res.next()) {
                teachers.add(new Teacher(
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("teacher_id")
                ));
            }
        }
        return teachers;
    }

    public Teacher getTeacherById(String teacherId) throws SQLException {
        String sql = "SELECT * FROM teacher WHERE teacher_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, teacherId);
            try (ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    return new Teacher(
                            res.getString("first_name"),
                            res.getString("last_name"),
                            res.getString("teacher_id")
                    );
                }
            }
        }
        return null;
    }

    public void deleteTeacher(String teacherId) throws SQLException {
        String sql = "DELETE FROM teacher WHERE teacher_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, teacherId);
            statement.executeUpdate();
        }
    }
}
