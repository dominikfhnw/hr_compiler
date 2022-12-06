package concreteSyntaxTree.nts;

/* mechModeNTS ::= mechmode */

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IMechModeNTS;
import scanner.enums.MechModes;
import scanner.interfaces.IToken;
import scanner.modesAndTypes.MechMode;

public class MechModeNTS extends Production implements IMechModeNTS {
    final IToken T_mechMode;

    public MechModeNTS(IToken T_mechMode) {
        this.T_mechMode = T_mechMode;
    }

    @Override
    public MechModes toAbstractSyntax() {
        return ((MechMode) T_mechMode).getMechMode();
    }
}