package program;

import interpreter.*;

public interface Visitor {
    void visit(MoveExpression moveExpression);

    void visit(TurnExpression turnExpression);

    void visit(PenUpExpression penUpExpression);

    void visit(PenDownExpression penDownExpression);

    void visit(RepeatExpression repeatExpression);

    void visit(AssignmentExpression assignmentExpression);

    void visit(Constant constant);

    void visit(Variable variable);

    Object getResult();
}
