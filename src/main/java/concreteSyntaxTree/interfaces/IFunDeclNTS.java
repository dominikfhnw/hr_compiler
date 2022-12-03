package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.StoDecl;

import java.util.ArrayList;

public interface IFunDeclNTS extends IProduction {

    public ArrayList<StoDecl> toAbstractSyntax();

}
