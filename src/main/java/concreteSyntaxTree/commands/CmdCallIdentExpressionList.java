package concreteSyntaxTree.commands;

import abstractSyntaxTree.commands.ProcCallCmd;
import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.IExpressionList;
import scanner.Ident;
import scanner.interfaces.IToken;

// cmd ::= CALL IDENT exprList

public class CmdCallIdentExpressionList extends Production implements ICmd {
    final IToken T_call;
    final IToken T_ident;
    final IExpressionList N_expressionList;

    public CmdCallIdentExpressionList(IToken T_call, IToken T_ident, IExpressionList N_expressionList) {
        this.T_call = T_call;
        this.T_ident = T_ident;
        this.N_expressionList = N_expressionList;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return new ProcCallCmd((Ident) T_ident, N_expressionList.toAbstractSyntax());
    }
}