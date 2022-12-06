package concreteSyntaxTree.interfaces.parameterLists;

import abstractSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.interfaces.IProduction;

public interface IParameter extends IProduction {

    Parameter toAbstractSyntax();

}
