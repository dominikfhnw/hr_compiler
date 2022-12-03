package concreteSyntaxTree;

// paramNTS ::= COMMA param paramNTS

import abstractSyntaxTree.Parameter;
import concreteSyntaxTree.interfaces.IParameter;
import concreteSyntaxTree.interfaces.IParameterNTS;
import scanner.interfaces.IToken;

import java.util.ArrayList;

public class ParameterNTS extends Production implements IParameterNTS {
    final IToken T_comma;
    final IParameter N_parameter;
    final IParameterNTS N_parameterNTS;

    public ParameterNTS(IToken T_comma, IParameter N_parameter, IParameterNTS N_parameterNTS) {
        this.T_comma = T_comma;
        this.N_parameter = N_parameter;
        this.N_parameterNTS = N_parameterNTS;
    }

    @Override public ArrayList<Parameter> toAbstractSyntax(ArrayList<Parameter> temp) {
        temp.add(N_parameter.toAbstractSyntax());
        return N_parameterNTS.toAbstractSyntax(temp);
    }

}
