package concreteSyntaxTree.interfaces.commands;

import abstractSyntaxTree.commands.CpsCmd;
import concreteSyntaxTree.interfaces.IProduction;

public interface ICpsCmd extends IProduction {

    CpsCmd toAbstractSyntax();

}
