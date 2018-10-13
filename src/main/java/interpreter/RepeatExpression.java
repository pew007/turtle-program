package interpreter;

import program.Visitor;

import java.util.List;

public class RepeatExpression extends Expression {

    private Expression repetition;
    private List<Expression> repeatedExpressions;

    public RepeatExpression(Expression repetition, List<Expression> repeatedExpressions) {
        this.repetition = repetition;
        this.repeatedExpressions = repeatedExpressions;
    }

    public int getRepetition(Context context) {
        return repetition.evaluate(context);
    }

    public List<Expression> getRepeatedExpressions() {
        return repeatedExpressions;
    }

    public int evaluate(Context context) {
        int repetitionVal = this.repetition.evaluate(context);

        if (repetitionVal < 0) {
            repetitionVal = 0;
        }

        for (int i = 0; i < repetitionVal; i++) {
            for (Expression expression : this.repeatedExpressions) {
                expression.evaluate(context);
            }
        }

        return 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Repeat %s times:\n", this.repetition));
        for (Expression expression : this.repeatedExpressions) {
            String message = "\t" + expression;
            stringBuilder.append(message);
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
