package visitor;

abstract public class Visitor {
    abstract public void visitTerminalExpression();

    abstract public void visitNonTerminalExpression();
}
