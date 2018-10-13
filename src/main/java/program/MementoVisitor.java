package program;

import interpreter.*;

import java.util.ArrayList;
import java.util.List;

public class MementoVisitor implements Visitor {

    private List<Memento> saved = new ArrayList<Memento>();
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    public void addMemento(Memento memento) {
        saved.add(memento);
    }

    public Memento getMemento(int index) {
        return saved.get(index);
    }

    public void visit(MoveExpression moveExpression) {
        this.getMemento(0);
    }

    public void visit(TurnExpression turnExpression) {

    }

    public void visit(PenUpExpression penUpExpression) {

    }

    public void visit(PenDownExpression penDownExpression) {

    }

    public void visit(RepeatExpression repeatExpression) {

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
