package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.commands.CpsCmd;
import concreteSyntaxTree.interfaces.IProduction;

public interface IIfElseNTS extends IProduction {

    CpsCmd toAbstractSyntax();

}
