package interpreter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantTest {

    @Test
    void evaluate() {
        Context context = new Context();
        Constant constant = new Constant(10);

        Assertions.assertEquals(10, constant.evaluate(context));
    }
}