package abstractSyntaxTree;

import scanner.Ident;
import scanner.enums.Types;

public class TypedIdent {

    private Ident ident;
    private Types type;
    private boolean isInit;

    public TypedIdent(Ident ident, Types type) {
        this.ident = ident;
        this.type = type;
    }

    public Ident getIdent() {
        return ident;
    }

    public Types getType() {
        return type;
    }

    public boolean isInit() {
        return isInit;
    }

    public void setInit() {
        this.isInit = true;
    }

}
