package interpreter;

public class PenDownExpression extends Expression {
    public int evaluate(Context context) {
        context.getTurtle().penDown();

        return 1;
    }

    @Override
    public String toString() {
        return "Pen Down";
    }
}
