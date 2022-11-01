package scanner;

import scanner.enums.Terminals;
import scanner.Base;

public class Type extends Base {

    public enum Types {
        BOOL,
        INT32
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
