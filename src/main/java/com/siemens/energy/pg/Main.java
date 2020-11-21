package com.siemens.energy.pg;

import com.siemens.energy.pg.models.Equation;
import com.siemens.energy.pg.models.PlotScatter;
import com.siemens.energy.pg.parsers.EquationInputParser;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.Settings;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Collection;

public class Main {

    // Provide the location of the executable on your machine.
    private final static String EXECUTABLE_PATH = "src/main/resources/engine.exe";

    public static void main(String[] args) {
        try {
            Collection<Equation> equations = new EquationInputParser(args[0]).parseEquations();
            Collection<PlotScatter> scatters = new ComputeEngine(EXECUTABLE_PATH).compute(equations);
            plot(scatters);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates 3D plot from engine results plot scatter
     *
     * @param plotScatters
     */
    private static void plot(Collection<PlotScatter> plotScatters) {
        Settings.getInstance().setHardwareAccelerated(true);

        final int maxWidth = 950;

        Frame frame = new Frame("Plots");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel wrap = new JPanel();
        wrap.setMaximumSize(new Dimension(maxWidth, 10000000));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout((plotScatters.size() + 2)/2, 2));

        wrap.add(panel);

        for (PlotScatter plotScatter : plotScatters) {
            JPanel container = new JPanel();
            Chart chart = getChart(plotScatter);

            chart.addMouseCameraController();
            chart.addKeyboardCameraController();
            chart.addKeyboardScreenshotController();

            container.setPreferredSize(new Dimension(maxWidth, 600));

            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            container.add((Canvas) chart.getCanvas());
            container.setBorder(BorderFactory.createTitledBorder(plotScatter.getName()));
            panel.add(container);
        }

        panel.setBorder(BorderFactory.createBevelBorder(1));

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPreferredSize(new Dimension(maxWidth, 700));
        scrollPane.add(wrap);

        frame.add(scrollPane);
        frame.setVisible(true);
        frame.pack();
        frame.invalidate();
    }

    private static Chart getChart(PlotScatter plotScatter) {
        Chart chart = AWTChartComponentFactory.chart(Quality.Advanced, "awt");
        Coord3d[] points = plotScatter.getPoints().stream().map(point ->
                new Coord3d(point.getX(), point.getY(), point.getZ())).toArray(Coord3d[]::new);

        Scatter scatter = new Scatter(points, new Color(0, 0, 255));
        chart.add(scatter);
        return chart;
    }
}