package interpreter;

public class TurnExpression extends Expression {

    private Expression argument;

    public TurnExpression(Expression argument) {
        this.argument = argument;
    }

    public int evaluate(Context context) {
        int degrees = argument.evaluate(context);
        context.getTurtle().turn(degrees);
        return 1;
    }

    @Override
    public String toString() {
        return String.format("Turn %s degrees", this.argument);
    }
}
