package abstractSyntaxTree.parameterLists;

import abstractSyntaxTree.AbstractSyntaxTreeNode;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.ChangeModes;
import scanner.enums.LRValue;
import scanner.enums.MechModes;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import virtualMachine.interfaces.IInstructions;

import java.util.HashMap;

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
        // TODO: implement
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // TODO: implement
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        // do nothing
    }

    @Override
    public void checkType() throws TypeCheckError {
        // do nothing
    }

    @Override
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly)
        throws CodeTooSmallError {
        if (!simulateOnly) {
            codeArray.put(codeArrayPointer, new IInstructions.AllocBlock(1));
        }
        codeArrayPointer++;
    }
}
