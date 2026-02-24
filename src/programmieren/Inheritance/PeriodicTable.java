package programmieren.Inheritance;

public class PeriodicTable {
    private Element[] elements;
    private int count;

    // Constructor
    public PeriodicTable() {
        this.elements = new Element[118];
        this.count = 0;
    }

    // Add element if it doesn't exist yet (based on ordinal)
    public void addElement(Element e) {
        if (!hasElement(e.getOrdinal())) {
            elements[count] = e;
            count++;
        }
    }

    // Check if element with ordinal o exists
    public boolean hasElement(int o) {
        for (int i = 0; i < count; i++) {
            if (elements[i].getOrdinal() == o) {
                return true;
            }
        }
        return false;
    }

    // Get element by ordinal
    public Element getElement(int o) {
        for (int i = 0; i < count; i++) {
            if (elements[i].getOrdinal() == o) {
                return elements[i];
            }
        }
        return null;
    }

    // Get all metals
    public Element[] getMetals() {
        // First count how many metals we have
        int metalCount = 0;
        for (int i = 0; i < count; i++) {
            if (elements[i] instanceof Metal) {
                metalCount++;
            }
        }

        // Create array and fill it
        Element[] metals = new Element[metalCount];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (elements[i] instanceof Metal) {
                metals[index] = elements[i];
                index++;
            }
        }

        return metals;
    }

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();

        // Create elements according to specification
        // H - Wasserstoff (Hydrogen)
        Element h = new Element("Wasserstoff", "H", 1, 'K', Element.GAS, Element.MAIN);

        // He - Helium
        Element he = new Element("Helium", "He", 2, 'K', Element.GAS, Element.MAIN);

        // Na - Natrium (Sodium)
        Metal na = new Metal("Natrium", "Na", 11, 'M', Element.SOLID, Element.MAIN, false, 21e6);

        // Fe - Eisen (Iron)
        Metal fe = new Metal("Eisen", "Fe", 26, 'N', Element.SOLID, Element.SIDE, false, 10.02e6);

        // Ge - Germanium
        Metal ge = new Metal("Germanium", "Ge", 32, 'N', Element.SOLID, Element.SIDE, true, 1.45);

        // Br - Brom (Bromine)
        Element br = new Element("Brom", "Br", 35, 'N', Element.LIQUID, Element.MAIN);

        // Te - Tellur (Tellurium)
        Metal te = new Metal("Tellur", "Te", 52, 'O', Element.SOLID, Element.MAIN, true, 0.005);

        // Au - Gold
        Metal au = new Metal("Gold", "Au", 79, 'P', Element.SOLID, Element.SIDE, false, 44.0e6);

        // Add all elements to the table
        table.addElement(h);
        table.addElement(he);
        table.addElement(na);
        table.addElement(fe);
        table.addElement(ge);
        table.addElement(br);
        table.addElement(te);
        table.addElement(au);

        // Output all elements
        System.out.println("Alle Elemente:");
        for (int i = 0; i < table.count; i++) {
            System.out.println(table.elements[i].toString());
        }

        System.out.println("\nMetalle:");
        Element[] metals = table.getMetals();
        for (int i = 0; i < metals.length; i++) {
            System.out.println(metals[i].toString());
        }

        System.out.println("\nGold:");
        Element gold = table.getElement(79);
        if (gold != null) {
            System.out.println(gold.toString());
        }
    }
}
