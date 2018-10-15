package program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void moveHorizontally() {
        Point point = new Point(0, 0);
        Point newPoint = point.move(0, 10);

        Assertions.assertEquals(10, newPoint.getX());
        Assertions.assertEquals(0, newPoint.getY());
    }

    @Test
    void moveVertically() {
        Point point = new Point(0, 0);
        Point newPoint = point.move(90, 10);

        double allowedDelta = 0.001;
        Assertions.assertEquals(0, newPoint.getX(), allowedDelta);
        Assertions.assertEquals(10, newPoint.getY(), allowedDelta);
    }

    @Test
    void moveNegativeDegrees() {
        Point point1 = new Point(0, 0);
        Point newPoint1 = point1.move(60, 10);

        Point point2 = new Point(0, 0);
        Point newPoint2 = point2.move(-300, 10);

        Assertions.assertEquals(newPoint1.getX(), newPoint2.getX());
        Assertions.assertEquals(newPoint1.getY(), newPoint2.getY());
    }
}
