package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IAbstractSyntaxTreeNode;

public interface ICmd extends IProduction {

    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax();

}
