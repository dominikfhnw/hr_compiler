package concreteSyntaxTree.interfaces;

import scanner.operators.Operator;

public interface IMonadicOpr extends IProduction {

    Operator toAbstractSyntax();

}
