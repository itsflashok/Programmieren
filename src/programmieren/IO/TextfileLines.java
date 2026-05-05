package programmieren.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextfileLines {
    public static void main(String[] args) {
        String path = "src/programmieren/IO/beispiel.txt";

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            int lineNumber = 1;
            String concatenated = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (lineNumber >= 2 && lineNumber <= 5) {
                    System.out.println(line);
                    concatenated += line;
                }

                lineNumber++;
            }

            System.out.println("Zeile 2-5: " + concatenated);
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
