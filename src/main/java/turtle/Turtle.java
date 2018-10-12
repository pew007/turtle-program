package turtle;

public class Turtle {
    private int direction;
    private Point location;

    public Turtle() {
    }

    public void move(int distance) {
        System.out.println("Moving distance " + distance);
    }

    public void turn(int degrees) {
        System.out.println("Turning in degrees " + degrees);
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
}
