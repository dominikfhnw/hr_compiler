package scanner.operators;

import scanner.enums.Operators;
import scanner.enums.Terminals;

public class MultOpr extends Operator {

    public enum MultOperators {
        TIMES,
        DIV_T,
        MOD_T
    }

    public MultOpr(MultOperators multOpr) {
        super(Terminals.MULTOPR, toOperator(multOpr));
    }

    private static Operators toOperator(MultOperators multOperator) {
        if (multOperator == MultOperators.DIV_T) {
            return Operators.DIV_T;
        } else if (multOperator == MultOperators.MOD_T) {
            return Operators.MOD_T;
        } else {
            return Operators.TIMES;
        }
    }
}
