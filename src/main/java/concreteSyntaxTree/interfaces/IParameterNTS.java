package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.Parameter;

import java.util.ArrayList;

public interface IParameterNTS extends IProduction {

    public ArrayList<Parameter> toAbstractSyntax(ArrayList<Parameter> temp);

}
