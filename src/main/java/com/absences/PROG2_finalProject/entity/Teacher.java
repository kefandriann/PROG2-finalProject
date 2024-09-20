package com.absences.PROG2_finalProject.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

@Setter
@EqualsAndHashCode(callSuper=false)
public class Teacher extends Person {
    private String teacherId;

    public Teacher(String firstName, String lastName, String teacherId) {
        super(firstName, lastName);
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }
}
