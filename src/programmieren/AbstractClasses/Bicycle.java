package programmieren.AbstractClasses;

public class Bicycle extends Vehicle {
    public Bicycle(double speed) {
        super(2, 30, 0, speed);
    }

    @Override
    public void info() {
        System.out.printf("Bicycle: %d wheels, speed %.1f km/h (max %.1f km/h), distance %.1f km%n",
                getAmountOfWheels(), getSpeed(), getMaxSpeed(), getDistance());
    }
}
