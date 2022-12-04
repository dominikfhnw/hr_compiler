package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.Parameter;
import java.util.ArrayList;

public interface IParameterList extends IProduction {

    ArrayList<Parameter> toAbstractSyntax();

}
