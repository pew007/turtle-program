package program;

public class Turtle {
    private int direction;
    private Point location;
    private boolean isDrawing;

    public Turtle() {
        this.direction = 0;
        this.location = new Point(0, 0);
    }

    public void move(int distance) {
        if (isDrawing) {
            this.location = location.move(direction, distance);
        }
    }

    public void turn(int degrees) {
        this.direction = degrees;
    }

    public void penUp() {
        this.isDrawing = false;
    }

    public void penDown() {
        this.isDrawing = true;
    }

    public boolean isPenUp() {
        return !isDrawing;
    }

    public int direction() {
        return direction;
    }

    public Point location() {
        return location;
    }

    Memento createMemento() {
        try {
            Point currentLocation = (Point) location.clone();
            Memento currentState = new Memento();
            currentState.setState("direction", direction());
            currentState.setState("location", currentLocation);
            currentState.setState("isDrawing", isDrawing);
            return currentState;
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    void restoreState(Memento oldState) {
        this.direction = (Integer) oldState.getState("direction");
        this.location = (Point) oldState.getState("location");
        this.isDrawing = (boolean) oldState.getState("isDrawing");
    }
}
