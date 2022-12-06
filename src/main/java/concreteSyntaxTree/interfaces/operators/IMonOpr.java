package concreteSyntaxTree.interfaces.operators;

import concreteSyntaxTree.interfaces.IProduction;
import scanner.operators.Operator;

public interface IMonOpr extends IProduction {

    Operator toAbstractSyntax();

}
