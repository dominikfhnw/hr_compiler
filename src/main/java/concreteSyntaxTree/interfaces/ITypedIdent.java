package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.TypeIdent;

public interface ITypedIdent extends IProduction {

        TypeIdent toAbstractSyntax();

}