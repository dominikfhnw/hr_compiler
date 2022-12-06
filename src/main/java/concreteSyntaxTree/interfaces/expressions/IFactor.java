package concreteSyntaxTree.interfaces.expressions;

import concreteSyntaxTree.interfaces.IProduction;

public interface IFactor extends IProduction {

    abstractSyntaxTree.interfaces.IFactor toAbstractSyntax();

}