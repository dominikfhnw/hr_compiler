package concreteSyntaxTree.interfaces.operators;

import concreteSyntaxTree.interfaces.IProduction;
import scanner.operators.Operator;

public interface IRelOpr extends IProduction {

    Operator toAbstractSyntax();

}
