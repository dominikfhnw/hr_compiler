package abstractSyntaxTree.parameterLists;

import scanner.enums.ChangeModes;
import scanner.enums.LRValue;
import scanner.enums.MechModes;

// needs to be implemented

public class Parameter {

    MechModes mechMode;
    ChangeModes changeMode;
    TypeIdent typeIdent;
    LRValue LRValue;

    public Parameter(MechModes mechMode, ChangeModes changeMode, TypeIdent typeIdent) {
        this.mechMode = mechMode != null ? mechMode : MechModes.COPY;
        this.changeMode = changeMode != null ? changeMode : ChangeModes.CONST;
        this.typeIdent = typeIdent;
        this.typeIdent.setInit();
        if (changeMode == ChangeModes.CONST){
            this.typeIdent.setConst();
        }
        LRValue = this.mechMode == MechModes.COPY ? LRValue.RVALUE : LRValue.LVALUE;
    }

}
