package com.absences.PROG2_finalProject.controller;

import com.absences.PROG2_finalProject.entity.Absence;
import com.absences.PROG2_finalProject.service.AbsenceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.sql.SQLException;

@RestController
@RequestMapping("/students/{studentId}/absences")
public class AbsenceController {
    private AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping
    public String createAbsence(@PathVariable String studentId, @RequestBody Absence absence) throws SQLException {
        absenceService.createAbsence(studentId, absence);
        return "Absence created";
    }

    @GetMapping
    public List<Absence> getAllAbsences(@PathVariable String studentId) throws SQLException {
        return absenceService.getAllAbsencesForStudent(studentId);
    }

    @GetMapping("/{absenceId}")
    public Absence getAbsenceById(@PathVariable String studentId, @PathVariable String absenceId) throws SQLException {
        return absenceService.getAbsenceByIdForStudent(studentId, absenceId);
    }

    @DeleteMapping("/{absenceId}")
    public String deleteAbsence(@PathVariable String studentId, @PathVariable String absenceId) throws SQLException {
        absenceService.deleteAbsenceForStudent(studentId, absenceId);
        return "Absence deleted";
    }
}