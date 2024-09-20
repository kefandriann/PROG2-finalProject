package com.absences.PROG2_finalProject.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CourseUnit {
    private String courseId;
    private Teacher teacher;

    public CourseUnit(String courseId, Teacher teacher) {
        this.courseId = courseId;
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
