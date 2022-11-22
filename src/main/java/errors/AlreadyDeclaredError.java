package errors;

public class AlreadyDeclaredError extends Exception {

    public AlreadyDeclaredError(String errorMessage) {
        super(setMessage(errorMessage));
    }

    private static String setMessage(String string) {
        return "Name has already been declared: " + string;
    }
}
