package interpreter;

import turtle.Turtle;

import java.util.Hashtable;

public class Context {

    private Turtle turtle;
    private Hashtable<String, Integer> values = new Hashtable<String, Integer>();

    public Context() {
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    Turtle getTurtle() {
        return turtle;
    }

    int getValue(String variableName) {
        return values.get(variableName);
    }

    void setValue(String variableName, int value) {
        values.put(variableName, value);
    }
}
