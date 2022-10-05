import enums.Operators;
import enums.Terminals;

public class MultOpr extends Operator {
    public enum MultOperators {
        TIMES,
        DIVE,
        MODE
    }

    public MultOpr(MultOperators multOpr) {
        super(Terminals.MULTOPR, toOperator(multOpr));
    }

    private static Operators toOperator(MultOperators multOperator) {
        if (multOperator == MultOperators.DIVE) {
            return Operators.DIVE;
        } else if (multOperator == MultOperators.MODE) {
            return Operators.MODE;
        } else {
            return Operators.TIMES;
        }
    }
}
