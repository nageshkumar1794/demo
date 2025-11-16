package com.example.demo.override;

import java.util.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

public class CaseReportTransformer {

    public void transform() {
        List<CaseReport> caseReports = List.of(
                new CaseReport("CR001", "John Doe", "COVID-19", "Dallas General", "2025-11-03", true),
                new CaseReport("CR002", "Jane Smith", "Flu", "Austin Medical", "2025-11-04", false),
                new CaseReport("CR003", "Raj Patel", "COVID-19", "Dallas General", "2025-10-28", true),
                new CaseReport("CR004", "Sara Lee", "RSV", "Houston Health", "2025-11-01", true),
                new CaseReport("CR005", "Emily Wong", "COVID-19", "Austin Medical", "2025-11-02", false)
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 🧠 Functional transformation pipeline
        List<CaseSummary> summaries = caseReports.stream()

                // Step 1: Filter only confirmed COVID-19 cases
                .filter(cr -> cr.isConfirmed && cr.diagnosis.equalsIgnoreCase("COVID-19"))

                // Step 2: Map each case to a new summary format
                .map(cr -> new CaseSummary(
                        cr.caseId,
                        cr.diagnosis,
                        cr.facility,
                        YearMonth.parse(cr.reportDate, formatter).toString(), // e.g., 2025-11
                        cr.isConfirmed ? "CONFIRMED" : "PENDING"
                ))

                // Step 3: Sort summaries by facility, then report date
                .sorted(Comparator.comparing((CaseSummary s) -> s.facility)
                        .thenComparing(s -> s.reportMonth))

                // Step 4: Collect to list
                .collect(Collectors.toList());

        // Step 5: Print transformed summaries
        System.out.println("Standardized Case Summaries:");
        summaries.forEach(System.out::println);

        // Step 6: (Optional) Group by Facility
        Map<String, List<CaseSummary>> groupedByFacility = summaries.stream()
                .collect(Collectors.groupingBy(s -> s.facility));

        System.out.println("\nGrouped by Facility:");
        groupedByFacility.forEach((facility, list) -> {
            System.out.println(facility + ":");
            list.forEach(s -> System.out.println("  - " + s));
        });
    }
}

