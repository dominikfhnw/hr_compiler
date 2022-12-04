package scanner.modesAndTypes;

import scanner.enums.MechModes;
import scanner.enums.Terminals;
import scanner.Base;

public class MechMode extends Base {

    final MechModes mechMode;

    MechMode(MechModes mechMode) {
        super(Terminals.MECHMODE);
        this.mechMode = mechMode;
    }

    public MechModes getMechMode() {
        return mechMode;
    }

    public String toString() {
        return "(" + super.toString() + ", " + getMechMode().toString() + ")";
    }
}
