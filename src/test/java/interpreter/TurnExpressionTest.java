package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import program.Turtle;

import static org.junit.jupiter.api.Assertions.*;

class TurnExpressionTest {

    @Test
    void evaluate() {
        Context context = new Context();
        Turtle turtle = new Turtle();
        context.setTurtle(turtle);
        TurnExpression turn = new TurnExpression(new Constant(90));

        turn.evaluate(context);

        Assertions.assertEquals(90, turtle.direction());
    }
}