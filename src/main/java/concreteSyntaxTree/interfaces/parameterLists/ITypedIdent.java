package concreteSyntaxTree.interfaces.parameterLists;

import abstractSyntaxTree.parameterLists.TypeIdent;
import concreteSyntaxTree.interfaces.IProduction;

public interface ITypedIdent extends IProduction {

        TypeIdent toAbstractSyntax();

}