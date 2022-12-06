package concreteSyntaxTree.interfaces.parameterLists;

import abstractSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IParameterList extends IProduction {

    ArrayList<Parameter> toAbstractSyntax();

}
