package com.siemens.energy.pg.parsers;

import com.siemens.energy.pg.models.Equation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

/**
 * Class for managing parsing of Function Plot input files
 */
public class EquationInputParser {
    private final Path inputPath;

    public EquationInputParser(String path) {
        this.inputPath = Paths.get(path);
    }

    /**
     * Parses a Function Plot input file and creates a collection of equations from it.
     *
     * @return collection of equations
     */
    public Collection<Equation> parseEquations() {
        /*
            Needs implementation.

            Example:
            Scanner scanner = new Scanner(this.inputPath.toFile());
            String [] names = scanner.nextLine().split("\\s+");
         */

        return Arrays.asList();
    }
}
