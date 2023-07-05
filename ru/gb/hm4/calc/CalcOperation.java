package ru.gb.hm4.calc;

public class CalcOperation {
    private int id;
    private String expr;
    private double result;

    public CalcOperation(int id, String expr, double result) {
        this.id = id;
        this.expr = expr;
        this.result = result;
    }

    public String getExpr() {
        return expr;
    }

    public double getResult() {
        return result;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ID: " + id +  ", Выражение: " + expr + ", Результат: " + result;
    }
}
