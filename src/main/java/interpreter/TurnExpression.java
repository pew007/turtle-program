package interpreter;

public class TurnExpression extends Expression {

    private int degrees;

    public TurnExpression(int degrees) {
        this.degrees = degrees;
    }

    public void evaluate(Context context) {
        context.getTurtle().turn(degrees);
    }

    @Override
    public String toString() {
        return String.format("Turn %d degrees", this.degrees);
    }
}
