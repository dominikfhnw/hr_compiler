package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.Parameter;

import java.util.ArrayList;

public interface IParameterListNTS extends IProduction {

    public ArrayList<Parameter> toAbstractSyntax();

}
