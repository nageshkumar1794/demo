package com.example.demo.ehr;

import java.util.*;
import java.util.stream.*;

public class CaseReportPipeline {

    public void casereport() {
        List<String> incomingReports = List.of(
                "H001,P1001,COVID-19,MessageA",
                "H002,P1002,FLU,MessageB",
                "H003,P1003,HIV,MessageC",
                "H004,P1004,,MessageD" // Invalid
        );

        Map<String, List<CaseReport>> categorizedReports =
                incomingReports.stream()
                        // Parse
                        .map(CaseReportProcessors.parse)
                        // Validate
                        .filter(CaseReportProcessors.isValid)
                        // Abstract
                        .map(CaseReportProcessors.abstractData)
                        // Group by Category
                        .collect(Collectors.groupingBy(CaseReportProcessors.categorize));

        // d) Store (Here, just print out)
        categorizedReports.forEach((category, reports) -> {
            System.out.println("Category: " + category);
            reports.forEach(System.out::println);
        });
    }
}

