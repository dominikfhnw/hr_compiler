package abstractSyntaxTree.factors;

import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import scanner.Ident;
import scanner.enums.LRValue;
import scanner.enums.Types;
import java.util.ArrayList;
import java.util.HashMap;

// methods must be implemented

public class FunCallFactor extends IdentFactor {

    ArrayList<IExpression> expressions;

    public FunCallFactor(Ident ident, ArrayList<IExpression> expressions) {
        this.ident = ident;
        this.expressions = expressions;
    }

    @Override
    public Types getType() {
        return null;
    }

    @Override
    public LRValue getLRValue() {
        return LRValue.RVALUE;
    }

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {
    }

    @Override
    public void checkType() throws TypeCheckError {
    }

    @Override
    public String toString(String indent) {
        return null;
    }

    @Override
    public void storeNamespace(HashMap<String, TypeIdent> localStoresNamespace) throws AlreadyDeclaredError {

    }

}
