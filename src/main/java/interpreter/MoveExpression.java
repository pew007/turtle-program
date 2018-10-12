package interpreter;

public class MoveExpression extends Expression {

    private int distance;

    public MoveExpression(int distance) {
        this.distance = distance;
    }

    public void evaluate(Context context) {
        context.getTurtle().move(distance);
    }

    @Override
    public String toString() {
        return String.format("Move %d", this.distance);
    }
}
