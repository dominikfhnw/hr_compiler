import enums.Terminals;

public class Literal extends Base {
    private final int value;

    // Literal-Constructor needs to be specified for different types (INT32, INT64, INT1024, BOOL)

    Literal (Terminals terminal) {
        super(terminal);
        this.value = 0;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + "," + getValue() + ")";
    }
}
