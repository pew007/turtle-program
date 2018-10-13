package interpreter;

import java.util.List;

public class RepeatExpression extends Expression {

    private Expression repetition;
    private List<Expression> expressions;

    public RepeatExpression(Expression repetition, List<Expression> expressions) {
        this.repetition = repetition;
        this.expressions = expressions;
    }

    public int evaluate(Context context) {
        int repetitionVal = this.repetition.evaluate(context);
        for (int i = 0; i < repetitionVal; i++) {
            for (Expression expression : this.expressions) {
                expression.evaluate(context);
            }
        }

        return 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Repeat %s times:\n", this.repetition));
        for (Expression expression : this.expressions) {
            String message = "\t" + expression;
            stringBuilder.append(message);
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
