package interpreter;

public class PenUpExpression extends Expression {
    public void evaluate(Context context) {
        context.getTurtle().penUp();
    }

    @Override
    public String toString() {
        return "Pen up";
    }
}
