import java.awt.*;

public class Volvo240 extends Vehicle {
    /***
     * The trimFactor is used to amplify the cars speed
     */
    public final static double trimFactor = 1.25;

    /***
     * Gives the new car its attributes from the superclass Vehicle and sets own attributes
     */
    public Volvo240() {
        super(4,100,Color.black,"Volvo240", "South");
        intervalBrakeGas = true;
        intervalChangeSpeed = true;
        currentPositionY = 0;
        currentPositionX = 0;
    }

    /***
     *
     * @return Will return the speedfactor we have increased current speed with.
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    /***
     *
     * @param amount usage in the method gas where we determine if the gas pedal is pushed or not, if so, the speed
     *               is increased.
     */
     void incrementSpeed(double amount) {
        intervalChangeSpeed(amount,0,1);
        if(intervalChangeSpeed)
           currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /***
     *
     * @param amount usage in the method brake where we determine if the brake pedal is pushed or not, if so, the speed
     *               is decreased.
     */
    public void decrementSpeed(double amount) {
        intervalChangeSpeed(amount,0,1);
        if(intervalChangeSpeed)
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /***
     *
     * @param amount Correct input will increase the speed by current speed given by the method incrementSpeed
     */
    public void gas(double amount) {
        incrementSpeed(amount);

        intervalBrakeGas(getCurrentSpeed(), 0, enginePower);
        if (intervalBrakeGas);

    }

    /***
     *
     * @param amount Correct input will decrease the speed by current speed given by the method decrementSpeed.
     */
    public void brake(double amount) {
        decrementSpeed(amount);
        intervalBrakeGas(getCurrentSpeed(), 0, enginePower);
          if (intervalBrakeGas) ;

    }
}
