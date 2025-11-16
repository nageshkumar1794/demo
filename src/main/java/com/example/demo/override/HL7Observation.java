package com.example.demo.override;

public class HL7Observation {
    String testCode;
    String testName;
    String value;
    String units;
    String referenceRange;
    String abnormalFlag;

    public HL7Observation(String testCode, String testName, String value, String units, String referenceRange, String abnormalFlag) {
        this.testCode = testCode;
        this.testName = testName;
        this.value = value;
        this.units = units;
        this.referenceRange = referenceRange;
        this.abnormalFlag = abnormalFlag;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %s %s [Ref: %s] Flag: %s",
                testName, testCode, value, units, referenceRange, abnormalFlag);
    }
}

