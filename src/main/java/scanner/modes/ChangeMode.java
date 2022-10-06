package scanner.modes;
import scanner.enums.Terminals;

import scanner.Base;
public class ChangeMode extends Base {
    enum ChangeModes {
        CONST,
        VAR
    }
    private final ChangeModes changeMode;

    ChangeMode(ChangeModes changeMode) {
        super(Terminals.CHANGEMODE);
        this.changeMode = changeMode;
    }

    public ChangeModes getChangeMode() {
        return changeMode;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + "," + getChangeMode().toString() + ")";
    }
}
