package com.example.demo.override;

import java.util.ArrayList;
import java.util.List;

public class CollegeCourseTester {
    public static void main(String[] args) {

        List<CollegeCourse> schedule = new ArrayList<>();

        CollegeCourse course1 = new CollegeCourse("Mathematics", 2400);
        CollegeCourse course2 = new CollegeCourse("Physics", 3212);

        ClassSection section1 = new ClassSection("Mathematics", 2400, 201, "TTh 9:00-10:30");

        schedule.add(course1);
        schedule.add(course2);
        schedule.add(section1);

        for (CollegeCourse course : schedule) {
            System.out.println(course.toString());
        }

        printCourses(schedule);

    }

    public static void printCourses(List<CollegeCourse> courses) {
        for (CollegeCourse course : courses) {
            System.out.println(course);
        }
    }
}
