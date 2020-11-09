public interface Movable {
    void move();
    void turnLeft();
    void turnRight();
    String getCurrentDirection();
    double getCurrentPositionX();
    double getCurrentPositionY();
} //Interface har ingenting i sig, deklarerar bara metoder.
