package com.absences.PROG2_finalProject.service;

import com.absences.PROG2_finalProject.entity.Student;
import com.absences.PROG2_finalProject.repository.StudentDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void createStudent(Student student) throws SQLException {
        studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(String studentId) throws SQLException {
        return studentDAO.getStudentById(studentId);
    }

    public void updateStudent(String studentId, Student student) throws SQLException {
        studentDAO.updateSudent(studentId, student);
    }
    public void deleteStudent(String studentId) throws SQLException {
        studentDAO.deleteStudent(studentId);
    }
}
