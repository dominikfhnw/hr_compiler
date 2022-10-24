package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IFactor;
import scanner.Ident;

public interface IFactorNTS extends IProduction {

    public IFactor toAbstractSyntax(Ident ident);

}
