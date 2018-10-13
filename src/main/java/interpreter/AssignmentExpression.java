package interpreter;

import program.Visitor;

public class AssignmentExpression extends Expression {

    private String variableName;
    private Expression value;

    public AssignmentExpression(String variableName, Expression value) {
        this.variableName = variableName;
        this.value = value;
    }

    public int evaluate(Context context) {
        int value = this.value.evaluate(context);
        context.setValue(variableName, value);
        return 1;
    }

    @Override
    public String toString() {
        return String.format("Assign %s to variable %s", this.value, this.variableName);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
