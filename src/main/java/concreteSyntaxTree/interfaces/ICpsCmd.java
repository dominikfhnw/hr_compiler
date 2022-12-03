package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.CpsCmd;

public interface ICpsCmd extends IProduction {

    public CpsCmd toAbstractSyntax();

}
