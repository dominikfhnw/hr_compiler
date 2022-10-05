import enums.Terminals;

public class ChangeMode extends Base {
    enum ChangeModes {
            VAR,
            CONST
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
