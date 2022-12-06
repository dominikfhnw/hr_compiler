package abstractSyntaxTree.parameterLists;

import scanner.Ident;
import scanner.enums.Types;

public class TypeIdent {

    Ident ident;
    Types type;
    boolean isConst;

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

    public void setConst() {
        this.isConst = true;
    }

    public boolean getConst() {
        return isConst;
    }

}
