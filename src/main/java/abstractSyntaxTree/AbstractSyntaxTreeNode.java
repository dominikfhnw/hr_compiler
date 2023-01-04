package abstractSyntaxTree;

import abstractSyntaxTree.interfaces.IAbstractSyntaxTreeNode;
import abstractSyntaxTree.parameterLists.TypeIdent;
import errors.AlreadyDeclaredError;
import errors.LRValueError;
import errors.NotDeclaredError;
import errors.TypeCheckError;
import virtualMachine.CodeArray;
import virtualMachine.interfaces.ICodeArray;

import java.util.HashMap;

public abstract class AbstractSyntaxTreeNode implements IAbstractSyntaxTreeNode {

    // Namespaces
    static HashMap<String, TypeIdent> globalVarNamespace = new HashMap<>();
    static HashMap<String, TypeIdent> localVarNamespace = new HashMap<>();

    // Adresses
    static HashMap<String, Integer> globalVarAdresses = new HashMap<>();
    static HashMap<String, Integer> globalRoutAdresses = new HashMap<>();

    // Code-array
    protected static int codeArrayPointer = 0;
    protected static ICodeArray codeArray = new CodeArray(1024);

}
