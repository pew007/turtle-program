package interpreter;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void parse() {
        Parser parser = new Parser();
        parser.parse("/Users/pwang/Documents/cs635/turtle-program/src/test/resources/instructions.txt");
    }
}