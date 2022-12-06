package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IType;
import scanner.interfaces.IToken;

/* <type> ::= bool | int32 */

public class Type extends Production implements IType {

    final IToken T_type;

    public Type(IToken T_type) {
        this.T_type = T_type;
    }

    @Override
    public scanner.Type toAbstractSyntax() {
        return (scanner.Type) T_type;
    }

}