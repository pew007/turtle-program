package program;

import java.util.Hashtable;

class Memento {

    private Hashtable<String, Object> savedStates = new Hashtable<String, Object>();

    Memento() {
    }

    void setState(String stateName, Object stateValue) {
        savedStates.put(stateName, stateValue);
    }

    Object getState(String stateName) {
        return savedStates.get(stateName);
    }
}
