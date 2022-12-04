package abstractSyntaxTree.parameterLists;

import scanner.Ident;
import scanner.enums.Types;

// needs to be implemented

public class TypeIdent {

    private Ident ident;
    private Types type;
    private boolean isInit;

    public TypeIdent(Ident ident, Types type) {
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
