package scanner.operators;

import scanner.enums.Operators;
import scanner.enums.Terminals;

public class BoolOpr extends Operator {
    public enum BoolOperators {
        AND,
        OR,
        CAND,
        COR
    }

    public BoolOpr(BoolOperators boolOpr) {
        super(Terminals.BOOLOPR, toOperator(boolOpr));
    }

    private static Operators toOperator(BoolOperators boolOperator) {
        if (boolOperator == BoolOperators.AND) {
            return Operators.AND;
        } else if (boolOperator == BoolOperators.OR) {
            return Operators.OR;
        } else if (boolOperator == BoolOperators.CAND) {
            return Operators.CAND;
        } else {
            return Operators.COR;
        }
    }
}
