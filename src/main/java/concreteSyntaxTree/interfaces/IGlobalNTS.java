package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IDecl;
import java.util.ArrayList;

public interface IGlobalNTS extends IProduction {

    ArrayList<IDecl> toAbstractSyntax();

}