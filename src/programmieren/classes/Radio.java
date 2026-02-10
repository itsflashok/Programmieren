package programmieren.classes;

public class Radio {
    public static boolean on = false;
    public static int volume = 100;
    public static double frequency = 85.0;

    public Radio(boolean on, int volume, double frequency) {
        Radio.on = on;
        Radio.volume = volume;
        Radio.frequency = frequency;

    }

    public static void main(String[] args) {
        Radio myRadio = new Radio(on, volume, frequency);
        System.out.println(myRadio);
        myRadio.turnOn();
        System.out.println(myRadio);
        myRadio.incVolume();
        myRadio.incVolume();
        System.out.println(myRadio);

    }

    public void incVolume() {
        if (Radio.on) {
            Radio.volume += 1;
        }
    }

    public void turnOn() {
        Radio.on = true;
    }

    public void turnOff() {
        Radio.on = false;
    }

    public void setFrequency(double frequency) {
        Radio.frequency = frequency;
    }

    public String toString() {
        return String.format("Radio %b: Freq=%f, Laut=%d", Radio.on, Radio.frequency, Radio.volume);
    }
}
