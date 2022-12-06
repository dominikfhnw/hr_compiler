package concreteSyntaxTree.interfaces.nts;

import concreteSyntaxTree.interfaces.IProduction;
import scanner.enums.MechModes;

public interface IMechModeNTS extends IProduction {

    MechModes toAbstractSyntax();

}
