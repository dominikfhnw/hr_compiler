public class IToken {

    static class Base {
        private final Terminals terminal;
        private final Operators operator;

        // private final Ident ident;

        // private final Literal literal;

        Base (Terminals terminal) {
            this.terminal = terminal;
            this.operator = null;
            // this.ident = null;
            // this.literal = null;
        }

        Base (Operators operator) {
            this.terminal = null;
            this.operator = operator;
            // this.ident = null;
            // this.literal = null;
        }

        public String StringtoString() {
            return terminal.toString();
        }

        static class Ident extends Base {
            private final String ident;

            Ident (String ident) {
                super(Terminals.IDENT);
                this.ident = ident;
            }

        }

        static class Literal extends Base {

            private final int value;

            Literal (int value) {
                super(Terminals.LITERAL);
                this.value = value;
            }
        }

        public class AddOpr extends Base {

            private final Operators opr;

            AddOpr (Operators opr) {
                super(Operators.ADD);
                this.opr = opr;
            }
        }

        public Terminals getTerminal() {
            return terminal;
        }

        public boolean isTerminal() {
            return terminal != null;
        }

        @Override
        public String toString() {
            if (isTerminal()) {
                return terminal.toString();
            }
            return "null";
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
}