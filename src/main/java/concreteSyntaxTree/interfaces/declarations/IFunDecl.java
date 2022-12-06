package concreteSyntaxTree.interfaces.declarations;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.IProduction;

public interface IFunDecl extends IProduction {

    IDecl toAbstractSyntax();

}
