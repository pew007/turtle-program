package interpreter;

import program.Visitor;

public class MoveExpression extends Expression {

    private Expression argument;

    public MoveExpression(Expression argument) {
        this.argument = argument;
    }

    public int getDistance(Context context) {
        return argument.evaluate(context);
    }

    public int evaluate(Context context) {
        int distance = argument.evaluate(context);
        context.getTurtle().move(distance);
        return 1;
    }

    @Override
    public String toString() {
        return String.format("Move %s", this.argument);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
