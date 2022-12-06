package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IFunDeclNTS extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
