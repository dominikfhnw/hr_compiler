package scanner.operators;

import scanner.enums.Operators;
import scanner.enums.Terminals;

public class MultOpr extends Operator {

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
        } else if (multOperator == MultOperators.DIV_F) {
            return Operators.DIV_F;
        } else if (multOperator == MultOperators.DIV_T) {
            return Operators.DIV_T;
        } else if (multOperator == MultOperators.MOD_E) {
            return Operators.MOD_E;
        } else if (multOperator == MultOperators.MOD_F) {
            return Operators.MOD_F;
        } else if (multOperator == MultOperators.MOD_T) {
            return Operators.MOD_T;
        } else {
            return Operators.TIMES;
        }
    }
}
