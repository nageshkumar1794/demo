package com.example.demo.ehr;

// CaseReport.java
/*
Java Functional Programming pipeline example that simulates how case reports are processed in a public health surveillance system.

We’ll demonstrate these four key stages:
a) Parse & Validate
b) Abstract (extract essential fields)
c) Categorize
d) Store (persist or print)

We'll leverage Streams, lambdas, and immutable data transformations — the essence of Java functional programming.

Step 1: Define the Domain Model   CaseReport
Step 2: Define Processing Utilities (Functional Components) CaseReportProcessors
Each function represents a pure transformation from one state to another
Step 3: Main Processing Pipeline
We’ll build a stream pipeline representing the end-to-end flow. CaseReportPipeline

Concepts Demonstrated

✅ Functional Programming Constructs

Function<T, R> and Predicate<T>
Stream transformations (map, filter, collect)
Immutable data (new CaseReport for each transformation)
Declarative pipeline (no explicit loops)

✅ Pipeline Architecture

Each processing step is isolated, composable, and testable.
Easy to extend (e.g., add enrichment, persistence layers, Kafka publishing).

🧩 Next Step (Optional Enhancement)

You can extend this by:

Reading input from a JSON or HL7 message stream.
Using CompletableFuture for parallel processing.
Storing results in a database via a Repository interface (simulating persistence).

 */

public class CaseReport {
    private final String providerId;
    private final String patientId;
    private final String condition;
    private final String rawMessage;

    public CaseReport(String providerId, String patientId, String condition, String rawMessage) {
        this.providerId = providerId;
        this.patientId = patientId;
        this.condition = condition;
        this.rawMessage = rawMessage;
    }

    public String getProviderId() { return providerId; }
    public String getPatientId() { return patientId; }
    public String getCondition() { return condition; }
    public String getRawMessage() { return rawMessage; }

    @Override
    public String toString() {
        return "CaseReport{" +
                "providerId='" + providerId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}

