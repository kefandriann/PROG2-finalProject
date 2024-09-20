package com.absences.PROG2_finalProject.controller;

import com.absences.PROG2_finalProject.service.ProcessusCORService;
import com.absences.PROG2_finalProject.entity.ProcessusCOR;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/ProcessusCOR")
public class ProcessusCORController {
    private ProcessusCORService processusCORService;

    public ProcessusCORController(ProcessusCORService processusCORService) {
        this.processusCORService = processusCORService;
    }

    // Create a new ProcessusCOR
    @PostMapping
    public String createProcessusCOR(@PathVariable String studentId, @RequestBody ProcessusCOR processusCOR) throws SQLException {
        processusCORService.createProcessus(studentId, processusCOR);
        return "ProcessusCOR created";
    }

    // Get all ProcessusCOR for a student
    @GetMapping
    public List<ProcessusCOR> getAllProcessusCORByStudentId(@PathVariable String studentId) throws SQLException {
        return processusCORService.getStudentProcessus(studentId);
    }

    // Get a specific ProcessusCOR by ID
    @GetMapping("/{processusId}")
    public ProcessusCOR getProcessusCORById(@PathVariable String studentId, @PathVariable String processusId) throws SQLException {
        return processusCORService.getProcessusById(studentId, processusId);
    }

    // Delete a specific ProcessusCOR by ID
    @DeleteMapping("/{processusId}")
    public String deleteProcessusCOR(@PathVariable String studentId, @PathVariable String processusId) throws SQLException {
        processusCORService.deleteProcessus(studentId, processusId);
        return "ProcessusCOR deleted";
    }
}
