package concreteSyntaxTree.NTS;

import abstractSyntaxTree.Parameter;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IParameter;
import concreteSyntaxTree.interfaces.IParameterListNTS;
import concreteSyntaxTree.interfaces.IParameterNTS;
import java.util.ArrayList;

// paramListNTS ::= param paramNTS

public class ParameterListNTS extends Production implements IParameterListNTS {
    final IParameter N_parameter;
    final IParameterNTS N_parameterNTS;

    public ParameterListNTS(IParameter N_parameter, IParameterNTS N_parameterNTS) {
        this.N_parameter = N_parameter;
        this.N_parameterNTS = N_parameterNTS;
    }

    @Override

    public ArrayList<Parameter> toAbstractSyntax() {
        ArrayList<Parameter> temp = new ArrayList<>();
        temp.add(N_parameter.toAbstractSyntax());
        return N_parameterNTS.toAbstractSyntax(temp);
    }
}