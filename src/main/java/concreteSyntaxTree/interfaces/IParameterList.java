package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.parameterLists.Parameter;
import java.util.ArrayList;

public interface IParameterList extends IProduction {

    ArrayList<Parameter> toAbstractSyntax();

}
