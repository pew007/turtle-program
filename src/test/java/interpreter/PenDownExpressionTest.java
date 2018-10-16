package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import program.Turtle;

class PenDownExpressionTest {

    @Test
    void evaluate() {
        Turtle turtle = new Turtle();
        turtle.penUp();
        Context context = new Context();
        context.setTurtle(turtle);

        PenDownExpression penDown = new PenDownExpression();
        penDown.evaluate(context);

        Assertions.assertFalse(turtle.isPenUp());
    }
}
