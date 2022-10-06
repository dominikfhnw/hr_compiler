package scanner.enums;

public enum Operators {

    AND,
    ASSIGN,
    CAND,
    COR,
    DIV_E,
    DIV_F,
    DIV_T,
    EQ,
    GE,
    GT,
    LE,
    LT,
    MINUS,
    MOD_E,
    MOD_F,
    MOD_T,
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
            return DIV_E;
        case "divF":
            return DIV_F;
        case "divT":
            return DIV_T;
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
        case "modE":
            return MOD_E;
        case "modF":
            return MOD_F;
        case "modT":
            return MOD_T;
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