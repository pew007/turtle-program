package program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void evaluate() throws FileNotFoundException {
        String file = "/Users/pwang/Documents/cs635/turtle-program/src/test/resources/instructions.txt";
        Program program = new Program(file);

        program.evaluate();

        Turtle turtle = program.getContext().getTurtle();
        Assertions.assertEquals(90, turtle.direction());
        double allowedDelta = 0.001;
        Assertions.assertEquals(15, turtle.location().getX(), allowedDelta);
        Assertions.assertEquals(55, turtle.location().getY(), allowedDelta);
    }

    @Test
    void distanceTravelled() throws FileNotFoundException {
        String file = "/Users/pwang/Documents/cs635/turtle-program/src/test/resources/instructions.txt";
        Program program = new Program(file);

        program.evaluate();

        Assertions.assertEquals(70, program.distanceTravelled());
    }

    @Test
    void restoreTurtle() throws FileNotFoundException {
        String file = "/Users/pwang/Documents/cs635/turtle-program/src/test/resources/move.txt";
        Program program = new Program(file);

        program.evaluate();

        Turtle turtle = program.restore(1);
        Assertions.assertEquals(25, turtle.location().getX());
        Assertions.assertEquals(0, turtle.location().getY());
    }
}
