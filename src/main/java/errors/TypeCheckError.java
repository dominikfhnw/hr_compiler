package errors;

import scanner.enums.Types;

public class TypeCheckError extends Exception {

    public TypeCheckError(Types expected, Types found) {
        super(setMessage(expected, found));
    }

    private static String setMessage(Types expected, Types found) {
        return "Expected type " + expected.name() + ", but found " + found.name() + ".";
    }
}
