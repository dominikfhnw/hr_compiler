package parser;

import abstractSyntaxTree.CpsCmd;
import abstractSyntaxTree.Parameter;
import concreteSyntaxTree.*;
import concreteSyntaxTree.interfaces.*;
import errors.*;
import scanner.Base;
import scanner.ITokenList;
import scanner.enums.Terminals;
import scanner.interfaces.IToken;

public class Parser implements IParser {

    private ITokenList tokenList;
    private Base currentToken;
    private Terminals currentTerminal;

    public Parser(ITokenList tokenList) {
        this.tokenList = tokenList;
        this.tokenList.reset();
        getNextToken();
    }

    private void getNextToken() {
        this.currentToken = (Base) tokenList.nextToken();
        this.currentTerminal = currentToken.getTerminal();
    }

    private IToken consume(Terminals expectedTerminal) throws GrammarError {
        if (currentTerminal == expectedTerminal) {
            IToken consumedTerminal = currentToken;
            if(currentTerminal != Terminals.SENTINEL){
                getNextToken();
            }
            return consumedTerminal;
        } else {
            throw new GrammarError("Expected " + expectedTerminal + " but found " + currentToken.getTerminal());
        }
    }

    // globalNTS ::= GLOBAL cpsDecl
    // globalNTS ::= ε
    private IGlobalNTS globalNTS() throws GrammarError {
        if (currentTerminal == Terminals.GLOBAL) {      // globalNTS ::= GLOBAL <cpsDecl>
            return new GlobalNTS(consume(Terminals.GLOBAL), cpsDecl());
        } else if (currentTerminal == Terminals.DO) {   // globalNTS ::= ε
            return new IEpsilon.GlobalNTS();
        } else {
            throw new GrammarError(Terminals.GLOBALNTS, currentTerminal);
        }
    }

    // typedIdent ::= IDENT COLON TYPE
    private ITypedIdent typedIdent() throws GrammarError {
        if (currentTerminal == Terminals.IDENT) { // typedIdent ::= IDENT COLON TYPE
            return new TypedIdent(consume(Terminals.IDENT), consume(Terminals.COLON), consume(Terminals.TYPE));
        } else {
            throw new GrammarError(Terminals.TYPEDIDENT, currentTerminal);
        }
    }

    // stoDecl ::= typedIdent
    // stoDecl ::= CHANGEMOD typedIdent
    private IStoDecl stoDecl() throws GrammarError {
        if (currentTerminal == Terminals.IDENT) {               // stoDecl ::= <typedIdent>
            return new StoDeclTypedIdent(typedIdent());
        } else if (currentTerminal == Terminals.CHANGEMODE) {   // stoDecl ::= CHANGEMOD <typedIdent>
            return new StoDeclChangeMode(consume(Terminals.CHANGEMODE), typedIdent());
        } else {
            throw new GrammarError(Terminals.STODECL, currentTerminal);
        }
    }

    // param ::= flowModeNTS mechModeNTS changeModNTS typedIdent
    private IParameter parameter() throws GrammarError {
        if (currentTerminal == Terminals.IDENT || currentTerminal == Terminals.FLOWMODE || currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.MECHMODE) { // param ::= <flowModeNTS> <mechModeNTS> <changeModNTS> <typedIdent>
            ITypedIdent N_typedIdent = typedIdent();
            return null;
            // return new Parameter(flowModeNTS(), mechModeNTS(), changeModeNTS(), typedIdent());
        } else {
            throw new GrammarError(Terminals.PARAM, currentTerminal);
        }
    }

    // paramNTS ::= COMMA param paramNTS
    // paramNTS ::= ε
    private IParameterNTS parameterNTS() throws GrammarError {
        if (currentTerminal == Terminals.COMMA) {           // paramNTS ::= COMMA <param> <paramNTS>
            return new ParameterNTS(consume(Terminals.COMMA), parameter(), parameterNTS());
        } else if (currentTerminal == Terminals.RPAREN) {   // paramNTS ::= ε
            return new IEpsilon.ParameterNTS();
        } else {
            throw new GrammarError(Terminals.PARAMNTS, currentTerminal);
        }
    }

