package program;

import interpreter.*;

public class DistanceVisitor implements Visitor {

    private int distance = 0;
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void visit(MoveExpression moveExpression) {
        distance += moveExpression.getDistance(context);
    }

    public void visit(TurnExpression turnExpression) {

    }

    public void visit(PenUpExpression penUpExpression) {

    }

    public void visit(PenDownExpression penDownExpression) {

    }

    public void visit(RepeatExpression repeatExpression) {
        int repetitionDistance = 0;
        int repetition = repeatExpression.getRepetition(context);

        for (Expression subExpression : repeatExpression.getRepeatedExpressions()) {
            DistanceVisitor visitor = new DistanceVisitor();
            visitor.setContext(this.context);
            subExpression.accept(visitor);

            repetitionDistance += (Integer) visitor.getResult();
        }

        distance += repetitionDistance * repetition;
    }

    public void visit(AssignmentExpression assignmentExpression) {

    }

    public void visit(Constant constant) {

    }

    public void visit(Variable variable) {

    }

    public Object getResult() {
        return distance;
    }
}
