package abstractSyntaxTree;

import scanner.Ident;
import scanner.enums.LRValue;
import scanner.enums.Types;

// needs to be implemented

public class InitFactor extends IdentFactor {

    boolean init;
    Types castType;

    public InitFactor(Ident ident, boolean init) {
        this.ident = ident;
        this.init = init;
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
