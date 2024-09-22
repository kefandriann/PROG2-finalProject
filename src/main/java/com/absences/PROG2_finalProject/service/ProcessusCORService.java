package com.absences.PROG2_finalProject.service;

import com.absences.PROG2_finalProject.entity.ProcessusCOR;
import com.absences.PROG2_finalProject.repository.ProcessusCORDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProcessusCORService {
    private ProcessusCORDAO processusCORDAO;

    public ProcessusCORService(ProcessusCORDAO processusCORDAO) {
        this.processusCORDAO = processusCORDAO;
    }

    public void createProcessus(String studentId, ProcessusCOR processusCOR) throws SQLException {
        processusCORDAO.addProcessus(studentId, processusCOR);
    }

    public List<ProcessusCOR> getStudentProcessus(String studentId) throws SQLException {
        return processusCORDAO.getStudentProcessus(studentId);
    }

    public ProcessusCOR getProcessusById(String studentId, String processusId) throws SQLException {
        return processusCORDAO.getProcessusById(studentId, processusId);
    }

    public void deleteProcessus(String studentId, String processusId) throws SQLException {
        processusCORDAO.deleteProcessus(studentId, processusId);
    }
}
