package concreteSyntaxTree.declarations;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.declarations.IDecl;
import concreteSyntaxTree.interfaces.declarations.IFunDecl;

/* decl ::= <funDecl> */

public class DeclFunDecl extends Production implements IDecl {

   final IFunDecl N_funDecl;

   public DeclFunDecl(final IFunDecl N_funDecl) {
       this.N_funDecl = N_funDecl;
   }

    @Override
    public abstractSyntaxTree.interfaces.IDecl toAbstractSyntax() {
        return N_funDecl.toAbstractSyntax();
    }
}
