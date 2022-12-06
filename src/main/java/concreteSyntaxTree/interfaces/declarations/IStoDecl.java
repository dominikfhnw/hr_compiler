package concreteSyntaxTree.interfaces.declarations;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.interfaces.IProduction;

public interface IStoDecl extends IProduction {

    StoDecl toAbstractSyntax();

}
