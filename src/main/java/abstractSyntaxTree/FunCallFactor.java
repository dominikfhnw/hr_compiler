package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IExpression;
import scanner.Ident;
import scanner.enums.LRValue;
import scanner.enums.Types;

import java.util.ArrayList;

// needs to be implemented

public class FunCallFactor extends IdentFactor {

    ArrayList<IExpression> expressions;
    Types castType;

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
        return null;
    }

    @Override
    public void doTypeCast(Types type) {

    }
}
