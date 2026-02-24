package programmieren.Inheritance;

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
    public String toString() {
        String baseInfo = super.toString();
        String sirenStatus = sirenOn ? "Signal on" : "Signal off";
        return baseInfo.replace(".", ". " + sirenStatus + ".");
    }

}