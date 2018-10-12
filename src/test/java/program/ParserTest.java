package program;

import interpreter.Constant;
import interpreter.Expression;
import interpreter.Variable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseInstructions() {
        Parser parser = new Parser();
        String file = "/Users/pwang/Documents/cs635/turtle-program/src/test/resources/instructions.txt";

        try {
            List<Expression> instructions = parser.parseInstructions(file);

            for (Expression expression : instructions) {
                System.out.println(expression);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void parseArgument() {
        Parser parser = new Parser();

        Expression argument = parser.parseArgument("10");
        Assertions.assertTrue(argument instanceof Constant);

        argument = parser.parseArgument("#side");
        Assertions.assertTrue(argument instanceof Variable);
    }
}