package interpreter;

public class AssignmentExpression extends Expression {

    private String variableName;
    private int value;

    public AssignmentExpression(String variableName, int value) {
        this.variableName = variableName;
        this.value = value;
    }

    public void evaluate(Context context) {
        context.setValue(variableName, value);
    }

    @Override
    public String toString() {
        return String.format("Assign %d to variable %s", this.value, this.variableName);
    }
}
