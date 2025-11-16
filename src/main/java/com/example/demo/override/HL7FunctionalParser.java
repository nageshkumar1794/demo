package com.example.demo.override;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HL7FunctionalParser {

    public void ParseHL7() {
        String hl7Message =
                "MSH|^~\\&|LABSYS|HOSP|EHR|HOSP|202511061030||ORU^R01|MSGID1234|P|2.3.1\n" +
                        "PID|1||123456^^^HOSP^MR||DOE^JOHN||19800101|M\n" +
                        "OBR|1||LAB123|^GLUCOSE|||202511061000\n" +
                        "OBX|1|NM|GLUCOSE^GLUCOSE LEVEL||105|mg/dL|70-110|N|||F\n" +
                        "OBX|2|NM|BUN^BLOOD UREA NITROGEN||22|mg/dL|7-25|N|||F\n" +
                        "OBX|3|NM|CREA^CREATININE||1.2|mg/dL|0.6-1.3|N|||F";

        // Step 1: Split HL7 message into segments
        List<String> segments = Arrays.asList(hl7Message.split("\\r?\\n"));

        // Step 2: Filter OBX segments and map to Observation objects
        List<HL7Observation> HL7Observations = segments.stream()
                .filter(seg -> seg.startsWith("OBX|"))
                .map(seg -> seg.split("\\|"))
                .map(fields -> new HL7Observation(
                        getField(fields, 3).split("\\^")[0], // test code
                        getField(fields, 3).split("\\^").length > 1 ? getField(fields, 3).split("\\^")[1] : "",
                        getField(fields, 5),  // value
                        getField(fields, 6),  // units
                        getField(fields, 7),  // reference range
                        getField(fields, 8)   // abnormal flag
                ))
                .collect(Collectors.toList());

        // Step 3: Example - filter only tests with abnormal flag not "N" (normal)
        List<HL7Observation> abnormalTests = HL7Observations.stream()
                .filter(obs -> !"N".equalsIgnoreCase(obs.abnormalFlag))
                .collect(Collectors.toList());

        // Step 4: Print results
        System.out.println(" All Observations:");
        HL7Observations.forEach(System.out::println);

        System.out.println("\nAbnormal Observations:");
        abnormalTests.forEach(System.out::println);
    }

    private static String getField(String[] fields, int index) {
        return index < fields.length ? fields[index] : "";
    }
}
