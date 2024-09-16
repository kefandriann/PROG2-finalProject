package com.absences.PROG2_finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class Person {
    private String firstName;
    private String lastName;
}
