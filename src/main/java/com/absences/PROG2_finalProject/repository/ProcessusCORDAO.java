package com.absences.PROG2_finalProject.repository;

import com.absences.PROG2_finalProject.entity.ProcessusCOR;
import com.absences.PROG2_finalProject.entity.Step;
import com.absences.PROG2_finalProject.entity.Student;
import com.absences.PROG2_finalProject.service.StudentService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessusCORDAO {
    private DatabaseConnection db;
    private StudentService studentService;

    public ProcessusCORDAO(DatabaseConnection db, StudentService studentService) {
        this.db = db;
        this.studentService = studentService;
    }

    public void addProcessus(String studentId, ProcessusCOR processusCOR) throws SQLException {
        String sql = "INSERT INTO processus_cor (processus_id, commentary, beginning_date, ending_date, student_id, step) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, processusCOR.getProcessusId());
            statement.setString(2, processusCOR.getCommentary());
            statement.setObject(3, processusCOR.getBeginningDate());
            statement.setObject(4, processusCOR.getEndingDate());
            statement.setString(5, studentId);
            statement.setString(6, processusCOR.getStep().name());
            statement.executeUpdate();
        }
    }

    public List<ProcessusCOR> getStudentProcessus(String studentId) throws SQLException {
        List<ProcessusCOR> processusCORList = new ArrayList<>();
        String sql = "SELECT * FROM processus_cor WHERE student_id = ?";
        Student student = null;
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, studentId);
            try (ResultSet res = statement.executeQuery()) {
                for(Student s : studentService.getAllStudents()){
                    if(Objects.equals(s.getStudentId(), res.getString("student_id"))){
                        student = s;
                    }
                }
                while (res.next()) {
                    processusCORList.add(new ProcessusCOR(
                            res.getString("processus_id"),
                            res.getString("commentary"),
                            res.getObject("beginning_date", LocalDate.class),
                            res.getObject("ending_date", LocalDate.class),
                            student,
                            Step.valueOf(res.getString("step"))
                    ));
                }
            }
        }
        return processusCORList;
    }

    public ProcessusCOR getProcessusById(String studentId, String processusId) throws SQLException {
        String sql = "SELECT * FROM processus_cor WHERE student_id = ? AND processus_id = ?";
        Student student = null;
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, studentId);
            statement.setString(2, processusId);
            try (ResultSet res = statement.executeQuery()) {
                for(Student s : studentService.getAllStudents()){
                    if(Objects.equals(s.getStudentId(), res.getString("student_id"))){
                        student = s;
                    }
                }
                if (res.next()) {
                    return new ProcessusCOR(
                            res.getString("processus_id"),
                            res.getString("commentary"),
                            res.getObject("beginning_date", LocalDate.class),
                            res.getObject("ending_date", LocalDate.class),
                            student,
                            Step.valueOf(res.getString("step"))
                    );
                }
            }
        }
        return null;
    }

    public void deleteProcessus(String studentId, String processusId) throws SQLException {
        String sql = "DELETE FROM processus_cor WHERE student_id = ? AND processus_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, studentId);
            statement.setString(2, processusId);
            statement.executeUpdate();
        }
    }
}
