package scanner.modesAndTypes;

import scanner.Base;
import scanner.enums.Terminals;
import scanner.enums.Types;

public class Type extends Base {

    private final Types type;

    public Type(Types type) {
        super(Terminals.TYPE);
        this.type = type;
    }

    public Types getType() {
        return type;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + "," + getType().toString() + ")";
    }
}
