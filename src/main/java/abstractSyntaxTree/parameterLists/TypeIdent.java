package abstractSyntaxTree.parameterLists;

import abstractSyntaxTree.AbstractSyntaxTreeNode;
import scanner.Ident;
import scanner.enums.Types;

// toString must be implemented

public class TypeIdent extends AbstractSyntaxTreeNode {

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

    public String getValue() {
        return ident.getIdent();
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

    @Override
    public String toString(String indent) {
        return null;
    }

}
