package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import program.Turtle;

class MoveExpressionTest {

    @Test
    void evaluate() {
        Context context = new Context();
        Turtle turtle = new Turtle();
        turtle.penDown();
        context.setTurtle(turtle);
        MoveExpression move = new MoveExpression(new Constant(10));

        move.evaluate(context);

        Assertions.assertEquals(10, context.getTurtle().location().getX());
        Assertions.assertEquals(0, context.getTurtle().location().getY());
    }
}
