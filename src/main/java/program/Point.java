package program;

class Point {
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    Point move(int direction, int distance) {

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
}
