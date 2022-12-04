package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.StoDecl;
import java.util.ArrayList;

public interface ICpsStoDecl extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
