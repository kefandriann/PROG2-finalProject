package com.absences.PROG2_finalProject.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class Student extends Person {
    private String studentId;
    private Group group;
    private Status status;
    private List<Absence> absences;
    private ProcessusCOR processusCOR;

    public Student(String firstName, String lastName, String studentId, Group group, Status status) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.group = group;
        this.status = status;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public void setProcessusCOR(ProcessusCOR processusCOR) {
        this.processusCOR = processusCOR;
    }

    public String getStudentId() {
        return studentId;
    }

    public Group getGroup() {
        return group;
    }

    public Status getStatus() {
        return status;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public ProcessusCOR getProcessusCOR() {
        return processusCOR;
    }

    public void addAbsence (Absence absence){
        this.absences.add(absence);
    }

    public List<Absence> getInvalidAbsences () {
        List<Absence> invalidAbsences = new ArrayList<>();
        invalidAbsences = this.absences.stream().filter(Absence::isValid).toList();
        return invalidAbsences;
    }

    public void verifyProcessusCOR () {
        if (this.getInvalidAbsences().size() >= 3 && processusCOR == null){
            processusCOR = new ProcessusCOR(this, Step.CONVOCATION, LocalDate.now());
        }
    }
}
