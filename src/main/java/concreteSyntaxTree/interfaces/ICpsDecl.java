package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.IDecl;
import java.util.ArrayList;

public interface ICpsDecl extends IProduction {

    ArrayList<IDecl> toAbstractSyntax();

}
