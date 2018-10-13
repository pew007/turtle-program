package turtle;

public class Turtle {
    private int direction;
    private Point location;

    public Turtle() {
    }

    public void move(int distance) {
        System.out.println("Turtle is moving distance " + distance);
    }

    public void turn(int degrees) {
        System.out.println("Turtle is turning in degrees " + degrees);
    }

    public void penUp() {
        System.out.println("Pen up");
    }

    public void penDown() {
        System.out.println("Pen down");
    }

    public boolean isPenUp() {
        return false;
    }

    public int direction() {
        return direction;
    }

    public Point location() {
        return location;
    }

    public Memento createMemento() {
        Memento currentState = new Memento();
        currentState.setState("direction", direction);
        currentState.setState("location", location);
        return currentState;
    }

    public void restoreState(Memento oldState) {
        this.direction = (Integer) oldState.getState("direction");
        this.location = (Point) oldState.getState("location");
    }
}
