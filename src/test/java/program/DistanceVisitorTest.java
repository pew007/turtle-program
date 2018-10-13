package program;

import interpreter.Constant;
import interpreter.Expression;
import interpreter.MoveExpression;
import interpreter.RepeatExpression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DistanceVisitorTest {

    private DistanceVisitor visitor;

    @BeforeEach
    void setup() {
        visitor = new DistanceVisitor();
    }

    @Test
    void visitMoveExpression() {
        MoveExpression expression = new MoveExpression(new Constant(10));
        visitor.visit(expression);

        Assertions.assertEquals(10, visitor.getResult());
    }

    @Test
    void visitRepeatedExpression() {
        List<Expression> repeated = new ArrayList<Expression>();
        repeated.add(new MoveExpression(new Constant(10)));
        repeated.add(new MoveExpression(new Constant(10)));
        repeated.add(new MoveExpression(new Constant(10)));

        RepeatExpression expression = new RepeatExpression(new Constant(4), repeated);

        visitor.visit(expression);

        Assertions.assertEquals(120, visitor.getResult());
    }
}
