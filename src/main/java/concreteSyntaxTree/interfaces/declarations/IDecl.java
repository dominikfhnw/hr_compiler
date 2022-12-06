package concreteSyntaxTree.interfaces.declarations;

import concreteSyntaxTree.interfaces.IProduction;

public interface IDecl extends IProduction {

    abstractSyntaxTree.interfaces.IDecl toAbstractSyntax();

}