import java.awt.*;

public abstract class Vehicle implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double currentPositionY = 0; // The current position of Y - coordinate
    public double currentPositionX = 0; // The current position of X - coordinate
    public String currentDirection;
    public boolean intervalBrakeGas;
    public boolean intervalChangeSpeed;
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, String currentDirection){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = currentDirection;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public String getModelName(){
        return modelName;
    }

    public void move() {

        if(getCurrentSpeed() == 0)
            System.out.println("You have to start the car first.");
        else if(getCurrentDirection().equals("South"))
            currentPositionY = getCurrentPositionY() - getCurrentSpeed() ;
        else if(getCurrentDirection().equals("East"))
            currentPositionX = getCurrentPositionX() + getCurrentSpeed() ;
        else if(getCurrentDirection().equals("North"))
            currentPositionY = getCurrentPositionY() + getCurrentSpeed() ;
        else if (getCurrentDirection().equals("West"))
            currentPositionX = getCurrentPositionX() - getCurrentSpeed() ;
    }

    public void turnLeft() {
        if(currentDirection.equals("North"))
            currentDirection = "West";
        else if(currentDirection.equals("West"))
            currentDirection = "South";
        else if(currentDirection.equals("South"))
            currentDirection = "East";
        else if(currentDirection.equals("East"))
            currentDirection = "North";
    }

    public void turnRight() {
        if(currentDirection.equals("North"))
            currentDirection = "East";
        else if(currentDirection.equals("East"))
            currentDirection = "South";
        else if(currentDirection.equals("South"))
            currentDirection = "West";
        else if(currentDirection.equals("West"))
            currentDirection = "North";
    }
    public void intervalBrakeGas(double amount, double y, double x) {
        if (amount < y) {
            System.out.println("You are now at a standstill");
            currentSpeed = 0;
            intervalBrakeGas = false;
            System.exit(1);
        }
        if (amount > x) {
            System.out.println("You are now going the max speed of " + x + ".");
            currentSpeed = x;
            intervalBrakeGas = false;
            System.exit(1);
        }
        else {
            intervalBrakeGas = true;
        }
    }
    public void intervalChangeSpeed(double amount, double y, double x) {
        if (amount < y) {
            System.out.println("You have to put pressure on the pedal");
            currentSpeed = 0;
            intervalBrakeGas = false;
            System.exit(1);
        }
        if (amount > x) {
            System.out.println("You are putting too much pressure on the pedal");
            currentSpeed = x;
            intervalBrakeGas = false;
            System.exit(1);
        }
        else {
            intervalChangeSpeed = true;
        }
    }

    public String getCurrentDirection() {
        return currentDirection;
    }

    public double getCurrentPositionX() {
        return currentPositionX;
    }

    public double getCurrentPositionY() {
        return currentPositionY;
    }
}