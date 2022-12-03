package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.ICpsCmdNTS;
import scanner.interfaces.IToken;

import java.util.ArrayList;

// cpsCmdNTS ::= SEMICOLON cmd cpsCmdNTS

public class CpsCmdNTS extends Production implements ICpsCmdNTS {
    protected final IToken T_semicolon;
    protected final ICmd N_cmd;
    protected final ICpsCmdNTS N_cpsCmdNTS;

    public CpsCmdNTS(IToken T_semicolon, ICmd N_cmd, ICpsCmdNTS N_cpsCmdNTS) {
        this.T_semicolon = T_semicolon;
        this.N_cmd = N_cmd;
        this.N_cpsCmdNTS = N_cpsCmdNTS;
    }

    @Override
    public ArrayList<abstractSyntaxTree.interfaces.ICmd> toAbstractSyntax(
        ArrayList<abstractSyntaxTree.interfaces.ICmd> temp) {
        temp.add(N_cmd.toAbstractSyntax());
        return N_cpsCmdNTS.toAbstractSyntax(temp);
    }
}