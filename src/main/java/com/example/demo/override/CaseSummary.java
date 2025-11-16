package com.example.demo.override;

public class CaseSummary {
    String caseId;
    String diagnosis;
    String facility;
    String reportMonth;
    String status;

    public CaseSummary(String caseId, String diagnosis, String facility, String reportMonth, String status) {
        this.caseId = caseId;
        this.diagnosis = diagnosis;
        this.facility = facility;
        this.reportMonth = reportMonth;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) at %s on %s [%s]", caseId, diagnosis, facility, reportMonth, status);
    }
}

/*
| Concept          | Example                                | What It Does             |
| ---------------- | -------------------------------------- | ------------------------ |
| **filter()**     | `.filter(cr -> cr.isConfirmed)`        | Keeps only relevant data |
| **map()**        | `.map(cr -> new CaseSummary(...))`     | Transforms structure     |
| **sorted()**     | `.sorted(Comparator.comparing(...))`   | Functional ordering      |
| **collect()**    | `.collect(Collectors.toList())`        | Collects stream results  |
| **groupingBy()** | `.collect(Collectors.groupingBy(...))` | Aggregates data          |
| **forEach()**    | `.forEach(System.out::println)`        | Functional iteration     |


| Concept                | Java Example                                    | Description                         |                                     |
| ---------------------- | ----------------------------------------------- | ----------------------------------- | ----------------------------------- |
| **Lambda Expressions** | `seg -> seg.startsWith("OBX       |             | Anonymous functions replacing loops |
| **Stream API**         | `.stream()`                                     | Functional data processing pipeline |                                     |
| **map()**              | `.map(seg -> seg.split("                        | Transform each element              |
| **filter()**           | `.filter(obs -> !obs.abnormalFlag.equals("N"))` | Conditional processing              |                                     |
| **collect()**          | `.collect(Collectors.toList())`                 | Gather results into a collection    |                                     |
| **Method References**  | `System.out::println`                           | Cleaner function passing            |                                     |
| **Immutability**       | No in-place mutations                           | More predictable code               |                                     |


case report data transformation, which is very common in electronic case reporting (eCR) or public health surveillance systems.

Let’s build this step by step using Java functional programming — showing how to efficiently transform structured case report data (like JSON or CSV records) into another structured form (like DTOs, summaries, or normalized records)

Scenario

Imagine we receive case reports from multiple hospital systems in different formats — perhaps extracted from HL7 CDA or FHIR.
Each case report might contain:

Patient demographics

Diagnosis

Reporting facility

Lab results

We need to:

Transform the raw case report data into standardized case summaries

Filter by certain conditions (e.g., COVID-19, report date)

Aggregate or map data efficiently using Java Streams & Lambdas

📋 2. Sample Input Data

Let’s assume we’ve already parsed JSON or HL7 into Java POJOs.
Here’s a simplified example list of case reports:
 */