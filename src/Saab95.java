import java.awt.*;


public class Saab95 extends Vehicle {


    public boolean turboOn;

    private Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        String modelName = "Saab95";
        stopEngine();
        currentDirection = "South";
        currentPositionX = 0;
        currentPositionY = 0;
        interval = true;
    }

    private void setTurboOn(){
        turboOn = true;
    }

    private void setTurboOff(){
        turboOn = false;
    }


    private double speedFactor(){ // Increase with factor if turbo is on
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){ // Increase speed
       interval(amount,0,1);
       if(interval == true)
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        interval(amount, 0,1);
        if(interval == true)
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;

    }

    // TODO fix this method according to lab pm
    private void gas(double amount) {
        incrementSpeed(amount);

        interval(getCurrentSpeed(), 0, enginePower);
        if (interval);

    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
            interval(getCurrentSpeed(),0,enginePower);
            if(interval);
    }

    public static void main(String [] args) {
        Saab95 nySaab95 = new Saab95();
        nySaab95.startEngine();
        nySaab95.gas(-1);
        nySaab95.gas(0.99);
        nySaab95.gas(0.99);
    }

    @Override
    public void move() {

    }
}