    // paramListNTS ::= param paramNTS
    // paramListNTS ::= ε
    private IParameterListNTS parameterListNTS() throws GrammarError {
        if (currentTerminal == Terminals.IDENT || currentTerminal == Terminals.MECHMODE || currentTerminal == Terminals.CHANGEMODE) { // paramListNTS ::= <param> <paramNTS>
            return new ParamListNTS(parameter(), parameterNTS());
        } else if (currentTerminal == Terminals.RPAREN) { // paramListNTS ::= ε
            return new IEpsilon.ParameterListNTS();
        } else {
            throw new GrammarError(Terminals.PARAMLISTNTS, currentTerminal);
        }
    }

    // paramList ::= LPAREN paramListNTS RPAREN
    private IParameterList parameterList() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN) {      // paramList ::= LPAREN <paramListNTS> RPAREN
            return new ParameterList(consume(Terminals.LPAREN), parameterListNTS(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.PARAMLIST, currentTerminal);
        }
    }

    // funDeclNTS ::= LOCAL cpsStoNTS
    // funDeclNTS ::= ε
    private IFunDeclNTS funDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.LOCAL) { // funDeclNTS := LOCAL <cpsStoDecl>
            return new FunDeclNTS(consume(Terminals.LOCAL), cpsStoDecl());
        } else if (currentTerminal == Terminals.DO) { // funDeclNTS := ε
            return new IEpsilon.FunDeclNTS();
        } else {
            throw new GrammarError(Terminals.FUNDECLNTS, currentTerminal);
        }
    }

    // funDecl ::= FUN IDENT paramList RETURNS stoDecl funDeclNTS DO cpsCmd ENDFUN
    private IFunDecl funDecl() throws GrammarError {
        if (currentTerminal == Terminals.FUN) { // funDecl ::= FUN IDENT <paramList> RETURNS <stoDecl> <funDeclNTS> DO <cpsCmd> ENDFUN
            return new FunDecl(consume(Terminals.FUN), consume(Terminals.IDENT), parameterList(), consume(Terminals.RETURNS), stoDecl(), funDeclNTS(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDFUN));
        } else {
            throw new GrammarError(Terminals.FUNDECL, currentTerminal);
        }
    }

    // cmd ::= SKIP
    // cmd ::= expr BECOMES expr
    // cmd ::= IF expr THEN cpsCmd ifelseNTS ENDIF
    // cmd ::= WHILE expr DO cpsCmd ENDWHILE
    // cmd ::= CALL IDENT exprList
    // cmd ::= DEBUGIN expr
    // cmd ::= DEBUGOUT expr
    private ICmd cmd() throws GrammarError {
        if (currentTerminal == Terminals.SKIP) { // cmd ::= SKIP
            return new CmdSkip(consume(Terminals.SKIP));
        } /* else if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) { // cmd ::= <expr> BECOMES <expr>
            IExpr N_expr1 = expr();
            IToken T_becomes = consume(Terminals.BECOMES);
            IExpr N_expr2 = expr();
            return new CmdExpr(N_expr1, T_becomes, N_expr2);
        } else if (currentTerminal == Terminals.IF) { // cmd ::= IF <expr> THEN <cpsCmd> <ifelseNTS> ENDIF
            return new CmdIfThen(consume(Terminals.IF), expr(), consume(Terminals.THEN), cpsCmd(), ifElseNTS(), consume(Terminals.ENDIF));
        } else if (currentTerminal == Terminals.WHILE) { // cmd ::= WHILE <expr> DO <cpsCmd> ENDWHILE
            return new CmdWhileDo(consume(Terminals.WHILE), expr(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDWHILE));
        } else if (currentTerminal == Terminals.CALL) { // cmd ::= CALL IDENT <exprList>
            return new CmdCallIdentExprList(consume(Terminals.CALL), consume(Terminals.IDENT), exprList());
        } else if (currentTerminal == Terminals.DEBUGIN) { // cmd ::= DEBUGIN <expr>
            return new CmdDebugIn(consume(Terminals.DEBUGIN), expr());
        } else if (currentTerminal == Terminals.DEBUGOUT) { // cmd ::= DEBUGOUT <expr>
            return new CmdDebugOut(consume(Terminals.DEBUGOUT), expr());
        } */ else {
            throw new GrammarError(Terminals.CMD, currentTerminal);
        }
    }


    // cpsCmdNTS ::= SEMICOLON cmd cpsCmdNTS
    // cpsCmdNTS ::= ε
    private ICpsCmdNTS cpsCmdNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) { // cpsCmdNTS ::= SEMICOLON <cmd> <cpsCmdNTS>
            return new CpsCmdNTS(consume(Terminals.SEMICOLON), cmd(), cpsCmdNTS());
        } else if (currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM) { // cpsCmdNTS ::= ε
            return new IEpsilon.CpsCmdNTS();
        } else {
            throw new GrammarError(Terminals.CPSCMDNTS, currentTerminal);
        }
    }

    // cpsCmd ::= cmd cpsCmdNTS
    private ICpsCmd cpsCmd() throws GrammarError {
        if (currentTerminal == Terminals.DEBUGOUT || currentTerminal == Terminals.DEBUGIN || currentTerminal == Terminals.CALL
            || currentTerminal == Terminals.WHILE || currentTerminal == Terminals.IF || currentTerminal == Terminals.LPAREN
            || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL
            || currentTerminal == Terminals.SKIP) { // cpsCMD ::= <cmd> <cpsCmdNTS>
            // return new CpsCmd(cmd(), cpsCmdNTS());
            return null;
        } else {
            throw new GrammarError(Terminals.CPSCMD, currentTerminal);
        }
    }

    // cpsStoDeclNTS ::= SEMICOLON stoDecl cpsStoDeclNTS
    // cpsStoDeclNTS ::= ε
    private ICpsStoDeclNTS cpsStoDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) { // cpsStoDeclNTS ::= SEMICOLON <stoDecl> <cpsStoDeclNTS>
            return new CpsStoDeclNTS(consume(Terminals.SEMICOLON), stoDecl(), cpsStoDeclNTS());
        } else if (currentTerminal == Terminals.DO) { // cpsStoDeclNTS ::= ε
            return new IEpsilon.CpsStoDeclNTS();
        } else {
            throw new GrammarError(Terminals.CPSSTODECLNTS, currentTerminal);
        }
    }

    // cpsStoDecl ::= stoDecl cpsStoDeclNTS
    private ICpsStoDecl cpsStoDecl() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) { // cpsStoDecl ::= <stoDecl> <cpsStoDeclNTS>
            return new CpsStoDecl(stoDecl(), cpsStoDeclNTS());
        } else {
            throw new GrammarError(Terminals.CPSSTODECL, currentTerminal);
        }
    }

    // procDeclNTS ::= LOCAL cpsStoDecl
    // procDeclNTS ::= ε
    private IProcDeclNTS procDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.LOCAL) { // procDeclNTS ::= LOCAL <cpsStoDecl>
            return new ProcDeclNTS(consume(Terminals.LOCAL), cpsStoDecl());
        } else if (currentTerminal == Terminals.DO) { // procDeclNTS ::= ε
            return new IEpsilon.ProcDeclNTS();
        } else {
            throw new GrammarError(Terminals.PROCDECLNTS, currentTerminal);
        }
    }

    // procDecl ::= PROC IDENT paramList procDeclNTS DO cpsCmd ENDPROC
    private IProcDecl procDecl() throws GrammarError {
        if (currentTerminal == Terminals.PROC) { // procDecl ::= PROC IDENT <paramList> <procDeclNTS> DO <cpsCmd> ENDPROC
            return new ProcDecl(consume(Terminals.PROC), consume(Terminals.IDENT), parameterList(), procDeclNTS(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDPROC));
        } else {
            throw new GrammarError(Terminals.PROCDECL, currentTerminal);
        }
    }

    /*
    decl ::= stoDecl
    decl ::= funDecl
    decl ::= procDecl
     */
    private IDecl decl() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) { // decl ::= <stoDecl>
            return new DeclStoDecl(stoDecl());
        } else if (currentTerminal == Terminals.FUN) { // decl ::= <funDecl>
            return new DeclFunDecl(funDecl());
        } else if (currentTerminal == Terminals.PROC) { // decl ::= <procDecl>
            return new DeclProcDecl(procDecl());
        } else {
            throw new GrammarError(Terminals.DECL, currentTerminal);
        }
    }

    // cpsDeclNTS ::= SEMICOLON decl cpsDeclNTS
    // cpsDeclNTS ::= ε
    private ICpsDeclNTS cpsDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {   // cpsDeclNTS ::= SEMICOLON <decl> <cpsDeclNTS>
            return new CpsDeclNTS(consume(Terminals.SEMICOLON), decl(), cpsDeclNTS());
        } else if (currentTerminal == Terminals.DO) {      // cpsDeclNTS ::= ε
            return new IEpsilon.CpsDeclNTS();
        } else {
            throw new GrammarError(Terminals.CPSDECLNTS, currentTerminal);
        }
    }

    // cpsDecl ::= decl cpsDeclNTS
    private ICpsDecl cpsDecl() throws GrammarError {
        if (currentTerminal == Terminals.PROC || currentTerminal == Terminals.FUN ||
            currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) { // cpsDecl ::= <decl> <cpsDeclNTS>
            return new CpsDecl(decl(), cpsDeclNTS());
        } else {
            throw new GrammarError(Terminals.CPSDECL, currentTerminal);
        }
    }

    // program ::= PROGRAM IDENT globalNTS DO cpsCmd ENDPROGRAM
    private IProgram program() throws GrammarError {
        if (this.currentTerminal == Terminals.PROGRAM) {
            return new Program(consume(Terminals.PROGRAM), consume(Terminals.IDENT), globalNTS(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDPROGRAM));
        } else {
            throw new GrammarError(Terminals.PROGRAM, currentTerminal);
        }
    }

    /*
    private ITerm1 term1() throws GrammarError {
        if(currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET){
            System.out.println("term1 ::= <term2> <term1NTS>");
            ITerm2 N_term2 = term2();
            ITerm1NTS N_term1NTS = term1NTS(); // TO DO: implement term1NTS()
            return new Term1(N_term2, N_term1NTS);
        } else {
            throw new GrammarError(Terminals.TERM1, currentTerminal);
        }
    }

    private ITerm2 term2() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            System.out.println("term2 ::= <term3> <term2NTS>");
            ITerm3 N_term3 = term3();
            ITerm2NTS N_term2NTS = term2NTS(); // TO DO: implement term2NTS()
            return new Term2(N_term3, N_term2NTS);
        } else {
            throw new GrammarError(Terminals.TERM2, currentTerminal);
        }
    }

    private ITerm3 term3() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            System.out.println("term3 ::= <factor> <term3NTS>");
            IFactor N_factor = factor();
            ITerm3NTS N_term3NTS = term3NTS();
            return new Term3(N_factor, N_term3NTS);
        } else {
            throw new GrammarError(Terminals.TERM3, currentTerminal);
        }
    }
    private IExpression expression() throws GrammarError {
        if(currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET){
            System.out.println("expression ::= <term1> <expressionNTS>");
            ITerm1 N_term1 = term1();
            IExpressionNTS N_expressionNTS = expressionNTS();
            return new Expression(N_term1, N_expressionNTS);
        } else {
            throw new GrammarError(Terminals.EXPR, currentTerminal);
        }
    }

    */
}
