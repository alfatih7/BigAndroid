package com.alfatih.bigsooq.debugger;

public class Calculator {

    public Double add(Double mFirstOperand, Double mSecondOperand) {
        return mFirstOperand + mSecondOperand;
    }

    public Double sub(Double mFirstOperand, Double mSecondOperand) {
        return mFirstOperand - mSecondOperand;
    }

    public Double mul(Double mFirstOperand, Double mSecondOperand) {
        return mFirstOperand * mSecondOperand;
    }

    public Double div(Double mFirstOperand, Double mSecondOperand) {
        return mFirstOperand / mSecondOperand;
    }

    public enum Operator {ADD, SUB, MUL, DIV}
}
