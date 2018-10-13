package interpreter;

import program.Visitable;

abstract public class Expression implements Visitable {
    abstract public int evaluate(Context context);
}
