package com.example.demo.override;

public class CaseReport {
    String caseId;
    String patientName;
    String diagnosis;
    String facility;
    String reportDate;
    boolean isConfirmed;

    public CaseReport(String caseId, String patientName, String diagnosis, String facility, String reportDate, boolean isConfirmed) {
        this.caseId = caseId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.facility = facility;
        this.reportDate = reportDate;
        this.isConfirmed = isConfirmed;
    }
}
