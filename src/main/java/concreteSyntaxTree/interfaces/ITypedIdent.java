package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.parameterLists.TypeIdent;

public interface ITypedIdent extends IProduction {

        TypeIdent toAbstractSyntax();

}