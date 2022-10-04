public class Base {
    private final Terminals terminal;
    private final Operators operator;

    private final Ident ident;

    private final Literal literal;

    Base (Terminals terminal) {
        this.terminal = terminal;
        this.operator = null;
        this.ident = null;
        this.literal = null;
    }

    Base (Operators operator) {
        this.terminal = null;
        this.operator = operator;
        this.ident = null;
        this.literal = null;
    }

    Base (Ident ident) {
        this.terminal = null;
        this.operator = null;
        this.ident = ident;
        this.literal = null;
    }

    Base (Literal literal) {
        this.terminal = null;
        this.operator = null;
        this.ident = null;
        this.literal = literal;
    }

    public Terminals getTerminal() {
        return terminal;
    }

    public Operators getOperator() {
        return operator;
    }

    public Ident getIdent() {
        return ident;
    }

    public Literal getLiteral() {
        return literal;
    }

    public boolean isTerminal() {
        return terminal != null;
    }

    public boolean isOperator() {
        return operator != null;
    }

    public boolean isIdent() {
        return ident != null;
    }

    public boolean isLiteral() {
        return literal != null;
    }

    @Override
    public String toString() {
        if (isTerminal()) {
            return terminal.toString();
        } else if (isOperator()) {
            return operator.toString();
        } else if (isIdent()) {
            return ident.toString();
        } else if (isLiteral()) {
            return literal.toString();
        } else {
            return "null";
        }
    }

    public enum Terminals {

        LITERAL,
        IDENT,
        PLUS,
        MINUS,
        TIMES,
        DIVIDE,
        LPAREN,
        RPAREN,
        SENTINEL,
        EOF,
        ERROR;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    public enum Operators {

        ASSIGN, EQ, NE, LT, LE, GT, GE, ADD, SUB, MUL, DIV, MOD, NOT, AND, OR;

        public static Operators getOperator(String text) {

            switch (text) {
            case "=":
                return ASSIGN;
            case "==":
                return EQ;
            case "!=":
                return NE;
            case "<":
                return LT;
            case "<=":
                return LE;
            case ">":
                return GT;
            case ">=":
                return GE;
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            case "%":
                return MOD;
            case "!":
                return NOT;
            case "&&":
                return AND;
            case "||":
                return OR;
            default:
                return null;
            }
        }
    }
}
