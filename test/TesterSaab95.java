import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TesterSaab95 extends Saab95 {
    Saab95 nySaab95 = new Saab95();
    @Test
    public void testStartEngineGivesCurrentSpeed() {// Should give a value of 0.1
        nySaab95.startEngine();
        assertEquals(0.1, nySaab95.getCurrentSpeed());
    }

    @Test
    public void testIfIncrementSpeedWorks(){ // Should only allow inputs between 0 and 1
        nySaab95.incrementSpeed(0.5);
        assertEquals(true, nySaab95.intervalChangeSpeed);

    }

    @Test
    public void testIfDecrementSpeedWorks(){ // Should only allow inputs between 0 and 1
        nySaab95.decrementSpeed(0.5);
        assertEquals(true, nySaab95.intervalChangeSpeed);

    }

    @Test
    public void testIfTurboTurnsOn() {// Should return true if the turbo is on
        nySaab95.setTurboOn();
        assertEquals(true, nySaab95.turboOn);

    }

    @Test
    public void testIfTurboTurnsOff() { // Should return false if turbo is off
        nySaab95.setTurboOff();
        assertEquals(false, nySaab95.turboOn);
    }

    @Test
    public void testIfBrakeIntervalWorks() { // Should only allow inputs between 0 and 1
        nySaab95.startEngine();
        nySaab95.brake(0.1);
    }
    @Test
    public void testIfSpeedFactorWorks() {
        nySaab95.enginePower = 10;
        nySaab95.speedFactor();
        assertEquals(false, nySaab95.getCurrentSpeed() == nySaab95.speedFactor());

    }
    @Test
    public void testIfCarMoves() {
        nySaab95.startEngine(); // Should give speed 0.1
        nySaab95.move();// Which means that one move should get me -0.1 in the Y-direction since its headed south
        assertEquals(-0.1,nySaab95.getCurrentPositionY());

    }


}
