package interpreter;

import program.Visitor;

public class Variable extends Expression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(Context context) {
        return context.getValue(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
