package abstractSyntaxTree.interfaces;

import scanner.enums.LRValue;
import scanner.enums.Types;

public interface IExpression {

    Types getType();
    LRValue getLRValue();
    void doTypeCast(Types type);

}
