package errors;

import scanner.enums.LRValue;

public class LRValueError extends Exception {

    public LRValueError(LRValue expected, LRValue found) {
        super(setupMessage(expected, found));
    }

    public LRValueError(LRValue expected, LRValue found, Throwable cause) {
        super(setupMessage(expected, found), cause);
    }

    private static String setupMessage(LRValue expected, LRValue found) {
        return "Expected [" + expected.name() + "] but found [" + found.name() + "]";
    }

}