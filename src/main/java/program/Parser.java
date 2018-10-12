package program;

import interpreter.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Parser {

    // tokens
    static String PEN_UP = "penUp";
    static String PEN_DOWN = "penDown";
    static String MOVE = "move";
    static String TURN = "turn";
    static String ASSIGN = "#[a-zA-Z]*";
    static String REPEAT = "repeat";
    static String END = "end";

    List<Expression> parseInstructions(String pathToFile) throws FileNotFoundException, IllegalArgumentException {

        List<Expression> instructions = new ArrayList<Expression>();

        boolean needsRepeat = false;
        ArrayList<Expression> repeatedStatements = null;
        Expression repetition = null;

        Scanner scanner = new Scanner(new File(pathToFile));
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine().trim();
            if (currentLine.equals("")) {
                continue;
            }

            Expression expression = null;
            String[] segments = currentLine.split(" ");
            String token = segments[0];

            if (matches(PEN_UP, token)) {
                expression = new PenUpExpression();
            } else if (matches(PEN_DOWN, token)) {
                expression = new PenDownExpression();
            } else if (matches(MOVE, token)) {

                String argumentString = segments[1];
                Expression argument = parseArgument(argumentString);
                expression = new MoveExpression(argument);

            } else if (matches(TURN, token)) {

                String argumentString = segments[1];
                Expression argument = parseArgument(argumentString);
                expression = new TurnExpression(argument);

            } else if (matches(ASSIGN, token)) {

                String[] parts = currentLine.split("=");
                String variableName = parts[0].trim();
                Expression value = parseArgument(parts[1].trim());

                expression = new AssignmentExpression(variableName, value);
            } else if (matches(REPEAT, token)) {
                needsRepeat = true;
                repeatedStatements = new ArrayList<Expression>();
                repetition = parseArgument(segments[1].trim());
            } else if (matches(END, token)) {
                expression = new RepeatExpression(repetition, repeatedStatements);
                needsRepeat = false;
            } else {
                throw new IllegalArgumentException("Unrecognized command: " + currentLine);
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

    Expression parseArgument(String string) {
        try {
            int intVal = Integer.parseInt(string);

            return new Constant(intVal);
        } catch (NumberFormatException e) {
            // if the string cannot be parsed to an integer then it's a variable
            return new Variable(string);
        }
    }
}
