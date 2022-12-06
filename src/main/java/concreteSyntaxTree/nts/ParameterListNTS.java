package concreteSyntaxTree.nts;

import abstractSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.parameterLists.IParameter;
import concreteSyntaxTree.interfaces.nts.IParameterListNTS;
import concreteSyntaxTree.interfaces.nts.IParameterNTS;
import java.util.ArrayList;

/*
paramListNTS ::= [<param> {',' <param>}]
{',' <param>} = paramNTS
*/

public class ParameterListNTS extends Production implements IParameterListNTS {
    final IParameter N_parameter;
    final IParameterNTS N_parameterNTS;

    public ParameterListNTS(final IParameter N_parameter, final IParameterNTS N_parameterNTS) {
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