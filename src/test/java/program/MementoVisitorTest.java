package program;

import interpreter.Constant;
import interpreter.Context;
import interpreter.MoveExpression;
import interpreter.TurnExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MementoVisitorTest {

    private MementoVisitor visitor;

    @BeforeEach
    void setUp() {
        Turtle turtle = new Turtle();
        Context context = new Context();
        context.setTurtle(turtle);

        this.visitor = new MementoVisitor();
        visitor.setContext(context);
    }

    @Test
    void testVisitTurnExpression() {
        TurnExpression expression = new TurnExpression(new Constant(60));
        visitor.visit(expression);

        expression = new TurnExpression(new Constant(90));
        visitor.visit(expression);

        Memento memento = visitor.getMemento(0);
    }
}