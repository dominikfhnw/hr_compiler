package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.commands.CpsCmd;

public interface IIfElseNTS extends IProduction {

    CpsCmd toAbstractSyntax();

}
