package concreteSyntaxTree.nts;

// mechModeNTS ::= MECHMODE

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.IMechModeNTS;
import scanner.enums.MechModes;
import scanner.interfaces.IToken;

public class MechModeNTS extends Production implements IMechModeNTS {
    final IToken T_mechMode;

    public MechModeNTS(IToken T_mechMode) {
        this.T_mechMode = T_mechMode;
    }

    @Override
    public MechModes toAbstractSyntax() {
        return null; // needs to be fixed
        // return ((MechMode) T_mechMode).getMechMode();
    }
}