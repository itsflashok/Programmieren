package programmieren.IO;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileExperiments {
    static String path = "src/programmieren/IO/";

    public static void main(String[] args) {
        File directory = new File(path + "myDir");
        if (!directory.exists()) {
            directory.mkdir();
        }

        directory.deleteOnExit(); // Verzeichnis ZUERST registrieren (wird dann ZULETZT gelöscht)

        for (int i = 0; i < 3; i++) {
            File file = new File(String.format("%s/myDir/foo%d.txt", path, i));
            try {
                file.createNewFile();
                file.deleteOnExit();
                System.out.println("Created file: " + file.getName());
            } catch (Exception e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }

        System.out.println(directory.listFiles());

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
