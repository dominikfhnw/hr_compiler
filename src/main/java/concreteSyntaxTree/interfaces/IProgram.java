package concreteSyntaxTree.interfaces;
import abstractSyntaxTree.Program;

public interface IProgram extends IProduction {

    Program toAbstractSyntax();

}
