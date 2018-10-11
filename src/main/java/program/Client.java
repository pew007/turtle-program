package program;

import interpreter.Expression;
import interpreter.PenUpExpression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {

    public void parseInstructions(String pathToFile) {

        List<Expression> instructions = new ArrayList<Expression>();

        try {
            Scanner scanner = new Scanner(new File(pathToFile));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();


            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
            System.exit(0);
        }
    }

    private boolean matches(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
