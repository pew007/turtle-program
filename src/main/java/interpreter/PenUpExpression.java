package interpreter;

public class PenUpExpression extends Expression {
    public int evaluate(Context context) {
        context.getTurtle().penUp();
        return 1;
    }

    @Override
    public String toString() {
        return "Pen up";
    }
}
