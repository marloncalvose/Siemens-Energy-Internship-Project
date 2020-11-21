package com.siemens.energy.pg.models;

import java.util.ArrayList;
import java.util.List;

public class PlotScatter {

    public PlotScatter(String name) {
        this.name = name;
        this.points = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Point> getPoints() {
        return points;
    }

    private final String name;
    private final List<Point> points;
}
