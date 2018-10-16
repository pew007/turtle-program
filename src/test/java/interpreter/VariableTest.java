package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {

    @Test
    void evaluate() {
        Context context = new Context();
        context.setValue("#side", 10);
        Variable var = new Variable("#side");

        Assertions.assertEquals(10, var.evaluate(context));
    }

    @Test
    void evaluateUndefinedVariable() {
        final Context context = new Context();
        final Variable var = new Variable("#side");

        Assertions.assertThrows(NullPointerException.class, () -> var.evaluate(context));
    }
}