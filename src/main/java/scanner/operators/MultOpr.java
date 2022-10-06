package scanner.operators;

import scanner.enums.Operators;
import scanner.enums.Terminals;

public class MultOpr extends Operator {

    /**
     * TO BE DONE: Spec for different mod- and div-types (MOD_F, MOD_T, DIV_F, DIV_T)
     */

    public enum MultOperators {
        TIMES,
        DIV_E,
        DIV_F,
        DIV_T,
        MOD_E,
        MOD_F,
        MOD_T
    }

    public MultOpr(MultOperators multOpr) {
        super(Terminals.MULTOPR, toOperator(multOpr));
    }

    private static Operators toOperator(MultOperators multOperator) {
        if (multOperator == MultOperators.DIV_E) {
            return Operators.DIV_E;
        } else if (multOperator == MultOperators.MOD_E) {
            return Operators.MOD_E;
        } else {
            return Operators.TIMES;
        }
    }
}
