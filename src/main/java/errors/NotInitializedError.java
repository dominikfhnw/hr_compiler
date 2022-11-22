package errors;

import scanner.Ident;

public class NotInitializedError extends Exception {

    public NotInitializedError(Ident ident) {
        super(setMessage(ident));
    }

    private static String setMessage(Ident ident) {
        return "Identifier has not been initialized: " + ident.getIdent();
    }
}
