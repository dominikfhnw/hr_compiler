import enums.Terminals;

public class Base implements IToken {

    private final Terminals terminal;

    Base (Terminals terminal) {
        this.terminal = terminal;
    }

    public Terminals getTerminal() {
        return terminal;
    }

    public boolean isTerminal() {
        return terminal != null;
    }

    @Override
    public String toString() {
        return getTerminal().toString();
    }

}

