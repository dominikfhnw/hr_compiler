package concreteSyntaxTree.interfaces;

import scanner.enums.MechModes;

public interface IMechModeNTS extends IProduction {

    public MechModes toAbstractSyntax();

}
