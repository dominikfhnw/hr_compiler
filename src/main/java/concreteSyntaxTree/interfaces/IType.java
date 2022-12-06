package concreteSyntaxTree.interfaces;

import scanner.modesAndTypes.Type;

public interface IType extends IProduction {

    Type toAbstractSyntax();

}
