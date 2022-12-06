package abstractSyntaxTree;

import concreteSyntaxTree.interfaces.IProgram;
import errors.TypeCheckError;

// further methods must be implemented

public class AbstractSyntaxTree {

    AbstractSyntaxTreeNode root;

    public AbstractSyntaxTree(IProgram concreteSyntaxTreeRoot) {
        this.root = concreteSyntaxTreeRoot.toAbstractSyntax();
    }

    public void checkType() throws TypeCheckError {
        root.checkType();
    }

    @Override
    public String toString() {
        return root.toString("");
    }

}
