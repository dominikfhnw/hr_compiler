package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.commands.CpsCmd;

public interface ICpsCmd extends IProduction {

    CpsCmd toAbstractSyntax();

}
