package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface IProcDeclNTS extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
