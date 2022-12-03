package concreteSyntaxTree;

// paramList ::= LPAREN paramListNTS RPAREN

import abstractSyntaxTree.Parameter;
import concreteSyntaxTree.interfaces.IParameterList;
import concreteSyntaxTree.interfaces.IParameterListNTS;
import scanner.interfaces.IToken;

import java.util.ArrayList;

public class ParameterList extends Production implements IParameterList {

    final IToken T_lparen;

    final IParameterListNTS N_paramListNTS;

    final IToken T_rparen;

    public ParameterList(IToken T_lparen, IParameterListNTS N_paramListNTS, IToken T_rparen) {
        this.T_lparen = T_lparen;
        this.N_paramListNTS = N_paramListNTS;
        this.T_rparen = T_rparen;
    }

    @Override
    public ArrayList<Parameter> toAbstractSyntax() {
        return N_paramListNTS.toAbstractSyntax();
    }
}
