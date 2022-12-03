package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IDecl;

import java.util.ArrayList;

public interface IGlobalNTS extends IProduction {

    public ArrayList<IDecl> toAbstractSyntax();

}