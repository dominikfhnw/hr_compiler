package parser;

import abstractSyntaxTree.AbstractSyntaxTree;
import concreteSyntaxTree.*;
import concreteSyntaxTree.interfaces.commands.ICmd;
import concreteSyntaxTree.interfaces.commands.ICpsCmd;
import concreteSyntaxTree.interfaces.declarations.ICpsDecl;
import concreteSyntaxTree.interfaces.declarations.ICpsStoDecl;
import concreteSyntaxTree.interfaces.declarations.IDecl;
import concreteSyntaxTree.interfaces.declarations.IFunDecl;
import concreteSyntaxTree.interfaces.declarations.IProcDecl;
import concreteSyntaxTree.interfaces.declarations.IStoDecl;
import concreteSyntaxTree.interfaces.expressions.IExpression;
import concreteSyntaxTree.interfaces.expressions.IExpressionList;
import concreteSyntaxTree.interfaces.expressions.IFactor;
import concreteSyntaxTree.interfaces.expressions.ITerm1;
import concreteSyntaxTree.interfaces.expressions.ITerm2;
import concreteSyntaxTree.interfaces.expressions.ITerm3;
import concreteSyntaxTree.interfaces.expressions.ITerm4;
import concreteSyntaxTree.interfaces.nts.IChangeModeNTS;
import concreteSyntaxTree.interfaces.nts.ICpsCmdNTS;
import concreteSyntaxTree.interfaces.nts.ICpsDeclNTS;
import concreteSyntaxTree.interfaces.nts.ICpsStoDeclNTS;
import concreteSyntaxTree.interfaces.nts.IExpressionListLParenNTS;
import concreteSyntaxTree.interfaces.nts.IExpressionListNTS;
import concreteSyntaxTree.interfaces.nts.IExpressionNTS;
import concreteSyntaxTree.interfaces.nts.IFactorNTS;
import concreteSyntaxTree.interfaces.nts.IFunDeclNTS;
import concreteSyntaxTree.interfaces.nts.IIfElseNTS;
import concreteSyntaxTree.interfaces.nts.IMechModeNTS;
import concreteSyntaxTree.interfaces.nts.IParameterListNTS;
import concreteSyntaxTree.interfaces.nts.IParameterNTS;
import concreteSyntaxTree.interfaces.nts.IProcDeclNTS;
import concreteSyntaxTree.interfaces.nts.ITerm1NTS;
import concreteSyntaxTree.interfaces.nts.ITerm2NTS;
import concreteSyntaxTree.interfaces.nts.ITerm3NTS;
import concreteSyntaxTree.interfaces.nts.ITerm4NTS;
import concreteSyntaxTree.interfaces.operators.IAddOpr;
import concreteSyntaxTree.interfaces.operators.IMonOpr;
import concreteSyntaxTree.interfaces.operators.IMultOpr;
import concreteSyntaxTree.interfaces.operators.IRelOpr;
import concreteSyntaxTree.interfaces.parameterLists.IParameter;
import concreteSyntaxTree.interfaces.parameterLists.IParameterList;
import concreteSyntaxTree.interfaces.parameterLists.ITypedIdent;
import concreteSyntaxTree.nts.ChangeModeNTS;
import concreteSyntaxTree.nts.CpsCmdNTS;
import concreteSyntaxTree.nts.CpsDeclNTS;
import concreteSyntaxTree.nts.CpsStoDeclNTS;
import concreteSyntaxTree.nts.ExpressionListLParenNTS;
import concreteSyntaxTree.nts.ExpressionListNTS;
import concreteSyntaxTree.nts.ExpressionNTS;
import concreteSyntaxTree.nts.FactorNTSExpressionList;
import concreteSyntaxTree.nts.FactorNTSInit;
import concreteSyntaxTree.nts.FunDeclNTS;
import concreteSyntaxTree.nts.IfElseNTS;
import concreteSyntaxTree.nts.MechModeNTS;
import concreteSyntaxTree.nts.ParameterListNTS;
import concreteSyntaxTree.nts.ParameterNTS;
import concreteSyntaxTree.nts.ProcDeclNTS;
import concreteSyntaxTree.nts.Term1NTS;
import concreteSyntaxTree.nts.Term2NTS;
import concreteSyntaxTree.nts.Term3NTS;
import concreteSyntaxTree.nts.Term4NTS;
import concreteSyntaxTree.commands.CmdCallIdentExpressionList;
import concreteSyntaxTree.commands.CmdDebugIn;
import concreteSyntaxTree.commands.CmdDebugOut;
import concreteSyntaxTree.commands.CmdExpression;
import concreteSyntaxTree.commands.CmdIfThen;
import concreteSyntaxTree.commands.CmdSkip;
import concreteSyntaxTree.commands.CmdWhileDo;
import concreteSyntaxTree.commands.CpsCmd;
import concreteSyntaxTree.declarations.CpsDecl;
import concreteSyntaxTree.declarations.CpsStoDecl;
import concreteSyntaxTree.declarations.DeclFunDecl;
import concreteSyntaxTree.declarations.DeclProcDecl;
import concreteSyntaxTree.declarations.DeclStoDecl;
import concreteSyntaxTree.declarations.FunDecl;
import concreteSyntaxTree.declarations.ProcDecl;
import concreteSyntaxTree.declarations.StoDeclChangeMode;
import concreteSyntaxTree.declarations.StoDeclTypedIdent;
import concreteSyntaxTree.expressions.Expression;
import concreteSyntaxTree.expressions.ExpressionList;
import concreteSyntaxTree.expressions.FactorIdent;
import concreteSyntaxTree.expressions.FactorLParen;
import concreteSyntaxTree.expressions.FactorLiteral;
import concreteSyntaxTree.expressions.FactorMonOpr;
import concreteSyntaxTree.expressions.Term1;
import concreteSyntaxTree.expressions.Term2;
import concreteSyntaxTree.expressions.Term3;
import concreteSyntaxTree.expressions.Term4;
import concreteSyntaxTree.interfaces.*;
import concreteSyntaxTree.operators.AddOpr;
import concreteSyntaxTree.operators.MonOprAddOpr;
import concreteSyntaxTree.operators.MonOprNot;
import concreteSyntaxTree.operators.MultOpr;
import concreteSyntaxTree.operators.RelOpr;
import concreteSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.parameterLists.ParameterList;
import concreteSyntaxTree.parameterLists.TypedIdent;
import errors.*;
import scanner.Base;
import scanner.ITokenList;
import scanner.enums.Terminals;
import scanner.interfaces.IToken;

