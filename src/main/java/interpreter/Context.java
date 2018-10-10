package interpreter;

import java.util.Hashtable;

public class Context {

    private Hashtable<String, Integer> values = new Hashtable<String, Integer>();

    public int getValue(String variableName) {
        return values.get(variableName);
    }

    public void setValue(String variableName, int value) {
        values.put(variableName, value);
    }

    public boolean hasValue(String variableName) {
        return values.contains(variableName);
    }
}
