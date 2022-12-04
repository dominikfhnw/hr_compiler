package abstractSyntaxTree.parameterLists;

import scanner.Ident;
import scanner.enums.Types;

// needs to be implemented

public class TypeIdent {

    Ident ident;
    Types type;
    boolean isConst;
    boolean isInit;

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

    public void setInit() {
        this.isInit = true;
    }

    public boolean getInit() {
        return isInit;
    }

    public void setConst() {
        this.isConst = true;
    }

    public boolean getConst() {
        return isConst;
    }


}
