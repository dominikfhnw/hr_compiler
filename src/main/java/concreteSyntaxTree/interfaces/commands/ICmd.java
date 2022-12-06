package concreteSyntaxTree.interfaces.commands;

import concreteSyntaxTree.interfaces.IProduction;

public interface ICmd extends IProduction {

    abstractSyntaxTree.interfaces.ICmd toAbstractSyntax();

}
