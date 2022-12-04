package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.declarations.StoDecl;
import java.util.ArrayList;

public interface IProcDeclNTS extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
