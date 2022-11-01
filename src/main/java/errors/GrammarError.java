package errors;

import scanner.enums.Terminals;

public class GrammarError extends Exception {

    public GrammarError (String errorMessage) {
        super(errorMessage);
    }

    public GrammarError(Terminals expected, Terminals actual) {
        super("Expected terminal " + expected.toString() + ", but found terminal " + actual.toString());
    }

}
