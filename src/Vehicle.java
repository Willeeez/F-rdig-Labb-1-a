import java.awt.*;

public abstract class Vehicle implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double currentPositionY; // The current position of Y - coordinate
    public double currentPositionX; // The current position of X - coordinate
    public String currentDirection;
    public boolean interval;

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

    public void move(int time) {

        if(getCurrentSpeed() == 0)
            System.out.println("You have to start the car first.");
        if(getCurrentDirection().equals("South"))
            currentPositionY = getCurrentPositionY() - getCurrentSpeed() * time;
        if(getCurrentDirection().equals("East"))
            currentPositionX = getCurrentPositionX() + getCurrentSpeed() * time;
        if(getCurrentDirection().equals("North"))
            currentPositionY = getCurrentPositionY() + getCurrentSpeed() * time;
        if(getCurrentDirection().equals("West"))
            currentPositionX = getCurrentPositionX() - getCurrentSpeed() * time;
    }


    @Override
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
    @Override
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
    public void interval(double amount, double y, double x) {
        if (amount < y) {
            System.out.println("That is too low of a input, change your variable.");
            System.exit(1);
        }
        if (amount > x) {
            System.out.println("That is too high of a input, change your variable.");
            System.exit(1);
        }
        else {
            interval = true;
        }
    }

    @Override
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
