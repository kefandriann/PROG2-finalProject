package com.absences.PROG2_finalProject.service;

import com.absences.PROG2_finalProject.entity.Teacher;
import com.absences.PROG2_finalProject.repository.TeacherDAO;

import java.sql.SQLException;
import java.util.List;

public class TeacherService {
    private TeacherDAO teacherDAO;

    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public void createTeacher(Teacher teacher) throws SQLException {
        teacherDAO.addTeacher(teacher);
    }

    public List<Teacher> getAllTeachers() throws SQLException {
        return teacherDAO.getAllTeachers();
    }

    public Teacher getTeacherById(String teacherId) throws SQLException {
        return teacherDAO.getTeacherById(teacherId);
    }

    public void deleteTeacher(String teacherId) throws SQLException {
        teacherDAO.deleteTeacher(teacherId);
    }
}
