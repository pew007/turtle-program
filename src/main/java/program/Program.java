package program;

import interpreter.Expression;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {

    void execute(String fileName) throws FileNotFoundException {
        Parser parser = new Parser();
        List<Expression> ast = parser.parseInstructions(fileName);
    }
}
