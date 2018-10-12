package program;

import interpreter.Expression;
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
}