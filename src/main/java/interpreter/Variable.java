package interpreter;

public class Variable implements Expression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public boolean evaluate(Context context) {
        return context.hasValue(name);
    }
}
