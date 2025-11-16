package com.example.demo.ehr;

import java.util.function.Function;
import java.util.function.Predicate;

public class CaseReportProcessors {

    // a) Parse and Validate (simulate parsing)
    public static Function<String, CaseReport> parse = (line) -> {
        // Example CSV: providerId,patientId,condition,rawMessage
        String[] parts = line.split(",");
        if (parts.length < 4) throw new IllegalArgumentException("Invalid case report: " + line);
        return new CaseReport(parts[0], parts[1], parts[2], parts[3]);
    };

    public static Predicate<CaseReport> isValid = (report) ->
            report.getProviderId() != null &&
                    !report.getProviderId().isEmpty() &&
                    report.getCondition() != null &&
                    !report.getCondition().isEmpty();

    // b) Abstract (Extract relevant data or normalize)
    public static Function<CaseReport, CaseReport> abstractData = (report) ->
            new CaseReport(
                    report.getProviderId().trim(),
                    report.getPatientId().trim(),
                    report.getCondition().toUpperCase(),  // normalize condition
                    report.getRawMessage()
            );

    // c) Categorize (classify based on condition)
    public static Function<CaseReport, String> categorize = (report) -> {
        String condition = report.getCondition();
        if (condition.contains("COVID")) return "Respiratory";
        if (condition.contains("FLU")) return "Respiratory";
        if (condition.contains("HIV")) return "Infectious Disease";
        return "Other";
    };
}

