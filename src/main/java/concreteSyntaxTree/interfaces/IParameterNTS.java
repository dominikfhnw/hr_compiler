package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.Parameter;
import java.util.ArrayList;

public interface IParameterNTS extends IProduction {

    ArrayList<Parameter> toAbstractSyntax(ArrayList<Parameter> temp);

}
