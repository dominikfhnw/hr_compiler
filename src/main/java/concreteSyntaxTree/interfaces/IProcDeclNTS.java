package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.StoDecl;
import java.util.ArrayList;

public interface IProcDeclNTS extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
