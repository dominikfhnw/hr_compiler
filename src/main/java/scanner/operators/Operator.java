package scanner.operators;

import scanner.enums.Operators;
import scanner.enums.Terminals;
import scanner.Base;

public class Operator extends Base {
    private final Operators operator;

    public Operator(Terminals terminal, Operators operator) {
        super(terminal);
        this.operator = operator;
    }

    public Operators getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + "," + getOperator().toString() + ")";
    }
}
