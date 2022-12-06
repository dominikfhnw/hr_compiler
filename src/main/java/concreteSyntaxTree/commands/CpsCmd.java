package concreteSyntaxTree.commands;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.commands.ICmd;
import concreteSyntaxTree.interfaces.commands.ICpsCmd;
import concreteSyntaxTree.interfaces.nts.ICpsCmdNTS;
import java.util.ArrayList;

/*
<cpsCmd> ::= <cmd> {';' <cmd>}
{';' <cmd>} = cpsCmdNTS
*/

public class CpsCmd extends Production implements ICpsCmd {
    final ICmd N_cmd;
    final ICpsCmdNTS N_cpsCmdNTS;

    public CpsCmd(final ICmd N_cmd, final ICpsCmdNTS N_cpsCmdNTS) {
        this.N_cmd = N_cmd;
        this.N_cpsCmdNTS = N_cpsCmdNTS;
    }

    @Override
    public abstractSyntaxTree.commands.CpsCmd toAbstractSyntax() {
        ArrayList<abstractSyntaxTree.interfaces.ICmd> temp = new ArrayList<>();
        temp.add(N_cmd.toAbstractSyntax());
        return new abstractSyntaxTree.commands.CpsCmd(N_cpsCmdNTS.toAbstractSyntax(temp));
    }
}