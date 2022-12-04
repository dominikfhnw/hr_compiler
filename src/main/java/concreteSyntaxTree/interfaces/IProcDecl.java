package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IDecl;

public interface IProcDecl extends IProduction {

    IDecl toAbstractSyntax();

}
