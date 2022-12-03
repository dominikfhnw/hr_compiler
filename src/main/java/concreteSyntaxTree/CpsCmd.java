package concreteSyntaxTree;

import concreteSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.ICpsCmd;
import concreteSyntaxTree.interfaces.ICpsCmdNTS;
import java.util.ArrayList;

// cpsCmd ::= cmd cpsCmdNTS

public class CpsCmd extends Production implements ICpsCmd {
    final ICmd N_cmd;
    final ICpsCmdNTS N_cpsCmdNTS;

    public CpsCmd(ICmd N_cmd, ICpsCmdNTS N_cpsCmdNTS) {
        this.N_cmd = N_cmd;
        this.N_cpsCmdNTS = N_cpsCmdNTS;
    }

    @Override
    public abstractSyntaxTree.CpsCmd toAbstractSyntax() {
        ArrayList<abstractSyntaxTree.interfaces.ICmd> temp = new ArrayList<>();
        temp.add(N_cmd.toAbstractSyntax());
        return new abstractSyntaxTree.CpsCmd(N_cpsCmdNTS.toAbstractSyntax(temp));
    }
}