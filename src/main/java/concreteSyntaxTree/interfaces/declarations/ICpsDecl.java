package concreteSyntaxTree.interfaces.declarations;

import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface ICpsDecl extends IProduction {

    ArrayList<IDecl> toAbstractSyntax();

}
