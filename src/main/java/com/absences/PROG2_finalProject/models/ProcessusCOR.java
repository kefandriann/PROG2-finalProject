package com.absences.PROG2_finalProject.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProcessusCOR {
    private String processusId;
    private String commentary;
    private LocalDate beginningDate;
    private LocalDate endingDate;
    private Student student;
    private Step step;

    public ProcessusCOR(Student student, Step step, LocalDate beginningDate) {
        this.student = student;
        this.step = step;
        this.beginningDate = beginningDate;
    }

    public void nextStep(){
        if (step == Step.CONVOCATION){
            step = Step.OBSERVATION;
        }
        else if (step == Step.OBSERVATION){
            step = Step.EXPELL;
        }
    }

    public void close(){
        step = Step.CLOSED;
    }
}
