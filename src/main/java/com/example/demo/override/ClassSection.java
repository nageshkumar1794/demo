package com.example.demo.override;

public class ClassSection extends CollegeCourse {

    private int sectionNumber;
    private String meetingTime;

    public ClassSection(String departmentName, int courseNumber, int sectionNumber, String meetingTime) {
        super(departmentName, courseNumber);
        this.sectionNumber = sectionNumber;
        this.meetingTime = meetingTime;
    }
    public int getSectionNumber() {
        return sectionNumber;
    }
    public String getMeetingTime() {
        return meetingTime;
    }
    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String toString() {
        return "ClassSection{" +
                "departmentName='" + getDepartmentName() + '\'' +
                ", courseName='" + courseNumber() + '\'' +
                ", sectionNumber=" + sectionNumber +
                ", meetingTime='" + meetingTime + '\'' +
                '}';
    }

}
