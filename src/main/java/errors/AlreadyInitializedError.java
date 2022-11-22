package errors;

import scanner.Ident;

public class AlreadyInitializedError extends Exception {

    public AlreadyInitializedError(Ident ident) {
        super(setMessage(ident));
    }

    private static String setMessage(Ident ident) {
        return "Identifier is already initialized: " + ident.getIdent();
    }
}
