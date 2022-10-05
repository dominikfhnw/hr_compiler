package scanner;

import scanner.enums.Terminals;
import scanner.Base;

public class Type extends Base {

    public enum Types {
        BOOL,
        INT32,
        INT64,
        INT1024
    }

    private final Types type;

    public Type(Types type) {
        super(Terminals.TYPE);
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    public String toString() {
        return "(" + super.toString() + "," + getType().toString() + ")";
    }
}
