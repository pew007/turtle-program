package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import program.Turtle;

class PenUpExpressionTest {

    @Test
    void evaluate() {
        Turtle turtle = new Turtle();
        Context context = new Context();
        context.setTurtle(turtle);

        PenUpExpression penUp = new PenUpExpression();
        penUp.evaluate(context);

        Assertions.assertTrue(turtle.isPenUp());
    }
}