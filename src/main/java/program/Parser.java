package program;

import interpreter.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {

    public List<Expression> parseInstructions(String pathToFile) throws FileNotFoundException, IllegalArgumentException {

        List<Expression> instructions = new ArrayList<Expression>();

        boolean needsRepeat = false;
        ArrayList<Expression> repeatedStatements = new ArrayList<Expression>();

        Scanner scanner = new Scanner(new File(pathToFile));
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().trim();
            if (currentLine.equals("")) {
                continue;
            }

            Expression expression = null;
            String[] segments = currentLine.split(" ");
            String command = segments[0];

            if (matches("penUp", command)) {
                expression = new PenUpExpression();
            } else if (matches("penDown", command)) {
                expression = new PenDownExpression();
            } else if (matches("move", command)) {
                String argument = segments[1].toLowerCase();
                expression = new MoveExpression(0);
            } else if (matches("turn", command)) {
                expression = new TurnExpression(0);
            } else if (matches("#[a-zA-Z]*", command)) {
                expression = new AssignmentExpression("", 0);
            } else if (matches("repeat", command)) {
                needsRepeat = true;
                repeatedStatements = new ArrayList<Expression>();
            } else if (matches("end", command)) {
                expression = new RepeatExpression(0, repeatedStatements);
                needsRepeat = false;
            } else {
                throw new IllegalArgumentException(String.format("Unrecognized command: %s", currentLine));
            }

            if (expression == null) {
                continue;
            }

            if (needsRepeat) {
                repeatedStatements.add(expression);
            } else {
                instructions.add(expression);
            }
        }

        return instructions;
    }

    private boolean matches(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
