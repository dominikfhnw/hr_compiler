package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IFactor;
import concreteSyntaxTree.interfaces.IProduction;
import scanner.Ident;

public interface IFactorNTS extends IProduction {

    IFactor toAbstractSyntax(Ident ident);

}
