package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.StoDecl;
import java.util.ArrayList;

public interface IFunDeclNTS extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax();

}
