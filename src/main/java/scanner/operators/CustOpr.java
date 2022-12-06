package scanner.operators;

import scanner.enums.Operators;
import scanner.enums.Terminals;

// must be implemented

public class CustOpr extends Operator {

    public CustOpr(Operators operator) {
        super(Terminals.CUSTOPR, operator);
    }

}
