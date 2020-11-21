package com.siemens.energy.pg.parsers;

import com.siemens.energy.pg.models.PlotScatter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

/**
 * Class for managing parsing of engine output files
 */
public class ResultsParser {
    private final Path resultPath;

    public ResultsParser(String path) {
        this.resultPath = Paths.get(path);
    }

    /**
     * Parses an engine results file and returns a collection of each plotted function's scatter
     *
     * @return collection of scatter results
     */
    public Collection<PlotScatter> parseResults() {
        // Implement me
        return Arrays.asList();
    }
}
