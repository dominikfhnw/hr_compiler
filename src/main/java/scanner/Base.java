package scanner;

import scanner.enums.Terminals;
import scanner.interfaces.IToken;

public class Base implements IToken {

    private final Terminals terminal;

    public Base (Terminals terminal) {
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

