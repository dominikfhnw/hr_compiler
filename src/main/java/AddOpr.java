import enums.Operators;
import enums.Terminals;

public class AddOpr extends Operator {

    public enum AddOperators {
        PLUS,
        MINUS
    }

    AddOpr(AddOperators addOpr) {
        super(Terminals.ADDOPR, toOperator(addOpr));
    }

    private static Operators toOperator(AddOperators addOperator) {
        if (addOperator == AddOperators.PLUS) {
            return Operators.PLUS;
        } else {
            return Operators.MINUS;
        }
    }
}
