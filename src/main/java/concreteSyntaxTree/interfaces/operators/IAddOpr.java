package concreteSyntaxTree.interfaces.operators;

import concreteSyntaxTree.interfaces.IProduction;
import scanner.operators.Operator;

public interface IAddOpr extends IProduction {

    Operator toAbstractSyntax();

}
