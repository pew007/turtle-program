package interpreter;

public class PenDownExpression extends Expression {
    public void evaluate(Context context) {
        context.getTurtle().penDown();
    }

    @Override
    public String toString() {
        return "Pen Down";
    }
}
