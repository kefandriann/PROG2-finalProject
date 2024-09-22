package com.absences.PROG2_finalProject.service;

import com.absences.PROG2_finalProject.entity.Absence;
import com.absences.PROG2_finalProject.repository.AbsenceDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AbsenceService {
    private AbsenceDAO absenceDAO;

    public AbsenceService(AbsenceDAO absenceDAO) {
        this.absenceDAO = absenceDAO;
    }

    public void createAbsence(String studentId, Absence absence) throws SQLException {
        absenceDAO.addAbsence(studentId, absence);
    }

    public List<Absence> getAllAbsencesForStudent(String studentId) throws SQLException {
        return absenceDAO.getStudentAbsences(studentId);
    }

    public Absence getAbsenceByIdForStudent(String studentId, String absenceId) throws SQLException {
        return absenceDAO.getAbsenceByIdForStudent(studentId, absenceId);
    }

    public void deleteAbsenceForStudent(String studentId, String absenceId) throws SQLException {
        absenceDAO.deleteAbsence(studentId, absenceId);
    }
}
