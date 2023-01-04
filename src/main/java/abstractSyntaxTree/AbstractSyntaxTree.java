package abstractSyntaxTree;

import concreteSyntaxTree.interfaces.IProgram;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import virtualMachine.interfaces.ICodeArray;
import virtualMachine.interfaces.ICodeArray.CodeTooSmallError;

import java.util.HashMap;

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

    public ICodeArray getCodeArray() throws CodeTooSmallError {
        root.addInstructionToCodeArray(new HashMap<String, Integer>(), false);
        AbstractSyntaxTreeNode.codeArray.resize();
        return AbstractSyntaxTreeNode.codeArray;
    }
    @Override
    public String toString() {
        return root.toString("");
    }

}
