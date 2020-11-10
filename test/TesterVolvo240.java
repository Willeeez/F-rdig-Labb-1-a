import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesterVolvo240 extends Volvo240{
    Volvo240 nyVolvo240 = new Volvo240();

    @Test
    public void testStartEngineGivesCurrentSpeed() {// Should give a value of 0.1
        nyVolvo240.startEngine();
        assertEquals(0.1, nyVolvo240.getCurrentSpeed());
    }

    @Test
    public void testIfSpeedFactorWorks() {
        nyVolvo240.enginePower = 10;
        nyVolvo240.speedFactor();
        assertEquals(false, nyVolvo240.getCurrentSpeed() == nyVolvo240.speedFactor());

    }
    @Test
    public void testIfIncrementSpeedWorks(){ // Should only allow inputs between 0 and 1
        nyVolvo240.incrementSpeed(0.5);
        assertEquals(true, nyVolvo240.intervalChangeSpeed);

    }
    @Test
    public void testIfDecrementSpeedWorks(){ // Should only allow inputs between 0 and 1
        nyVolvo240.decrementSpeed(0.5);
        assertEquals(true, nyVolvo240.intervalChangeSpeed);

    }
    @Test
    public void testIfBrakeIntervalWorks() { // Should only allow inputs between 0 and 1
        nyVolvo240.startEngine();
        nyVolvo240.brake(0.1);
    }
    @Test
    public void testIfCarMoves() {
        nyVolvo240.startEngine(); // Should give speed 0.1
        nyVolvo240.move();// Which means that one move should get me -0.1 in the Y-direction since its headed south
        assertEquals(-0.1,nyVolvo240.getCurrentPositionY());

    }

}
