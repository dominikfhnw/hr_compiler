package concreteSyntaxTree.nts;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.commands.ICmd;
import concreteSyntaxTree.interfaces.nts.ICpsCmdNTS;
import scanner.interfaces.IToken;
import java.util.ArrayList;

/* cpsCmdNTS ::= {';' <cmd>} */

public class CpsCmdNTS extends Production implements ICpsCmdNTS {
    final IToken T_semicolon;
    final ICmd N_cmd;
    final ICpsCmdNTS N_cpsCmdNTS;

    public CpsCmdNTS(final IToken T_semicolon, final ICmd N_cmd, final ICpsCmdNTS N_cpsCmdNTS) {
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