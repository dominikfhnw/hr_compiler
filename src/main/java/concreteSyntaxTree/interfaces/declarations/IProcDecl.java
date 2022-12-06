package concreteSyntaxTree.interfaces.declarations;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.IProduction;

public interface IProcDecl extends IProduction {

    IDecl toAbstractSyntax();

}
