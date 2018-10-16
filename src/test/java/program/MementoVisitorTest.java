package program;

import interpreter.Constant;
import interpreter.Context;
import interpreter.MoveExpression;
import interpreter.TurnExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MementoVisitorTest {

    private MementoVisitor visitor;
    private Turtle turtle;
    private Context context;

    @BeforeEach
    void setUp() {
        turtle = new Turtle();
        turtle.penDown();
        context = new Context();
        context.setTurtle(turtle);

        this.visitor = new MementoVisitor();
        visitor.setContext(context);
    }

    @Test
    void visitTurnExpression() {
        TurnExpression turn = new TurnExpression(new Constant(60));
        turn.evaluate(context);
        visitor.visit(turn);

        turn = new TurnExpression(new Constant(90));
        turn.evaluate(context);
        visitor.visit(turn);

        Memento memento = visitor.getMemento(0);
        turtle.restoreState(memento);

        Assertions.assertEquals(60, turtle.direction());
    }

    @Test
    void visit() {
        MoveExpression move = new MoveExpression(new Constant(10));
        move.evaluate(context);
        visitor.visit(move);

        TurnExpression turn = new TurnExpression(new Constant(90));
        turn.evaluate(context);
        visitor.visit(turn);

        move = new MoveExpression(new Constant(10));
        move.evaluate(context);
        visitor.visit(move);

        Memento memento = visitor.getMemento(1);
        turtle.restoreState(memento);

        Assertions.assertEquals(90, turtle.direction());
        Assertions.assertEquals(10, turtle.location().getX());
        Assertions.assertEquals(0, turtle.location().getY());
    }
}