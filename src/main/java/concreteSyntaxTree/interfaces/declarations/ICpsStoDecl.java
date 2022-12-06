package concreteSyntaxTree.interfaces.declarations;

import abstractSyntaxTree.declarations.StoDecl;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface ICpsStoDecl extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
