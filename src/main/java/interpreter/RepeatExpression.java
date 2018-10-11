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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Repeat %d times:\n", this.repetition));
        for (Expression expression : this.expressions) {
            String message = "\t" + expression.toString();
            stringBuilder.append(message);
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
