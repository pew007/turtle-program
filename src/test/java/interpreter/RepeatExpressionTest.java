package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import program.Turtle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepeatExpressionTest {

    @Test
    void evaluate() {
        Context context = new Context();
        Turtle turtle = new Turtle();
        turtle.penDown();
        context.setTurtle(turtle);

        List<Expression> repeated = new ArrayList<>();
        repeated.add(new MoveExpression(new Constant(10)));
        Constant repetition = new Constant(3);

        RepeatExpression repeat = new RepeatExpression(repetition, repeated);
        repeat.evaluate(context);

        Assertions.assertEquals(30, turtle.location().getX());
        Assertions.assertEquals(0, turtle.location().getY());
    }
}
