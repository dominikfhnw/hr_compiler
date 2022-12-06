package concreteSyntaxTree.commands;

import concreteSyntaxTree.Production;
import concreteSyntaxTree.interfaces.ICmd;
import scanner.interfaces.IToken;

/* <cmd> ::= skip */

public class CmdSkip extends Production implements ICmd {

    final IToken T_skip;

    public CmdSkip(IToken T_skip) {
        this.T_skip = T_skip;
    }

    @Override
    public abstractSyntaxTree.interfaces.ICmd toAbstractSyntax() {
        return null;
    }
}
