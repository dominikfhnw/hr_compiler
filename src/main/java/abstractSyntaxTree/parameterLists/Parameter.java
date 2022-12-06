package abstractSyntaxTree.parameterLists;

import abstractSyntaxTree.AbstractSyntaxTreeNode;
import scanner.enums.ChangeModes;
import scanner.enums.LRValue;
import scanner.enums.MechModes;

// toString must be implemented

public class Parameter extends AbstractSyntaxTreeNode {

    MechModes mechMode;
    ChangeModes changeMode;
    TypeIdent typeIdent;
    LRValue LRValue;

    public Parameter(MechModes mechMode, ChangeModes changeMode, TypeIdent typeIdent) {
        this.mechMode = mechMode != null ? mechMode : MechModes.COPY;
        this.changeMode = changeMode != null ? changeMode : ChangeModes.CONST;
        this.typeIdent = typeIdent;
        if (changeMode == ChangeModes.CONST){
            this.typeIdent.setConst();
        }
        LRValue = this.mechMode == MechModes.COPY ? LRValue.RVALUE : LRValue.LVALUE;
    }

    public String getIdentString() {
        return typeIdent.getValue();
    }

    public TypeIdent getTypeIdent() {
        return typeIdent;
    }

    public LRValue getLRValue() {
        return LRValue;
    }

    public MechModes getMechMode() {
        return mechMode;
    }

    @Override
    public String toString(String indent) {
       return null;
    }

}
