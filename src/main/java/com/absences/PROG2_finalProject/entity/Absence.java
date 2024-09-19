package com.absences.PROG2_finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@EqualsAndHashCode
public class Absence {
    private String absenceId;
    private LocalDate absenceDate ;
    private boolean isValid;
    private CourseUnit courseUnit;
    private Student student;

    public Absence(String absenceId, LocalDate absenceDate, boolean isValid, Student student, CourseUnit courseUnit) {
        this.absenceId = absenceId;
        this.absenceDate = absenceDate;
        this.isValid = isValid;
        this.courseUnit = courseUnit;
        this.student = student;
    }

    public void setAbsenceId(String absenceId) {
        this.absenceId = absenceId;
    }

    public void setAbsenceDate(LocalDate absenceDate) {
        this.absenceDate = absenceDate;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setCourseUnit(CourseUnit courseUnit) {
        this.courseUnit = courseUnit;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAbsenceId() {
        return absenceId;
    }

    public LocalDate getAbsenceDate() {
        return absenceDate;
    }

    public CourseUnit getCourseUnit() {
        return courseUnit;
    }

    public Student getStudent() {
        return student;
    }

    public boolean isValid () {
        return isValid;
    }
}
