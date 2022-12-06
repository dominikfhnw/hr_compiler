package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IType;
import scanner.interfaces.IToken;

/* <type> ::= bool | int32 */

public class Type extends Production implements IType {

    final IToken T_type;

    public Type(final IToken T_type) {
        this.T_type = T_type;
    }

    @Override
    public scanner.modesAndTypes.Type toAbstractSyntax() {
        return (scanner.modesAndTypes.Type) T_type;
    }

}