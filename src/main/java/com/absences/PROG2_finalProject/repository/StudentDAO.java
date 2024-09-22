package com.absences.PROG2_finalProject.repository;

import com.absences.PROG2_finalProject.entity.Group;
import com.absences.PROG2_finalProject.entity.ProcessusCOR;
import com.absences.PROG2_finalProject.entity.Status;
import com.absences.PROG2_finalProject.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO {
    private DatabaseConnection db;

    public StudentDAO(DatabaseConnection db) {
        this.db = db;
    }

    public void verifyProcessusCOR (ProcessusCOR processusCOR) throws SQLException {
        String sql = "INSERT INTO processus_cor (processus_id, student_id, step, beginning_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)){
            statement.setString(1, processusCOR.getProcessusId());
            statement.setString(2, processusCOR.getStudent().getStudentId());
            statement.setString(3, processusCOR.getStep().toString());
            statement.setObject(4, processusCOR.getBeginningDate());
            statement.executeUpdate();
        }
    }

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student (first_name, last_name, student_id, group, status, processus_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)){
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getStudentId());
            statement.setString(4, student.getGroup().toString());
            statement.setString(5, student.getStatus().toString());
            statement.setString(6, student.getProcessusCOR().getProcessusId());
            statement.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql);
             ResultSet res = statement.executeQuery()){
            while (res.next()){
                students.add(new Student(
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("student_id"),
                        Group.valueOf(res.getString("group")),
                        Status.valueOf(res.getString("status"))
                ));
            }
        }
        return students;
    }

    public Student getStudentById(String studentId) throws SQLException {
        String sql = "SElECT * FROM student WHERE student_id = ?";
        try(PreparedStatement statement = db.getConnection().prepareStatement(sql)){
            statement.setString(1, studentId);
            try (ResultSet res = statement.executeQuery()){
                if (res.next()){
                    return new Student(
                            res.getString("first_name"),
                            res.getString("last_name"),
                            res.getString("student_id"),
                            Group.valueOf(res.getString("group")),
                            Status.valueOf(res.getString("status"))
                    );
                }
            }
        }
        return null;
    }

    public void updateSudent(String studentId, Student student) throws SQLException {
        String sql = "UPDATE student SET first_name = ?, last_name = ?, group = ?, status = ? WHERE student_id = ?";
        try(PreparedStatement statement = db.getConnection().prepareStatement(sql)){
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getGroup().toString());
            statement.setString(4, student.getStatus().toString());
            statement.setString(5, studentId);
            statement.executeUpdate();
        }
    }

    public void deleteStudent(String studentId) throws SQLException {
        String sql = "DELETE FROM student WHERE student_id = ?";
        try(PreparedStatement statement = db.getConnection().prepareStatement(sql)){
            statement.setString(1, studentId);
            statement.executeUpdate();
        }
    }
}
