package programmieren.AbstractClasses;

public class Car extends Vehicle {
    public Car(double speed) {
        super(4, 140, 0, speed);
    }

    protected Car(double maxSpeed, double speed) {
        super(4, maxSpeed, 0, speed);
    }

    @Override
    public void info() {
        System.out.printf("Car: %d wheels, speed %.1f km/h (max %.1f km/h), distance %.1f km%n",
                getAmountOfWheels(), getSpeed(), getMaxSpeed(), getDistance());
    }
}
