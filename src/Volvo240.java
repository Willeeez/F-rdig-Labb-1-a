import java.awt.*;

public class Volvo240 extends Vehicle {

    public final static double trimFactor = 1.25;

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        currentDirection = "South";
        currentPositionX = 0;
        currentPositionY = 0;
        interval = true;
    }

    private double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount) {
        interval(amount,0,1);
        if(interval == true)
           currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        interval(amount,0,1);
        if(interval == true)
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm
    private void gas(double amount) {
        incrementSpeed(amount);

        interval(getCurrentSpeed(), 0, enginePower);
        if (interval);

    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
        interval(getCurrentSpeed(), 0, enginePower);
        if (interval) ;


    }

    @Override
    public void move() {

    }
}
