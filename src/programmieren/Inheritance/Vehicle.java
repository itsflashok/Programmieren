package programmieren.Inheritance;

public class Vehicle {
    private int amountOfWheels = 0;
    private double maxSpeed;
    private double distance;
    private double speed = 0;

    public Vehicle(int amountOfWheels, double maxSpeed, int distance, double speed) {
        this.amountOfWheels = amountOfWheels;
        this.maxSpeed = maxSpeed;
        this.distance = distance;
        setSpeed(speed);
    }

    public void setSpeed(double speed) {
        if (speed > maxSpeed) {
            this.speed = maxSpeed;
        } else {
            this.speed = speed;
        }
    }

    public void drive(double minutes) {
        if (this.speed > 0 && minutes > 0) {
            this.distance += this.speed * (minutes / 60.0);
        }
    }

    public int getAmountOfWheels() {
        return amountOfWheels;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        String className = this.getClass().getSimpleName();
        return String.format("%s at position %.1f km with %d wheels at speed %.1f km/h of max. %.1f km/h.",
                className, distance, amountOfWheels, speed, maxSpeed);
    }

}
