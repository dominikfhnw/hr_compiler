package scanner;

import errors.TypeError;
import scanner.enums.Terminals;
import scanner.Type.Types;

public class Literal extends Base {

    /**
     * TO BE DONE: Spec for other int-types (INT64, INT1024)
     */

    private final int value;
    private final boolean isBoolean;
    private Types castType;

    public Literal (Terminals terminal, boolean isBoolean) {
        super(terminal);
        this.isBoolean = true;
        this.value = 0;
    }

    public Literal(Terminals terminal, int value) {
        super(terminal);
        this.isBoolean = false;
        this.value = value;
    }

    public Literal(Terminals terminal, int value, boolean isBoolean) {
        super(terminal);
        this.isBoolean = isBoolean;
        this.value = value;
    }

    public Types getType() {
        if (castType != null) {
            return castType;
        }
        return isBoolean ? Types.BOOL : Types.INT32;
    }

    public int getValue(){
        return value;
    }

    public boolean getBoolValue() throws TypeError {
        if (!isBoolean){
            throw new TypeError("Type is not BOOL.");
        }
        return value > 0;
    }

    public int getIntValue() throws TypeError {
        if (isBoolean){
            throw new TypeError("Type is BOOL.");
        }
        return value;
    }

    public void doTypeCast(Types type) {
        this.castType = type;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + ", " + (this.isBoolean ? "BoolVal" : "") + getValue() + ")";
    }
}