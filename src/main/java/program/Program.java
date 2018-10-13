package program;

import interpreter.Context;
import interpreter.Expression;
import turtle.Turtle;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {

    private List<Expression> ast;

    public Program(String fileName) throws FileNotFoundException {
        Parser parser = new Parser();
        this.ast = parser.parseInstructions(fileName);
    }

    void evaluate(){
        Turtle turtle = new Turtle();
        Context context = new Context();
        context.setTurtle(turtle);

        for (Expression expression : this.ast) {
            expression.evaluate(context);
        }
    }
}
