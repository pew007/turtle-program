package program;

import interpreter.Context;
import interpreter.Expression;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {

    private List<Expression> ast;
    private Context context;

    public Program(String fileName) throws FileNotFoundException {
        Parser parser = new Parser();
        this.ast = parser.parseInstructions(fileName);

        Turtle turtle = new Turtle();
        this.context = new Context();
        this.context.setTurtle(turtle);
    }

    void evaluate() {
        for (Expression expression : this.ast) {
            expression.evaluate(this.context);
        }
    }

    Turtle restore(int step) {
        MementoVisitor mementoVisitor = new MementoVisitor();
        mementoVisitor.setContext(context);
        this.accept(mementoVisitor);

        Turtle turtle = this.context.getTurtle();
        turtle.restoreState(mementoVisitor.getMemento(step));

        return turtle;
    }

    int distanceTravelled() {
        DistanceVisitor distanceVisitor = new DistanceVisitor();
        distanceVisitor.setContext(context);
        this.accept(distanceVisitor);

        return (Integer) distanceVisitor.getResult();
    }

    public void accept(Visitor visitor) {
        for (Expression expression : this.ast) {
            expression.accept(visitor);
        }
    }
}
