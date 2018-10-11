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

    public Turtle getTurtle() {
        return turtle;
    }

    public int getValue(String variableName) {
        return values.get(variableName);
    }

    public void setValue(String variableName, int value) {
        values.put(variableName, value);
    }
}
