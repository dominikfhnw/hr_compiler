public class IToken {

    static class Base {
        private final Terminals terminal;

        Base (Terminals terminal) {
            this.terminal = terminal;
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

        static class Operator extends Base {

            private final Operators operator;

            public Operator(Terminals terminal, Operators operator){
                super(terminal);
                this.operator = operator;
            }

            public Operators getOperator(){
                return operator;
            }

        }

        static class AddOpr extends Operator {

            public enum AddOperators {
                PLUS,
                MINUS
            }

            AddOpr (Terminals terminal, AddOperators addOpr) {
                super(terminal, toOperator(addOpr));
            }

            private static Operators toOperator(AddOperators addOperator){
                if(addOperator == AddOperators.PLUS){
                    return Operators.PLUS;
                } else {
                    return Operators.MINUS;
                }
            }
        }

        static class BoolOpr extends Operator {

            public enum BoolOperators{
                AND,
                OR,
                CAND,
                COR
            }

            public BoolOpr(Terminals terminal, BoolOperators boolOpr){
                super(terminal, toOperator(boolOpr));
            }

            private static Operators toOperator(BoolOperators boolOperator){
                if (boolOperator == BoolOperators.AND) {
                    return Operators.AND;
                } else if (boolOperator == BoolOperators.OR) {
                    return Operators.OR;
                } else if (boolOperator == BoolOperators.CAND) {
                    return Operators.CAND;
                } else {
                    return Operators.COR;
                }
            }
        }

        static class MultOpr extends Operator {

            public enum MultOperators{
                TIMES,
                DIVE,
                MODE
            }

            public MultOpr(Terminals terminal, MultOperators multOpr){
                super(terminal, toOperator(multOpr));
            }

            private static Operators toOperator(MultOperators multOperator){
                if (multOperator == MultOperators.DIVE) {
                    return Operators.DIVE;
                } else if (multOperator == MultOperators.MODE) {
                    return Operators.MODE;
                } else {
                    return Operators.TIMES;
                }
            }
        }

        static class RelOpr extends Operator {

            public enum RelOperators {
                EQ,
                GE,
                GT,
                LT,
                NE,
                LE
            }

            RelOpr (Terminals terminal, RelOperators relOpr) {
                super(terminal, toOperator(relOpr));
            }

            private static Operators toOperator(RelOperators relOperator){
                if (relOperator == RelOperators.EQ) {
                    return Operators.EQ;
                } else if (relOperator == RelOperators.GE) {
                    return Operators.GE;
                } else if (relOperator == RelOperators.GT) {
                    return Operators.GT;
                } else if (relOperator == RelOperators.LE) {
                    return Operators.LE;
                } else if (relOperator == RelOperators.LT) {
                    return Operators.LT;
                } else {
                    return Operators.NE;
                }
            }
        }

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

        public static class Type extends Base {

            public enum Types {
                BOOL,
                INT32,
                INT64,
                INT1024
            }

            private final Types type;
            public Type(Terminals terminal, Types type) {
                super(terminal);
                this.type = type;
            }

            public Types getType() {
                return type;
            }
        }

        static class Sentinel extends Base {
            public Sentinel(Terminals terminal) {
                super(terminal);
            }
        }
    }
}