package concreteSyntaxTree.interfaces.operators;

import concreteSyntaxTree.interfaces.IProduction;
import scanner.operators.Operator;

public interface IMultOpr extends IProduction {

    Operator toAbstractSyntax();

}
