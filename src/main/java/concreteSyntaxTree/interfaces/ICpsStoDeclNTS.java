package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.StoDecl;
import java.util.ArrayList;

public interface ICpsStoDeclNTS extends IProduction {

    ArrayList<StoDecl> toAbstractSyntax(ArrayList<StoDecl> temp);

}
