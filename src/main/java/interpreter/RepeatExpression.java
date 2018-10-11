package interpreter;

import java.util.List;

public class RepeatExpression extends Expression {

    private int repetition;
    private List<Expression> expressions;

    public RepeatExpression(int repetition, List<Expression> expressions) {
        this.repetition = repetition;
        this.expressions = expressions;
    }

    public void evaluate(Context context) {
        for (int i = 0; i < this.repetition; i++) {
            for (Expression expression : this.expressions) {
                expression.evaluate(context);
            }
        }
    }
}
