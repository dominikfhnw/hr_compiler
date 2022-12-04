package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.parameterLists.Parameter;
import java.util.ArrayList;

public interface IParameterListNTS extends IProduction {

    ArrayList<Parameter> toAbstractSyntax();

}
