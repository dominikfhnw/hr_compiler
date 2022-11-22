package errors;

public class NotDeclaredError extends Exception {

    public NotDeclaredError(String errorMessage) {
        super(setMessage(errorMessage));
    }

    private static String setMessage(String string) {
        return "Name has not been declared: " + string;
    }

}
