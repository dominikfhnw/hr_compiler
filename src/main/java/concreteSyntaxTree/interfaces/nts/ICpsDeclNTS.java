package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface ICpsDeclNTS extends IProduction {

    ArrayList<IDecl> toAbstractSyntax(ArrayList<IDecl> temp);

}
