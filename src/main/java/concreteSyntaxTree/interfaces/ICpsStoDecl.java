package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.declarations.StoDecl;
import java.util.ArrayList;

public interface ICpsStoDecl extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
