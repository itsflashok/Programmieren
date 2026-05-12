package programmieren.AbstractClasses;

public class RacingCar extends Car {
    public RacingCar(double speed) {
        super(220, speed);
    }

    @Override
    public void info() {
        System.out.printf("RacingCar: %d wheels, speed %.1f km/h (max %.1f km/h), distance %.1f km%n",
                getAmountOfWheels(), getSpeed(), getMaxSpeed(), getDistance());
    }
}
