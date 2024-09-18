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
public class Absence {
    private String absenceId;
    private LocalDate absenceDate ;
    private boolean isValid;
    private CourseUnit courseUnit;
    private Student student;

    public boolean isValid () {
        return isValid;
    }
}
