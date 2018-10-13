package program;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void evaluate() throws FileNotFoundException {
        String file = "/Users/pwang/Documents/cs635/turtle-program/src/test/resources/instructions.txt";
        Program program = new Program(file);

        program.evaluate();
    }
}