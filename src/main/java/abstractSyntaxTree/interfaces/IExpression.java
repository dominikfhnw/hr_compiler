package abstractSyntaxTree.interfaces;

import scanner.enums.LRValue;
import scanner.enums.Types;

public interface IExpression extends IAbstractSyntaxTreeNode{

    Types getType();
    LRValue getLRValue();

}
