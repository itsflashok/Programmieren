package programmieren.DartsCounter;

public class Visit {
    private Field[] fields = new Field[3];

    public Visit(Field[] fields) {
        this.fields = fields;
        IllegalArgumentException ex = new IllegalArgumentException("A visit must consist of three fields.");
        if (fields.length != 3) {
            throw ex;
        }
    }

    public Field[] getFields() {
        return fields;
    }

    public int getValue() {
        int sum = 0;
        for (Field f : fields) {
            sum += f.getValue();
        }
        return sum;
    }

    public Field getLastField() {
        return fields[fields.length - 1];
    }
}
