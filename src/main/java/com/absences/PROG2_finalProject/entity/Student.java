package com.absences.PROG2_finalProject.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String studentId;
    private Group group;
    private Status status;
    private List<Absence> absences;
    private ProcessusCOR processusCORs;

    public void addAbsence (Absence absence){
        this.absences.add(absence);
    }

    public List<Absence> getInvalidAbsences () {
        List<Absence> invalidAbsences = new ArrayList<>();
        invalidAbsences = this.absences.stream().filter(Absence::isValid).toList();
        return invalidAbsences;
    }

    public void verifyProcessusCOR () {
        if (this.getInvalidAbsences().size() >= 3 && processusCORs == null){
            processusCORs = new ProcessusCOR(this, Step.CONVOCATION, LocalDate.now());
        }
    }
}