public class Parser {

    private final ITokenList tokenList;
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

    public AbstractSyntaxTree parse() throws GrammarError {
        IProgram program = program();
        consume(Terminals.SENTINEL);
        return new AbstractSyntaxTree(program);
    }

    /* <type> ::= bool | int32 */
    private IType type() throws GrammarError {
        if (this.currentTerminal == Terminals.TYPE) {
            return new Type(consume(Terminals.TYPE));
        } else {
            throw new GrammarError(Terminals.TYPE, currentTerminal);
        }
    }

    /* <program> ::= program <ident> do <cpsCmd> endprogram */
    private IProgram program() throws GrammarError {
        if (this.currentTerminal == Terminals.PROGRAM) {
            return new Program(consume(Terminals.PROGRAM), consume(Terminals.IDENT), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDPROGRAM));
        } else {
            throw new GrammarError(Terminals.PROGRAM, currentTerminal);
        }
    }

    /* mechModeNTS ::= mechmode | ε */
    private IMechModeNTS mechModeNTS() throws GrammarError {
        if (currentTerminal == Terminals.MECHMODE) {
            // mechModeNTS ::= mechmode
            return new MechModeNTS(consume(Terminals.MECHMODE));
        } else if (currentTerminal == Terminals.IDENT || currentTerminal == Terminals.CHANGEMODE) {
            // mechModeNTS ::= ε
            return new IEpsilon.MechModeNTS();
        } else {
            throw new GrammarError(Terminals.MECHMODENTS, currentTerminal);
        }
    }

    /* changeModeNTS ::= changemode | ε */
    private IChangeModeNTS changeModeNTS() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE) {
            // changeModeNTS ::= changemode
            return new ChangeModeNTS(consume(Terminals.CHANGEMODE));
        } else if (currentTerminal == Terminals.IDENT) {
            // changeModeNTS ::= ε
            return new IEpsilon.ChangeModeNTS();
        } else {
            throw new GrammarError(Terminals.CHANGEMODENTS, currentTerminal);
        }
    }

    /*
   <paramList> ::= '(' [<param> {',' <param>}] ')'
   [<param> {',' <param>}] = parameterListNTS()
   */
    private IParameterList parameterList() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN) {
            return new ParameterList(consume(Terminals.LPAREN), parameterListNTS(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.PARAMLIST, currentTerminal);
        }
    }

    /* paramNTS ::= ',' <param> paramNTS | ε */
    private IParameterNTS parameterNTS() throws GrammarError {
        if (currentTerminal == Terminals.COMMA) {
            // paramNTS ::= ',' <param> paramNTS
            return new ParameterNTS(consume(Terminals.COMMA), parameter(), parameterNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // paramNTS ::= ε
            return new IEpsilon.ParameterNTS();
        } else {
            throw new GrammarError(Terminals.PARAMNTS, currentTerminal);
        }
    }

    /* paramListNTS ::= <param> paramNTS | ε */
    private IParameterListNTS parameterListNTS() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.MECHMODE || currentTerminal == Terminals.IDENT) {
            // paramListNTS ::= <param> <paramNTS>
            return new ParameterListNTS(parameter(), parameterNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // paramListNTS ::= ε
            return new IEpsilon.ParameterListNTS();
        } else {
            throw new GrammarError(Terminals.PARAMLISTNTS, currentTerminal);
        }
    }

    /* <param> ::= [<mechModeNTS>] [<changeModeNTS>] <typedIdent> */
    private IParameter parameter() throws GrammarError {
        if (currentTerminal == Terminals.MECHMODE || currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) {
            return new Parameter(mechModeNTS(), changeModeNTS(), typedIdent());
        } else {
            throw new GrammarError(Terminals.PARAM, currentTerminal);
        }
    }

    /* <typedIdent> ::= <ident> ':' <type> */
    private ITypedIdent typedIdent() throws GrammarError {
        if (currentTerminal == Terminals.IDENT) {
            return new TypedIdent(consume(Terminals.IDENT), consume(Terminals.COLON), consume(Terminals.TYPE));
        } else {
            throw new GrammarError(Terminals.TYPEDIDENT, currentTerminal);
        }
    }

    /* <decl> ::= <stoDecl> | <funDecl> | <procDecl> */
    private IDecl decl() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) {
            // decl ::= <stoDecl>
            return new DeclStoDecl(stoDecl());
        } else if (currentTerminal == Terminals.FUN) {
            // decl ::= <funDecl>
            return new DeclFunDecl(funDecl());
        } else if (currentTerminal == Terminals.PROC) {
            // decl ::= <procDecl>
            return new DeclProcDecl(procDecl());
        } else {
            throw new GrammarError(Terminals.DECL, currentTerminal);
        }
    }

    /* <stoDecl> ::= [<changeModeNTS>] <typedIdent> */
    private IStoDecl stoDecl() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE) {
            // stoDecl ::= <changemode> <typedIdent>
            return new StoDeclChangeMode(consume(Terminals.CHANGEMODE), typedIdent());
        } else if (currentTerminal == Terminals.IDENT) {
            // stoDecl ::= <typedIdent>
            return new StoDeclTypedIdent(typedIdent());
        } else {
            throw new GrammarError(Terminals.STODECL, currentTerminal);
        }
    }

    /*
    <funDecl> ::= fun <ident> <paramList> returns <stoDecl> [local cpsStoDecl] do <cpsCmd> endfun
    [local cpsStoDecl] = funDeclNTS()
    */
    private IFunDecl funDecl() throws GrammarError {
        if (currentTerminal == Terminals.FUN) {
            return new FunDecl(consume(Terminals.FUN), consume(Terminals.IDENT), parameterList(), consume(Terminals.RETURNS),
                stoDecl(), funDeclNTS(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDFUN));
        } else {
            throw new GrammarError(Terminals.FUNDECL, currentTerminal);
        }
    }

    /* funDeclNTS ::= local cpsStoNTS | ε */
    private IFunDeclNTS funDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.LOCAL) {
            // funDeclNTS := local <cpsStoDecl>
            return new FunDeclNTS(consume(Terminals.LOCAL), cpsStoDecl());
        } else if (currentTerminal == Terminals.DO) {
            // funDeclNTS := ε
            return new IEpsilon.FunDeclNTS();
        } else {
            throw new GrammarError(Terminals.FUNDECLNTS, currentTerminal);
        }
    }

    /*
    <procDecl> ::= proc <ident> <paramList> [local cpsStoDecl] do <cpsCmd> endproc
    [local cpsStoDecl] = procDeclNTS()
    */
    private IProcDecl procDecl() throws GrammarError {
        if (currentTerminal == Terminals.PROC) {
            return new ProcDecl(consume(Terminals.PROC), consume(Terminals.IDENT), parameterList(), procDeclNTS(),
                consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDPROC));
        } else {
            throw new GrammarError(Terminals.PROCDECL, currentTerminal);
        }
    }

    /* procDeclNTS ::= local <cpsStoDecl> | ε */
    private IProcDeclNTS procDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.LOCAL) {
            // procDeclNTS ::= local <cpsStoDecl>
            return new ProcDeclNTS(consume(Terminals.LOCAL), cpsStoDecl());
        } else if (currentTerminal == Terminals.DO) {
            // procDeclNTS ::= ε
            return new IEpsilon.ProcDeclNTS();
        } else {
            throw new GrammarError(Terminals.PROCDECLNTS, currentTerminal);
        }
    }

    /*
    <cpsDecl> ::= <decl> {';' <decl>}
    {';' <decl>} = cpsDeclNTS()
    */
    private ICpsDecl cpsDecl() throws GrammarError {
        if (currentTerminal == Terminals.PROC || currentTerminal == Terminals.FUN ||
            currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) {
            return new CpsDecl(decl(), cpsDeclNTS());
        } else {
            throw new GrammarError(Terminals.CPSDECL, currentTerminal);
        }
    }

    /* cpsDeclNTS ::= ';' <decl> cpsDeclNTS | ε */
    private ICpsDeclNTS cpsDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {
            // cpsDeclNTS ::= ';' <decl> cpsDeclNTS
            return new CpsDeclNTS(consume(Terminals.SEMICOLON), decl(), cpsDeclNTS());
        } else if (currentTerminal == Terminals.DO) {
            // cpsDeclNTS ::= ε
            return new IEpsilon.CpsDeclNTS();
        } else {
            throw new GrammarError(Terminals.CPSDECLNTS, currentTerminal);
        }
    }

    /*
    <cpsStoDecl> ::= <stoDecl> {';' <stoDecl>}
    {';' <stoDecl>} = cpsStoDeclNTS
    */
    private ICpsStoDecl cpsStoDecl() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) {
            return new CpsStoDecl(stoDecl(), cpsStoDeclNTS());
        } else {
            throw new GrammarError(Terminals.CPSSTODECL, currentTerminal);
        }
    }

    /* cpsStoDeclNTS ::= ';' <stoDecl> cpsStoDeclNTS | ε */
    private ICpsStoDeclNTS cpsStoDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {
            // cpsStoDeclNTS ::= ';' <stoDecl> cpsStoDeclNTS
            return new CpsStoDeclNTS(consume(Terminals.SEMICOLON), stoDecl(), cpsStoDeclNTS());
        } else if (currentTerminal == Terminals.DO) {
            // cpsStoDeclNTS ::= ε
            return new IEpsilon.CpsStoDeclNTS();
        } else {
            throw new GrammarError(Terminals.CPSSTODECLNTS, currentTerminal);
        }
    }

    /* <cmd> ::=    skip | <expr> ':=' <expr> | if <expr> then <cpsCmd> [else <cpsCmd>] endif | while <expr> do <cpsCmd> endwhile
                    | call <ident> <exprList> | debugin <expr> | debugout <expr>

    [else <cpsCmd>] = ifElseNTS()
    */
    private ICmd cmd() throws GrammarError {
        if (currentTerminal == Terminals.SKIP) {
            // <cmd> ::= skip
            return new CmdSkip(consume(Terminals.SKIP));
        } else if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            // <cmd> ::= <expr> ':=' <expr>
            return new CmdExpression(expression(), consume(Terminals.BECOMES), expression());
        } else if (currentTerminal == Terminals.IF) {
            // <cmd> ::= if <expr> then <cpsCmd> [else <cpsCmd>] endif
            return new CmdIfThen(consume(Terminals.IF), expression(), consume(Terminals.THEN), cpsCmd(), ifElseNTS(), consume(Terminals.ENDIF));
        } else if (currentTerminal == Terminals.WHILE) {
            // <cmd> ::= while <expr> do <cpsCmd> endwhile
            return new CmdWhileDo(consume(Terminals.WHILE), expression(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDWHILE));
        } else if (currentTerminal == Terminals.CALL) {
            // <cmd> ::= call <ident> <exprList>
            return new CmdCallIdentExpressionList(consume(Terminals.CALL), consume(Terminals.IDENT), expressionList());
        } else if (currentTerminal == Terminals.DEBUGIN) {
            // <cmd> ::= debugin <expr>
            return new CmdDebugIn(consume(Terminals.DEBUGIN), expression());
        } else if (currentTerminal == Terminals.DEBUGOUT) {
            // <cmd> ::= debugout <expr>
            return new CmdDebugOut(consume(Terminals.DEBUGOUT), expression());
        } else {
            throw new GrammarError(Terminals.CMD, currentTerminal);
        }
    }

    /* ifElseNTS ::= else <cpsCmd> | ε */
    private IIfElseNTS ifElseNTS() throws GrammarError {
        if (currentTerminal == Terminals.ELSE) {
            // ifElseNTS ::= else <cpsCmd>
            return new IfElseNTS(consume(Terminals.ELSE), cpsCmd());
        } else if (currentTerminal == Terminals.ENDIF) {
            // ifElseNTS ::= ε
            return new IEpsilon.IfElseNTS();
        } else {
            throw new GrammarError(Terminals.IFELSENTS, currentTerminal);
        }
    }

    /*
    <cpsCmd> ::= <cmd> {';' <cmd>}
    {';' <cmd>} = cpsCmdNTS()
    */
    private ICpsCmd cpsCmd() throws GrammarError {
        if (currentTerminal == Terminals.DEBUGOUT || currentTerminal == Terminals.DEBUGIN || currentTerminal == Terminals.CALL
            || currentTerminal == Terminals.WHILE || currentTerminal == Terminals.IF || currentTerminal == Terminals.LPAREN
            || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR || currentTerminal == Terminals.IDENT
            || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.SKIP) {
            return new CpsCmd(cmd(), cpsCmdNTS());
        } else {
            throw new GrammarError(Terminals.CPSCMD, currentTerminal);
        }
    }

    /* cpsCmdNTS ::= ';' <cmd> cpsCmdNTS | ε */
    private ICpsCmdNTS cpsCmdNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {
            // cpsCmdNTS ::= ';' <cmd> cpsCmdNTS
            return new CpsCmdNTS(consume(Terminals.SEMICOLON), cmd(), cpsCmdNTS());
        } else if (currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM) {
            // cpsCmdNTS ::= ε
            return new IEpsilon.CpsCmdNTS();
        } else {
            throw new GrammarError(Terminals.CPSCMDNTS, currentTerminal);
        }
    }

    /*
    <expr> ::= <term1> ({'/\?' <term1>} | {'\/?' <term1>})
    ({'/\?' <term1>} | {'\/?' <term1>}) = expressionNTS()
    */
    private IExpression expression() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            return new Expression(term1(), expressionNTS());
        } else {
            throw new GrammarError(Terminals.EXPR, currentTerminal);
        }
    }

    /* exprNTS ::= BOOLOPR term1 exprNTS | ε */
    private IExpressionNTS expressionNTS() throws GrammarError {
        if (currentTerminal == Terminals.BOOLOPR) {
            // exprNTS ::= BOOLOPR term1 exprNTS
            return new ExpressionNTS(consume(Terminals.BOOLOPR), term1(), expressionNTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.DO
            || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDFUN
            || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON || currentTerminal == Terminals.BECOMES) {
            // expressionNTS ::= ε
            return new IEpsilon.ExpressionNTS();
        } else {
            throw new GrammarError(Terminals.EXPRNTS, currentTerminal);
        }
    }

    /*
    <term1> ::= <term2> [<relopr> <term2>]
    [<relopr> <term2>] = term1NTS()
    */
    private ITerm1 term1() throws GrammarError {
        if(currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL){
            return new Term1(term2(), term1NTS());
        } else {
            throw new GrammarError(Terminals.TERM1, currentTerminal);
        }
    }

    /* term1NTS ::= <relopr> <term2> term1NTS | ε */
    private ITerm1NTS term1NTS() throws GrammarError {
        if (currentTerminal == Terminals.RELOPR) {
            // term1NTS ::= <relopr> <term2> term1NTS
            return new Term1NTS(consume(Terminals.RELOPR), term2(), term1NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.DO
            || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDFUN
            || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON || currentTerminal == Terminals.BECOMES
            || currentTerminal == Terminals.BOOLOPR) {
            // term1NTS ::= ε
            return new IEpsilon.Term1NTS();
        } else {
            throw new GrammarError(Terminals.TERM1NTS, currentTerminal);
        }
    }

    /*
    <term2> ::= <term3> {<addopr> <term3>}
    {<addopr> <term3>} = term2NTS()
    */
    private ITerm2 term2() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            return new Term2(term3(), term2NTS());
        } else {
            throw new GrammarError(Terminals.TERM2, currentTerminal);
        }
    }

    /* term2NTS ::= <addopr> <term3> term2NTS | ε */
    private ITerm2NTS term2NTS() throws GrammarError {
        if (currentTerminal == Terminals.ADDOPR) {
            // term2NTS ::= <addopr> <term3> term2NTS
            return new Term2NTS(consume(Terminals.ADDOPR), term3(), term2NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.DO
            || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDFUN
            || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON || currentTerminal == Terminals.BECOMES
            || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR) {
            // term2NTS ::= ε
            return new IEpsilon.Term2NTS();
        } else {
            throw new GrammarError(Terminals.TERM2NTS, currentTerminal);
        }
    }

    /*
    <term3> ::= <term4> {<multopr> <term4>}
    {<multopr> <term4>} = term3NTS()
    */
    private ITerm3 term3() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.MULTOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            return new Term3(term4(), term3NTS());
        } else {
            throw new GrammarError(Terminals.TERM3, currentTerminal);
        }
    }

    /* term3NTS ::= <multopr> <term4> term3NTS | ε */
    private ITerm3NTS term3NTS() throws GrammarError {
        if (currentTerminal == Terminals.MULTOPR) {
            // term3NTS ::= <multopr> <term4> term3NTS
            return new Term3NTS(consume(Terminals.MULTOPR), term4(), term3NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.DO
            || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDFUN
            || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON || currentTerminal == Terminals.BECOMES
            || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR) {
            // term3NTS ::= ε
            return new IEpsilon.Term3NTS();
        } else {
            throw new GrammarError(Terminals.TERM3NTS, currentTerminal);
        }
    }

    /*
    <term4> ::= <factor> {<custopr> <factor>}
    {<custopr> <factor>} = term4NTS()
    */
    private ITerm4 term4() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            return new Term4(factor(), term4NTS());
        } else {
            throw new GrammarError(Terminals.TERM4, currentTerminal);
        }
    }

    /* term4NTS ::= <custopr> <factor> term3NTS | ε */
    private ITerm4NTS term4NTS() throws GrammarError {
        if (currentTerminal == Terminals.CUSTOPR) {
            // term4NTS ::= <custopr> <factor> term4NTS
            return new Term4NTS(consume(Terminals.CUSTOPR), factor(), term4NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.DO
            || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDFUN
            || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON || currentTerminal == Terminals.BECOMES
            || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR || currentTerminal == Terminals.ADDOPR
            || currentTerminal == Terminals.MULTOPR) {
            // term4NTS ::= ε
            return new IEpsilon.Term4NTS();
        } else {
            throw new GrammarError(Terminals.TERM4NTS, currentTerminal);
        }
    }

    /*
    <factor> ::= <literal> | <ident> [init | <exprList>] | <monopr> <factor> | '(' <expr> ')'
    [init | <exprList>] = factorNTS()
    */
    private IFactor factor() throws GrammarError {
        if (currentTerminal == Terminals.LITERAL) {
            // <factor> ::= <literal>
            return new FactorLiteral(consume(Terminals.LITERAL));
        } else if (currentTerminal == Terminals.IDENT) {
            // <factor> ::= <ident> [init | <exprList>]
            return new FactorIdent(consume(Terminals.IDENT), factorNTS());
        } else if (currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR) {
            // <factor> ::= <monopr> <factor>
            return new FactorMonOpr(monOpr(), factor());
        } else if (currentTerminal == Terminals.LPAREN) {
            // <factor> ::= '(' <expr> ')'
            return new FactorLParen(consume(Terminals.LPAREN), expression(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.FACTOR, currentTerminal);
        }
    }

    /* factorNTS ::= init | <exprList> | ε */
    private IFactorNTS factorNTS() throws GrammarError {
        if (currentTerminal == Terminals.INIT) {
            // factorNTS ::= init
            return new FactorNTSInit(consume(Terminals.INIT));
        } else if (currentTerminal == Terminals.LPAREN) {
            // factorNTS ::= <exprList>
            return new FactorNTSExpressionList(expressionList());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.DO
            || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDWHILE
            || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDFUN
            || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON || currentTerminal == Terminals.BECOMES
            || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR || currentTerminal == Terminals.ADDOPR
            || currentTerminal == Terminals.MULTOPR || currentTerminal == Terminals.CUSTOPR) {
            // factorNTS ::= ε
            return new IEpsilon.FactorNTS();
        } else {
            throw new GrammarError(Terminals.FACTORNTS, currentTerminal);
        }
    }

    /*
    <exprList> ::= '(' [<expr> {',' <expr>}] ')'
    [<expr> {',' <expr>}] = exprListLParenNTS()
    */
    private IExpressionList expressionList() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN) {
            return new ExpressionList(consume(Terminals.LPAREN), expressionListLParenNTS(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.EXPRLIST, currentTerminal);
        }
    }

    /* exprListLParenNTS ::= <expr> exprListNTS | ε */
    private IExpressionListLParenNTS expressionListLParenNTS() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            // exprListLParenNTS ::= <expr> exprListNTS
            return new ExpressionListLParenNTS(expression(), expressionListNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // exprListLParenNTS ::= ε
            return new IEpsilon.ExpressionListLParenNTS();
        } else {
            throw new GrammarError(Terminals.EXPRLISTLPARENNTS, currentTerminal);
        }
    }

    /* exprListNTS ::= ',' <expr> exprListNTS | ε */
    private IExpressionListNTS expressionListNTS() throws GrammarError {
        if (currentTerminal == Terminals.COMMA) {
            // expressionListNTS ::= ',' <expr> exprListNTS
            return new ExpressionListNTS(consume(Terminals.COMMA), expression(), expressionListNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // expressionListNTS ::= ε
            return new IEpsilon.ExpressionListNTS();
        } else {
            throw new GrammarError(Terminals.EXPRLISTNTS, currentTerminal);
        }
    }

    /* <relopr> ::= '=' | '/=' | '<' | '>' | '<=' | '>=' */
    private IRelOpr relOpr() throws GrammarError {
        return new RelOpr(consume(Terminals.RELOPR));
    }

    /* <addopr> ::= '+' | '-' */
    private IAddOpr addOpr() throws GrammarError {
        return new AddOpr(consume(Terminals.ADDOPR));
    }

    /*
    <multopr> ::= '*' | <divopr>
    <divopr> ::= 'divT' | 'modT'
    */
    private IMultOpr multOpr() throws GrammarError {
        return new MultOpr(consume(Terminals.MULTOPR));
    }

    /* <monopr> ::= '~' | <addopr> */
    private IMonOpr monOpr() throws GrammarError {
        if (currentTerminal == Terminals.NOTOPR) {
            // <monopr> ::= '~'
            return new MonOprNot(consume(Terminals.NOTOPR));
        } else if (currentTerminal == Terminals.ADDOPR) {
            // <monopr> ::= <addopr>
            return new MonOprAddOpr(consume(Terminals.ADDOPR));
        } else {
            throw new GrammarError(Terminals.MONOPR, currentTerminal);
        }
    }

}
