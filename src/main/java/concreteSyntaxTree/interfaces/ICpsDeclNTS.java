package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IDecl;
import java.util.ArrayList;

public interface ICpsDeclNTS extends IProduction {

    ArrayList<IDecl> toAbstractSyntax(ArrayList<IDecl> temp);

}
