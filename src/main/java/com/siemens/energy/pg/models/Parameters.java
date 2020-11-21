package com.siemens.energy.pg.models;

public class Parameters {
    public Parameters(double w1, double w2, double b) {
        this.w1 = w1;
        this.w2 = w2;
        this.b = b;
    }

    private final double w1;
    private final double w2;
    private final double b;

    public double getW1() {
        return w1;
    }

    public double getW2() {
        return w2;
    }

    public double getB() {
        return b;
    }
}
