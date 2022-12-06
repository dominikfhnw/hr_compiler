package concreteSyntaxTree.parameterLists;

import abstractSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.parameterLists.IParameterList;
import concreteSyntaxTree.interfaces.nts.IParameterListNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

/*
<paramList> ::= '(' [<param> {',' <param>}] ')'
[<param> {',' <param>}] = parameterListNTS
*/

public class ParameterList extends Production implements IParameterList {

    final IToken T_lparen;

    final IParameterListNTS N_parameterListNTS;

    final IToken T_rparen;

    public ParameterList(final IToken T_lparen, final IParameterListNTS N_parameterListNTS, final IToken T_rparen) {
        this.T_lparen = T_lparen;
        this.N_parameterListNTS = N_parameterListNTS;
        this.T_rparen = T_rparen;
    }

    @Override
    public ArrayList<Parameter> toAbstractSyntax() {
        return N_parameterListNTS.toAbstractSyntax();
    }
}
