package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IFactor;
import scanner.Literal;
import scanner.enums.LRValue;
import scanner.enums.Types;

// needs to be implemented

public class LiteralFactor implements IFactor {
    Literal literal;
    Types castType;

    public LiteralFactor(Literal literal) {
        this.literal = literal;
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
