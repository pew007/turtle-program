package interpreter;

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
}
