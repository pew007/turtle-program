package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssignmentExpressionTest {

    @Test
    void evaluate() {
        Context context = new Context();
        AssignmentExpression assignment = new AssignmentExpression("side", 15);
        assignment.evaluate(context);

        Assertions.assertEquals(15, context.getValue("side"));
    }
}
