package interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public void parse(String pathToFile) {

        List<String> instructions = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(pathToFile));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                instructions.add(currentLine);
            }

            for (String line : instructions) {
                System.out.println(line);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            System.exit(0);
        }
    }
}
