package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.Parameter;
import java.util.ArrayList;

public interface IParameterList extends IProduction {

    public ArrayList<Parameter> toAbstractSyntax();

}
