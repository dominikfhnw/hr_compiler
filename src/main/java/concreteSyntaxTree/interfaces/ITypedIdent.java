package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.TypedIdent;

public interface ITypedIdent extends IProduction {

        TypedIdent toAbstractSyntax();

}