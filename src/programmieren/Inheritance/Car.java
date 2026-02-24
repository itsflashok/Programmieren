package programmieren.Inheritance;

public class Car extends Vehicle {
    public Car(double speed) {
        super(4, 140, 0, speed);
    }

    protected Car(double maxSpeed, double speed) {
        super(4, maxSpeed, 0, speed);
    }

}
