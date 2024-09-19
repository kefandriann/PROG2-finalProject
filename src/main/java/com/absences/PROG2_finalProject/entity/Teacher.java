package com.absences.PROG2_finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class Teacher extends Person {
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }
}
