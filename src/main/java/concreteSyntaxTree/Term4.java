package concreteSyntaxTree;
import concreteSyntaxTree.interfaces.*;

public class Term4 extends Production implements ITerm4 {

    private final IFactor N_factor;
    private final ITerm4NTS N_term4NTS;

    public Term4(IFactor N_factor, ITerm4NTS N_term4NTS) {
        this.N_factor = N_factor;
        this.N_term4NTS = N_term4NTS;
    }

    @Override
    public abstractSyntaxTree.interfaces.IExpression toAbstractSyntax() {
        return N_term4NTS.toAbstractSyntax(N_factor.toAbstractSyntax());
    }
}
