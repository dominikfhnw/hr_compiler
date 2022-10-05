import enums.Terminals;

public class MechMode extends Base {

    enum MechModes {
        COPY,
        REF
    }
    private final MechModes mechmode;

    MechMode(MechModes mechMode) {
        super(Terminals.MECHMODE);
        this.mechmode = mechMode;
    }

    public MechModes getMechMode() {
        return mechmode;
    }

    public String toString() {
        return "(" + super.toString() + ", " + getMechMode().toString() + ")";
    }
}
