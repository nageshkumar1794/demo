package com.example.demo.override;

public class CollegeCourse {

    private String departmentName;
    private int courseNumber;

    public CollegeCourse(String departmentName, int  courseNumber) {

        if (departmentName == null || departmentName.isEmpty() || departmentName.length() > 4) {
            throw new IllegalArgumentException("Department name cannot be null or empty or longer than 4 characters");
        }

        if (courseNumber <1600 || courseNumber > 4000) {
            throw new IllegalArgumentException("Course number must be between 1600 and 4000");
        }

        this.departmentName = departmentName;
        this.courseNumber = courseNumber;

    }
    public String getDepartmentName() {
        return departmentName;
    }

    public int courseNumber() {
        return courseNumber;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setCourseName(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String toString() {
        return "CollegeCourse{" +
                "departmentName='" + departmentName + '\'' +
                ", courseNumber='" +  + '\'' +
                '}';
    }

}
