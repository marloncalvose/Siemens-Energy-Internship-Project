package com.siemens.energy.pg.models;

public class Equation {
    public Equation(String title, Parameters parameters) {
        this.title = title;
        this.parameters = parameters;
    }

    private final String title;
    private final Parameters parameters;

    public String getTitle() {
        return title;
    }

    public Parameters getParameters() {
        return parameters;
    }
}
