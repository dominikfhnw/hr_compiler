package concreteSyntaxTree.interfaces.nts;

import concreteSyntaxTree.interfaces.IProduction;
import scanner.enums.ChangeModes;

public interface IChangeModeNTS extends IProduction {

    ChangeModes toAbstractSyntax();

}
