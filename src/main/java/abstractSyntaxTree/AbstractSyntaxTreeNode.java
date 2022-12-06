package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IAbstractSyntaxTreeNode;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;

// methods must be implemented

public class AbstractSyntaxTreeNode implements IAbstractSyntaxTreeNode {

    @Override
    public void checkScope() throws NotDeclaredError, LRValueError {

    }

    @Override
    public void checkType() throws TypeCheckError {
    }

    @Override
    public String toString(String indent) {
        return null;
    }

}
