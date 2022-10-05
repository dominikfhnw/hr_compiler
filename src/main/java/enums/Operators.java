package enums;

public enum Operators {

    AND,
    ASSIGN,
    CAND,
    COR,
    DIVE,
    EQ,
    GE,
    GT,
    LE,
    LT,
    MINUS,
    MODE,
    NE,
    NOT,
    OR,
    PLUS,
    TIMES;

    public static Operators getOperator(String text) {

        switch (text) {
        case "/\\":
            return AND;
        case ":=":
            return ASSIGN;
        case "/\\?":
            return CAND;
        case "\\/?":
            return COR;
        case "divE":
            return DIVE;
        case "==":
            return EQ;
        case ">=":
            return GE;
        case ">":
            return GT;
        case "<=":
            return LE;
        case "<":
            return LT;
        case "-":
            return MINUS;
        case "modT":
            return MODE;
        case "!=":
            return NE;
        case "~":
            return NOT;
        case "+":
            return PLUS;
        case "*":
            return TIMES;
        default:
            return null;
        }
    }
}