package com.utils;

public class Calculator {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }


    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculateResult() {
        double result = 0;
        switch(this.operator) {
            case  CalculatorOperations.ADDITION:
                result = this.leftOperand + this.rightOperand;
                break;
            case  CalculatorOperations.SUBSTRACTION:
                result = this.leftOperand - this.rightOperand;
                break;
            case CalculatorOperations.MULTIPLICATION :
                result = this.leftOperand * this.rightOperand;
                break;
            case CalculatorOperations.DIVISION :
                result = this.leftOperand / this.rightOperand;
                break;
            case CalculatorOperations.POWER:
                result = Math.pow(this.leftOperand,this.rightOperand);
                break;
            default:
                    result = 0;
        }

        return result;
    }
}
