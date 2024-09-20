package com.absences.PROG2_finalProject.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@EqualsAndHashCode
public class ProcessusCOR {
    private String processusId;
    private String commentary;
    private LocalDate beginningDate;
    private LocalDate endingDate;
    private Student student;
    private Step step;

    public ProcessusCOR(String processusId, Student student, Step step, LocalDate beginningDate) {
        this.processusId = processusId;
        this.student = student;
        this.step = step;
        this.beginningDate = beginningDate;
    }

    public ProcessusCOR(String processusId, String commentary, LocalDate beginningDate, LocalDate endingDate, Student student, Step step) {
        this.processusId = processusId;
        this.commentary = commentary;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.student = student;
        this.step = step;
    }

    public String getProcessusId() {
        return processusId;
    }

    public String getCommentary() {
        return commentary;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public Student getStudent() {
        return student;
    }

    public Step getStep() {
        return step;
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
