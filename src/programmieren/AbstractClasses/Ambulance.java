package programmieren.AbstractClasses;

public class Ambulance extends Car {
    private boolean sirenOn = false;

    public Ambulance(double speed, boolean sirenOn) {
        super(speed);
        this.sirenOn = sirenOn;
    }

    public boolean isSirenOn() {
        return sirenOn;
    }

    public void setSirenOn(boolean sirenOn) {
        this.sirenOn = sirenOn;
    }

    @Override
    public void info() {
        String sirenStatus = sirenOn ? "Blaulicht an" : "Blaulicht aus";
        System.out.printf("Ambulance: %d wheels, speed %.1f km/h (max %.1f km/h), distance %.1f km, %s%n",
                getAmountOfWheels(), getSpeed(), getMaxSpeed(), getDistance(), sirenStatus);
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        String sirenStatus = sirenOn ? "Signal on" : "Signal off";
        return baseInfo.replace(".", ". " + sirenStatus + ".");
    }
}
