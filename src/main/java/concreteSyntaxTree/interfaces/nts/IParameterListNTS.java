package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IParameterListNTS extends IProduction {

    ArrayList<Parameter> toAbstractSyntax();

}
