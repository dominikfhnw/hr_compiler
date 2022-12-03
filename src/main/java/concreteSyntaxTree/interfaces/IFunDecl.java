package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IDecl;

public interface IFunDecl extends IProduction {

    public IDecl toAbstractSyntax();
}
