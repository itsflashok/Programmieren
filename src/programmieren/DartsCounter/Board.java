package programmieren.DartsCounter;

public class Board {
    private Field[] fields;

    public Board() {
        this.fields = new Field[62];
        for (int i = 0; i < 20; i++) {
            this.fields[i] = new Field(Integer.toString((i + 1)), i + 1, false);
            this.fields[i + 20] = new Field("D" + (i + 1), (i + 1) * 2, true);
            this.fields[i + 40] = new Field("T" + (i + 1), (i + 1) * 3, false);
        }
        this.fields[60] = new Field("Single Bull", 25, false);
        this.fields[61] = new Field("BULL", 50, true);
    }

    public Field parseField(String label) {
        for (Field f : fields) {
            if (f.getLabel().equals(label)) {
                return f;
            }
        }
        return null;
    }

}
