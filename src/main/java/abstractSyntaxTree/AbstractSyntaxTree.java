package abstractSyntaxTree;

import concreteSyntaxTree.interfaces.IProgram;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;

public class AbstractSyntaxTree {

    AbstractSyntaxTreeNode root;

    public AbstractSyntaxTree(IProgram concreteSyntaxTreeRoot) {
        this.root = concreteSyntaxTreeRoot.toAbstractSyntax();
    }

    public void checkType() throws TypeCheckError {
        root.checkType();
    }

    public void checkScope() throws NotDeclaredError, LRValueError, AlreadyDeclaredError {
        root.storeNamespace(null);
        root.checkScope();
    }
    @Override
    public String toString() {
        return root.toString("");
    }

}
