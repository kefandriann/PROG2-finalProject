package com.absences.PROG2_finalProject.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CourseUnit {
    private String courseId;
    private Teacher teacher;
}
