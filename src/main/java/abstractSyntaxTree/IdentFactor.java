package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IFactor;
import scanner.Ident;

public abstract class IdentFactor implements IFactor {

    Ident ident;
}
