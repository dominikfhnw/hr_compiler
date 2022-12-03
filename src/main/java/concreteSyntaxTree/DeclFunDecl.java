package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.IFunDecl;

// decl ::= funDecl
public class DeclFunDecl extends Production implements IDecl {

   final IFunDecl N_funDecl;

   public DeclFunDecl(IFunDecl N_funDecl) {
       this.N_funDecl = N_funDecl;
   }

    @Override
    public abstractSyntaxTree.interfaces.IDecl toAbstractSyntax() {
        return N_funDecl.toAbstractSyntax();
    }
}
