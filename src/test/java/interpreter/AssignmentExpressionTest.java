package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssignmentExpressionTest {

    @Test
    void evaluate() {
        Context context = new Context();
        Expression value = new Constant(15);
        AssignmentExpression assignment = new AssignmentExpression("#side", value);
        assignment.evaluate(context);

        Assertions.assertEquals(15, context.getValue("#side"));
    }
}
