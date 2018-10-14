package program;

import interpreter.*;

import java.util.ArrayList;
import java.util.List;

public class MementoVisitor implements Visitor {

    private List<Memento> saved = new ArrayList<Memento>();
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    private void addMemento(Memento memento) {
        saved.add(memento);
    }

    Memento getMemento(int step) {
        return saved.get(step);
    }

    public void visit(MoveExpression moveExpression) {
        Turtle turtle = this.context.getTurtle();
        this.addMemento(turtle.createMemento());
    }

    public void visit(TurnExpression turnExpression) {
        Turtle turtle = this.context.getTurtle();
        this.addMemento(turtle.createMemento());
    }

    public void visit(PenUpExpression penUpExpression) {

    }

    public void visit(PenDownExpression penDownExpression) {

    }

    public void visit(RepeatExpression repeatExpression) {
        int repetition = repeatExpression.getRepetition(context);

        for (int i = 0; i < repetition; i++) {
            for (Expression ignored : repeatExpression.getRepeatedExpressions()) {
                Turtle turtle = context.getTurtle();
                this.addMemento(turtle.createMemento());
            }
        }
    }

    public void visit(AssignmentExpression assignmentExpression) {

    }

    public void visit(Constant constant) {

    }

    public void visit(Variable variable) {

    }

    public Object getResult() {
        return saved;
    }
}
