package scanner;

import scanner.enums.Terminals;

public class Ident extends Base {

    private final String ident;

    public Ident(Terminals terminal, String ident) {
        super(terminal);
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + ", \"" + getIdent() + "\")";
    }

}
