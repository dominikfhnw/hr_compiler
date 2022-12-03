package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.interfaces.IDecl;
import java.util.ArrayList;

public interface ICpsDecl extends IProduction {

        public ArrayList<IDecl> toAbstractSyntax();

}
