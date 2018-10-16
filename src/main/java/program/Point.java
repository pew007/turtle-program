package program;

public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point move(int direction, int distance) {

        if (direction < 0) {
            direction = 360 + direction;
        }

        double radians = Math.PI * direction / 180;
        double deltaX = Math.cos(radians) * distance;
        double deltaY = Math.sin(radians) * distance;

        double newX = x + deltaX;
        double newY = y + deltaY;

        return new Point(newX, newY);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point cloned = (Point) super.clone();
        cloned.x = x;
        cloned.y = y;
        return cloned;
    }
}
