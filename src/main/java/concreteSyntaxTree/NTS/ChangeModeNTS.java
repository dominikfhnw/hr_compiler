package concreteSyntaxTree.NTS;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IChangeModeNTS;
import scanner.enums.ChangeModes;
import scanner.interfaces.IToken;
import scanner.modesAndTypes.ChangeMode;

// changeModeNTS ::= CHANGEMODE

public class ChangeModeNTS extends Production implements IChangeModeNTS {
    final IToken T_changeModeNTS;

    public ChangeModeNTS(IToken T_changeModeNTS) {
        this.T_changeModeNTS = T_changeModeNTS;
    }

    @Override
    public ChangeModes toAbstractSyntax() {
        return null; // needs to be fixed
        // return ((ChangeMode) T_changeModeNTS).getChangeMode();
    }
}