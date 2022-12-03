package concreteSyntaxTree;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.IFunDecl;
import concreteSyntaxTree.interfaces.IFunDeclNTS;
import concreteSyntaxTree.interfaces.IParameterList;
import concreteSyntaxTree.interfaces.IStoDecl;
import scanner.Ident;
import scanner.interfaces.IToken;

// funDecl ::= FUN IDENT paramList RETURNS stoDecl funDeclNTS DO cpsCmd ENDFUN

public class FunDecl extends Production implements IFunDecl {

    final IToken T_fun;
    final IToken T_ident;
    final IParameterList N_parameterList;
    final IToken T_returns;
    final IStoDecl N_stoDecl;
    final IFunDeclNTS N_funDeclNTS;
    final IToken T_do;
    final ICpsCmd N_cpsCmd;
    final IToken T_endFun;

    public FunDecl(IToken T_fun, IToken T_ident, IParameterList N_parameterList, IToken T_returns, IStoDecl N_stoDecl, IFunDeclNTS N_funDeclNTS, IToken T_do, ICpsCmd N_cpsCmd, IToken T_endFun) {
        this.T_fun = T_fun;
        this.T_ident = T_ident;
        this.N_parameterList = N_parameterList;
        this.T_returns = T_returns;
        this.N_stoDecl = N_stoDecl;
        this.N_funDeclNTS = N_funDeclNTS;
        this.T_do = T_do;
        this.N_cpsCmd = N_cpsCmd;
        this.T_endFun = T_endFun;
    }

    @Override
    public IDecl toAbstractSyntax() {
        return null;
    }

    /*
    @Override
    public IDecl toAbstractSyntax() {
        return new FunDecl((Ident) T_ident, N_parameterList.toAbstractSyntax(), N_stoDecl.toAbstractSyntax(), N_funDeclNTS.toAbstractSyntax(), N_cpsCmd.toAbstractSyntax());
    }
    */

}
