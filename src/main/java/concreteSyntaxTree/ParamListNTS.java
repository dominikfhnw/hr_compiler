package concreteSyntaxTree;

// paramListNTS ::= param paramNTS

import abstractSyntaxTree.Parameter;
import concreteSyntaxTree.interfaces.IParameter;
import concreteSyntaxTree.interfaces.IParameterListNTS;
import concreteSyntaxTree.interfaces.IParameterNTS;

import java.util.ArrayList;

public class ParamListNTS extends Production implements IParameterListNTS {

    final IParameter N_param;

    final IParameterNTS N_paramNTS;

    public ParamListNTS(IParameter N_param, IParameterNTS N_paramNTS) {
        this.N_param = N_param;
        this.N_paramNTS = N_paramNTS;
    }

    @Override
    public ArrayList<Parameter> toAbstractSyntax() {
        ArrayList<Parameter> temp = new ArrayList<>();
        temp.add(N_param.toAbstractSyntax());
        return N_paramNTS.toAbstractSyntax(temp);
    }

}
