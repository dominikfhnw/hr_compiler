package abstractSyntaxTree.interfaces;

import scanner.enums.LRValue;
import scanner.enums.Types;

public interface IExpression {

    public Types getType();
    public LRValue getLRValue();
    public void doTypeCast(Types type);

}
