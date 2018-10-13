package interpreter;

import program.Visitor;

public class Constant extends Expression {

    private int value;

    public Constant(int value) {
        this.value = value;
    }

    public int evaluate(Context context) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
