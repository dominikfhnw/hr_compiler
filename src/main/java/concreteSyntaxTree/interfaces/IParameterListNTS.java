package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.Parameter;
import java.util.ArrayList;

public interface IParameterListNTS extends IProduction {

    ArrayList<Parameter> toAbstractSyntax();

}
