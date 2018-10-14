package program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TurtleTest {

    @Test
    void move() {
        Turtle turtle = new Turtle();
        turtle.move(10);

        Assertions.assertEquals(10, turtle.location().getX());
        Assertions.assertEquals(0, turtle.location().getY());
    }

    @Test
    void turn() {
        Turtle turtle = new Turtle();
        turtle.move(10);
        turtle.turn(90);
        turtle.move(20);
        turtle.turn(30);
        turtle.move(15);

        double allowedDelta = 0.001;
        Assertions.assertEquals(22.99, turtle.location().getX(), allowedDelta);
        Assertions.assertEquals(27.50, turtle.location().getY(), allowedDelta);
    }
}
