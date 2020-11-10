import java.awt.*;

public class Saab95 extends Vehicle {

    /***
     * The turboOn is used to amplify the cars speed if true, starts with it on = true
     */
    public boolean turboOn;

    /***
     * Gives the new car its attributes from the superclass Vehicle and sets own attributes
     */
    Saab95(){
        super(2,125,Color.red, "Saab95", "South");
        setTurboOn();
        setTurboOff();
        intervalChangeSpeed = true;
        intervalBrakeGas = true;
        currentPositionY = 0;
        currentPositionX = 0;
    }

    /***
     * Turns the turbo on
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /***
     * Turns the turbo off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /***
     *
     * @return Will return the enginepower we have increased with the speedfactor.
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.1 * turbo;
    }

    /***
     *
     * @param amount usage in the method gas where we determine if the gas pedal is pushed or not, if so, the speed
     *               is increased.
     */
    public void incrementSpeed(double amount){
       intervalChangeSpeed(amount,0,1);
       if(intervalChangeSpeed = true)
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;

    }

    /***
     *
     * @param amount usage in the method brake where we determine if the brake pedal is pushed or not, if so, the speed
     *               is decreased.
     */
    public void decrementSpeed(double amount){// Decrease speed
        intervalChangeSpeed(amount, 0,1);
        if(intervalChangeSpeed)
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /***
     *
     * @param amount Correct input will increase the speed by current speed given by the method incrementSpeed
     */
    public void gas(double amount) {
        incrementSpeed(amount);
        intervalBrakeGas(getCurrentSpeed(), 0, enginePower);
        if (intervalBrakeGas) ;
    }

    /***
     *
     * @param amount Correct input will decrease the speed by current speed given by the method decrementSpeed.
     */
    public void brake(double amount){
        decrementSpeed(amount);
            intervalBrakeGas(getCurrentSpeed(),0,enginePower);
            if(intervalBrakeGas);
    }


}