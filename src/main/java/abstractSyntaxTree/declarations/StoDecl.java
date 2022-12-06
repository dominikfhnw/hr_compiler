package abstractSyntaxTree.declarations;

import abstractSyntaxTree.parameterLists.TypeIdent;
import abstractSyntaxTree.interfaces.IDecl;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.ChangeModes;

// methods must be implemented

public class StoDecl implements IDecl {

    ChangeModes changeMode;
    TypeIdent typeIdent;

    public StoDecl(ChangeModes changeMode, TypeIdent typeIdent) {
        this.changeMode = changeMode;
        this.typeIdent = typeIdent;
        // set constant boolean value on the typeIdent to true
        if (changeMode == ChangeModes.CONST)
            this.typeIdent.setConst();
    }

    public StoDecl(TypeIdent typeIdent) {
        this.typeIdent = typeIdent;
    }

    public TypeIdent getTypeIdent() {
        return typeIdent;
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void checkScope() throws NotDeclaredError {

    }

    @Override
    public void checkType() throws TypeCheckError {

    }

    @Override
    public String getIdentString() {
        return null;
    }

}
