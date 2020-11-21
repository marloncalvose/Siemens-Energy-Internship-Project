package com.siemens.energy.pg;

import com.siemens.energy.pg.models.Equation;
import com.siemens.energy.pg.models.PlotScatter;
import com.siemens.energy.pg.parsers.ResultsParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Class for managing engine process calls. Manages the creation of inputs, and parsing of outputs.
 */
public class ComputeEngine {

    // Static path for input and output, expected in current working directory
    private final static String inputFilePath = "input.in";
    private final static String outputFilePath = "output.out";

    private final String executablePath;

    public ComputeEngine(String executablePath) {
        this.executablePath = executablePath;
    }

    /**
     * Reads the output from engine and returns a list of plotted results.
     *
     * @param outputPath location of generated output from engine tool
     * @return list of plotted results
     */
    private static Collection<PlotScatter> parseOutput(String outputPath) {
        return new ResultsParser(outputPath).parseResults();
    }

    /**
     * Runs the engine tool and returns the generated output.
     *
     * @param equations list of equations to plot
     * @return a list of plotted results
     * @throws InterruptedException
     * @throws IOException
     */
    public Collection<PlotScatter> compute(Collection<Equation> equations) throws InterruptedException, IOException {
        Process process = startComputation(equations);
        int res = process.waitFor();

        if (res != 0) {
            return Arrays.asList();
        }

        return parseOutput(outputFilePath);
    }

    /**
     * Creates a process to run the engine tool on the provided equations.
     *
     * @param equations the equations to use for generating input for engine
     * @return process object for executed process
     */
    private Process startComputation(Collection<Equation> equations) throws IOException {
        // Implement me
        return new ProcessBuilder(executablePath, "implement_me!").start();
    }
}
