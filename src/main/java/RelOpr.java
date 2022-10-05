import enums.Operators;
import enums.Terminals;

public class RelOpr extends Operator {
    public enum RelOperators {
        EQ,
        GE,
        GT,
        LT,
        NE,
        LE
    }

    RelOpr(RelOperators relOpr) {
        super(Terminals.RELOPR, toOperator(relOpr));
    }

    private static Operators toOperator(RelOperators relOperator) {
        if (relOperator == RelOperators.EQ) {
            return Operators.EQ;
        } else if (relOperator == RelOperators.GE) {
            return Operators.GE;
        } else if (relOperator == RelOperators.GT) {
            return Operators.GT;
        } else if (relOperator == RelOperators.LE) {
            return Operators.LE;
        } else if (relOperator == RelOperators.LT) {
            return Operators.LT;
        } else {
            return Operators.NE;
        }
    }
}
