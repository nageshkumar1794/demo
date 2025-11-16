package com.example.demo.port;
public class CalculateInterest {
    private float principleAmount = 0;
    private float rateOfIntrest = 0;
    private float time = 0;
    private float totalAmount = 0;

    public CalculateInterest() {
    }

    public CalculateInterest(float principleAmount, float rateOfIntrest, float time) {
        this.principleAmount = principleAmount;
        this.rateOfIntrest = rateOfIntrest;
        this.time = time;
    }

    public void computeComplexArea() {
        calculateTotalAmount();

        System.out.println(getTotalAmount());
    }

    public float getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(float principleAmount) {
        this.principleAmount = principleAmount;
    }

    public float getRateOfIntrest() {
        return rateOfIntrest;
    }

    public void setRateOfIntrest(float rateOfIntrest) {
        this.rateOfIntrest = rateOfIntrest;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    private void calculateTotalAmount() {
        float interest = (principleAmount * time * rateOfIntrest) /100.00f;
        totalAmount = principleAmount + interest;
    }
}
