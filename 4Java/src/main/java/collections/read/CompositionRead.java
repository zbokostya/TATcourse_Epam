package collections.read;

import org.apache.logging.log4j.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompositionRead {

    public List<String> read(String path) {
        File file = new File(path);
        List<String> strings = new ArrayList<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }

            return strings;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        }
    }
}
