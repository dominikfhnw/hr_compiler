public class IToken {

    static class Base {
        private final Terminals terminal;
        private final Operators operator;

        //private final Ident ident;

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

        @Override
        public String toString() {
            if (isTerminal()) {
                return terminal.toString();
            } else if (isOperator()){
                return operator.toString();
            }
            return "null";
        }

        static class Ident extends Base {
            private final String ident;
            Ident (String ident, Terminals terminal) {
                super(terminal);
                this.ident = ident;
            }
            public String getIdent() {
                return ident;
            }

        }

        static class Literal extends Base {

            private final int value;

            Literal (int value, Terminals terminal) {
                super(terminal);
                this.value = value;
            }

            public int getValue(){
                return value;
            }
        }

        static class AddOpr extends Base {

            private final Operators operator;

            AddOpr (Operators operator) {
                super(Operators.PLUS);
                this.operator = operator;
            }
        }

        static class RelOpr extends Base {

            private final Operators operator;

            RelOpr (Operators operator) {
                super(Operators.EQ);
                this.operator = operator;
            }
        }

        static class ChangeMode extends Base {

            public enum ChangeModes {
                VAR,
                CONST
            }

            private final ChangeModes changemode;

            public ChangeMode(Terminals terminal, ChangeModes changemode) {
                super(terminal);
                this.changemode = changemode;
            }

            public ChangeModes getChangeMode() {
                return changemode;
            }
        }

        static class FlowMode extends Base {

            public enum FlowModes {
                IN,
                INOUT,
                OUT
            }

            private final FlowModes flowmode;

            public FlowMode(Terminals terminal, FlowModes flowmode) {
                super(terminal);
                this.flowmode = flowmode;
            }

            public FlowModes getFlowMode() {
                return flowmode;
            }
        }

        public static class MechMode extends Base {

            public enum MechModes {
                COPY,
                REF
            }

            private final MechModes mechmode;

            public MechMode(Terminals terminal, MechModes mechmode) {
                super(terminal);
                this.mechmode = mechmode;
            }

            public MechModes getMechMode() {
                return mechmode;
            }
        }
        public Terminals getTerminal() {
            return terminal;
        }

        public boolean isTerminal() {
            return terminal != null;
        }

        public boolean isOperator() {
            return operator != null;
        }

        public enum Terminals {

            IDENT("IDENT"),
            LITERAL("LITERAL"),
            TYPE("TYPE"),

            // Operators
            ADDOPR("ADDOPR"),
            BOOLOPR("BOOLOPR"),
            MULTOPR("MULTOPR"),
            RELOPR("RELOPR"),


            // Symbols
            BECOMES(":="),
            COLON(":"),
            COMMA(","),
            LPAREN("("),
            RPAREN(")"),
            SEMICOLON(";"),

            // Modes
            CHANGEMODE("CHANGEMODE"),
            FLOWMODE("FLOWMODE"),
            MECHMODE("MECHMODE"),

            // Keywords
            CALL("CALL"),
            CASE("CASE"),
            DEBUGIN("DEBUGIN"),
            DEBUGOUT("DEBUGOUT"),
            DEFAULT("DEFAULT"),
            DO("DO"),
            ENDFUN("ENDFUN"),
            ENDIF("ENDIF"),
            ENDPROC("ENDPROC"),
            ENDPROGRAM("ENDPROGRAM"),
            ENDSWITCH("ENDSWITCH"),
            ENDWHILE("ENDWHILE"),
            ELSE("ELSE"),
            ELSEIF("ELSEIF"),
            FUN("FUN"),
            GLOBAL("GLOBAL"),
            IF("IF"),
            INIT("INIT"),
            LOCAL("LOCAL"),
            NOT("NOT"),
            PROC("PROC"),
            PROGRAM("PROGRAM"),
            RETURNS("RETURNS"),
            SENTINEL("SENTINEL"),
            SKIP("SKIP"),
            SWITCH("SWITCH"),
            THEN("THEN"),
            WHILE("WHILE");

            private final String name;

            Terminals(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return name().toLowerCase();
            }
        }

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
    }
}