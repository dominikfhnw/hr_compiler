package concreteSyntaxTree.parameterLists;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.nts.IChangeModeNTS;
import concreteSyntaxTree.interfaces.nts.IMechModeNTS;
import concreteSyntaxTree.interfaces.parameterLists.IParameter;
import concreteSyntaxTree.interfaces.parameterLists.ITypedIdent;

/*
<param> ::= [<mechModeNTS>] [<changeModeNTS>] <typedIdent>
mechModeNTS ::= mechmode
changeModeNTS ::= changemode
*/

public class Parameter extends Production implements IParameter {
    final IMechModeNTS N_mechModeNTS;
    final IChangeModeNTS N_changeModeNTS;
    final ITypedIdent N_typedIdent;

    public Parameter(final IMechModeNTS N_mechModeNTS, final IChangeModeNTS N_changeModeNTS, final ITypedIdent N_typedIdent) {
        this.N_changeModeNTS = N_changeModeNTS;
        this.N_mechModeNTS = N_mechModeNTS;
        this.N_typedIdent = N_typedIdent;
    }

    @Override
    public abstractSyntaxTree.parameterLists.Parameter toAbstractSyntax() {
        return new abstractSyntaxTree.parameterLists.Parameter(N_mechModeNTS.toAbstractSyntax(), N_changeModeNTS.toAbstractSyntax(), N_typedIdent.toAbstractSyntax());
    }
}