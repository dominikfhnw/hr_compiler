package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IFactor;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.enums.LRValue;
import scanner.enums.Operators;
import scanner.enums.Types;
import scanner.operators.Operator;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;
import java.util.HashMap;

public class MonFactor implements IFactor {

    Operator monOpr;
    IFactor factor;

    public MonFactor(Operator monOpr, IFactor factor) {
        this.monOpr = monOpr;
        this.factor = factor;
    }

    public MonFactor(Operator monOpr) {
        this.monOpr = monOpr;
    }

    @Override
    public Types getType() {
        return factor.getType();
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
        factor.checkScope();
    }

    @Override
    public void checkType() throws TypeCheckError {
        factor.checkType();
        if (monOpr.getOperator().equals(Operators.NOT) && factor.getType() != Types.BOOL) {
            throw new TypeCheckError(Types.BOOL, factor.getType());
        } else if ((monOpr.getOperator().equals(Operators.PLUS) || monOpr.getOperator().equals(Operators.MINUS)) && factor.getType() != Types.INT32) {
            throw new TypeCheckError(Types.INT32, factor.getType());
        }
    }

    @Override
    public void addInstructionToCodeArray(HashMap<String, Integer> localLocations, boolean simulateOnly) throws CodeTooSmallError {
        // TODO: implement
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {
        // TODO: Implement
    }

}
