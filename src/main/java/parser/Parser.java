package parser;

import concreteSyntaxTree.*;
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
import concreteSyntaxTree.expressions.FactorMonadicOpr;
import concreteSyntaxTree.expressions.Term1;
import concreteSyntaxTree.expressions.Term2;
import concreteSyntaxTree.expressions.Term3;
import concreteSyntaxTree.expressions.Term4;
import concreteSyntaxTree.interfaces.*;
import concreteSyntaxTree.operators.MonadicOprAddOpr;
import concreteSyntaxTree.operators.MonadicOprNot;
import concreteSyntaxTree.parameterLists.Parameter;
import concreteSyntaxTree.parameterLists.ParameterList;
import concreteSyntaxTree.parameterLists.TypedIdent;
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

    /* program ::= PROGRAM IDENT DO cpsCmd ENDPROGRAM */
    private IProgram program() throws GrammarError {
        if (this.currentTerminal == Terminals.PROGRAM) {
            // program ::= PROGRAM IDENT DO <cpsCmd> ENDPROGRAM
            return new Program(consume(Terminals.PROGRAM), consume(Terminals.IDENT), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDPROGRAM));
        } else {
            throw new GrammarError(Terminals.PROGRAM, currentTerminal);
        }
    }

    /* typedIdent ::= IDENT COLON TYPE */
    private ITypedIdent typedIdent() throws GrammarError {
        if (currentTerminal == Terminals.IDENT) {
            // typedIdent ::= IDENT COLON TYPE
            return new TypedIdent(consume(Terminals.IDENT), consume(Terminals.COLON), consume(Terminals.TYPE));
        } else {
            throw new GrammarError(Terminals.TYPEDIDENT, currentTerminal);
        }
    }

    /*
    stoDecl ::= typedIdent
    stoDecl ::= CHANGEMODE typedIdent
    */
    private IStoDecl stoDecl() throws GrammarError {
        if (currentTerminal == Terminals.IDENT) {
            // stoDecl ::= <typedIdent>
            return new StoDeclTypedIdent(typedIdent());
        } else if (currentTerminal == Terminals.CHANGEMODE) {
            // stoDecl ::= CHANGEMODE <typedIdent>
            return new StoDeclChangeMode(consume(Terminals.CHANGEMODE), typedIdent());
        } else {
            throw new GrammarError(Terminals.STODECL, currentTerminal);
        }
    }

    /*
    mechModeNTS ::= MECHMODE
    mechModeNTS::= ε
    */
    private IMechModeNTS mechModeNTS() throws GrammarError {
        if (currentTerminal == Terminals.MECHMODE) {
            // mechModeNTS ::= MECHMODE
            return new MechModeNTS(consume(Terminals.MECHMODE));
        } else if (currentTerminal == Terminals.IDENT || currentTerminal == Terminals.CHANGEMODE) {
            // mechModeNTS ::= ε
            return new IEpsilon.MechModeNTS();
        } else {
            throw new GrammarError(Terminals.MECHMODENTS, currentTerminal);
        }
    }

    /*
    changeModeNTS ::= CHANGEMODE
    changeModeNTS::= ε
    */
    private IChangeModeNTS changeModeNTS() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE) {
            // changeModeNTS ::= CHANGEMODE
            return new ChangeModeNTS(consume(Terminals.CHANGEMODE));
        } else if (currentTerminal == Terminals.IDENT) {
            // changeModeNTS ::= ε
            return new IEpsilon.ChangeModeNTS();
        } else {
            throw new GrammarError(Terminals.CHANGEMODENTS, currentTerminal);
        }
    }

    /* param ::= mechModeNTS changeModeNTS typedIdent */
    private IParameter parameter() throws GrammarError {
        if (currentTerminal == Terminals.IDENT || currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.MECHMODE) {
            // param ::= <mechModeNTS> <changeModeNTS> <typedIdent>
            return new Parameter(mechModeNTS(), changeModeNTS(), typedIdent());
        } else {
            throw new GrammarError(Terminals.PARAM, currentTerminal);
        }
    }

    /*
    paramNTS ::= COMMA parameter parameterNTS
    paramNTS ::= ε
    */
    private IParameterNTS parameterNTS() throws GrammarError {
        if (currentTerminal == Terminals.COMMA) {
            // parameterNTS ::= COMMA <parameter> <parameterNTS>
            return new ParameterNTS(consume(Terminals.COMMA), parameter(), parameterNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // parameterNTS ::= ε
            return new IEpsilon.ParameterNTS();
        } else {
            throw new GrammarError(Terminals.PARAMNTS, currentTerminal);
        }
    }

    /*
    parameterListNTS ::= parameter parameterNTS
    parameterListNTS ::= ε
    */
    private IParameterListNTS parameterListNTS() throws GrammarError {
        if (currentTerminal == Terminals.IDENT || currentTerminal == Terminals.MECHMODE || currentTerminal == Terminals.CHANGEMODE) {
            // parameterListNTS ::= <parameter> <parameterNTS>
            return new ParameterListNTS(parameter(), parameterNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // parameterListNTS ::= ε
            return new IEpsilon.ParameterListNTS();
        } else {
            throw new GrammarError(Terminals.PARAMLISTNTS, currentTerminal);
        }
    }

    /* parameterList ::= LPAREN parameterListNTS RPAREN */
    private IParameterList parameterList() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN) {
            // parameterList ::= LPAREN <parameterListNTS> RPAREN
            return new ParameterList(consume(Terminals.LPAREN), parameterListNTS(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.PARAMLIST, currentTerminal);
        }
    }

    /*
    funDeclNTS ::= LOCAL cpsStoNTS
    funDeclNTS ::= ε
    */
    private IFunDeclNTS funDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.LOCAL) {
            // funDeclNTS := LOCAL <cpsStoDecl>
            return new FunDeclNTS(consume(Terminals.LOCAL), cpsStoDecl());
        } else if (currentTerminal == Terminals.DO) {
            // funDeclNTS := ε
            return new IEpsilon.FunDeclNTS();
        } else {
            throw new GrammarError(Terminals.FUNDECLNTS, currentTerminal);
        }
    }

    /* funDecl ::= FUN IDENT parameterList RETURNS stoDecl funDeclNTS DO cpsCmd ENDFUN */
    private IFunDecl funDecl() throws GrammarError {
        if (currentTerminal == Terminals.FUN) {
            // funDecl ::= FUN IDENT <parameterList> RETURNS <stoDecl> <funDeclNTS> DO <cpsCmd> ENDFUN
            return new FunDecl(consume(Terminals.FUN), consume(Terminals.IDENT), parameterList(), consume(Terminals.RETURNS),
                stoDecl(), funDeclNTS(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDFUN));
        } else {
            throw new GrammarError(Terminals.FUNDECL, currentTerminal);
        }
    }

    /* term1 ::= term2 term1NTS */
    private ITerm1 term1() throws GrammarError {
        if(currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET){
            // term1 ::= <term2> <term1NTS>
            return new Term1(term2(), term1NTS());
        } else {
            throw new GrammarError(Terminals.TERM1, currentTerminal);
        }
    }

    /*
    term1NTS ::= RELOPR term2 term1NTS
    term1NTS ::= ε
    */
    private ITerm1NTS term1NTS() throws GrammarError {
        if (currentTerminal == Terminals.RELOPR) {
            // term1NTS ::= RELOPR <term2> <term1NTS>
            return new Term1NTS(consume(Terminals.RELOPR), term2(), term1NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.COLON
            || currentTerminal == Terminals.DO || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC
            || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON
            || currentTerminal == Terminals.BECOMES || currentTerminal == Terminals.BOOLOPR) {
            // term1NTS ::= ε
            return new IEpsilon.Term1NTS();
        } else {
            throw new GrammarError(Terminals.TERM1NTS, currentTerminal);
        }
    }

    /* term2 ::= term3 term2NTS */
    private ITerm2 term2() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            // term2 ::= <term3> <term2NTS>
            return new Term2(term3(), term2NTS());
        } else {
            throw new GrammarError(Terminals.TERM2, currentTerminal);
        }
    }

    /*
    term2NTS ::= ADDOPR term3 term2NTS
    term2NTS ::= ε
    */
    private ITerm2NTS term2NTS() throws GrammarError {
        if (currentTerminal == Terminals.ADDOPR) {
            // term2NTS ::= ADDOPR <term3> <term2NTS>
            return new Term2NTS(consume(Terminals.ADDOPR), term3(), term2NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.COLON
            || currentTerminal == Terminals.DO || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC
            || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON
            || currentTerminal == Terminals.BECOMES || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR) {
            // term2NTS ::= ε
            return new IEpsilon.Term2NTS();
        } else {
            throw new GrammarError(Terminals.TERM2NTS, currentTerminal);
        }
    }

    /* term3 ::= term4 term3NTS */
    private ITerm3 term3() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.MULTOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            // term3 ::= <term4> <term3NTS>
            return new Term3(term4(), term3NTS());
        } else {
            throw new GrammarError(Terminals.TERM3, currentTerminal);
        }
    }

    /*
    term3NTS ::= MULTOPR term4 term3NTS
    term3NTS ::= ε
    */
    private ITerm3NTS term3NTS() throws GrammarError {
        if (currentTerminal == Terminals.MULTOPR) {
            // term3NTS ::= MULTOPR <term4> <term3NTS>
            return new Term3NTS(consume(Terminals.MULTOPR), term4(), term3NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.COLON
            || currentTerminal == Terminals.DO || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC
            || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON
            || currentTerminal == Terminals.BECOMES || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR) {
            // term3NTS ::= ε
            return new IEpsilon.Term3NTS();
        } else {
            throw new GrammarError(Terminals.TERM3NTS, currentTerminal);
        }
    }

    /* term4 ::= factor term4NTS */
    private ITerm4 term4() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            // term4 ::= <factor> <term3NTS>
            return new Term4(factor(), term4NTS());
        } else {
            throw new GrammarError(Terminals.TERM4, currentTerminal);
        }
    }

    /*
    term4NTS ::= CUSTOPR factor term3NTS
    term4NTS ::= ε
    */
    private ITerm4NTS term4NTS() throws GrammarError {
        if (currentTerminal == Terminals.CUSTOPR) {
            // term3NTS ::= MULTOPR <factor> <term3NTS>
            return new Term4NTS(consume(Terminals.CUSTOPR), factor(), term4NTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.COLON
            || currentTerminal == Terminals.DO || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC
            || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON
            || currentTerminal == Terminals.BECOMES || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR
            || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.MULTOPR) {
            // term3NTS ::= ε
            return new IEpsilon.Term4NTS();
        } else {
            throw new GrammarError(Terminals.TERM4NTS, currentTerminal);
        }
    }

    /*
    monadicOpr ::= NOT
    monadicOpr ::= ADDOPR
    */
    private IMonadicOpr monadicOpr() throws GrammarError {
        if (currentTerminal == Terminals.NOTOPR) {
            // monadicOpr ::= NOT
            return new MonadicOprNot(consume(Terminals.NOTOPR));
        } else if (currentTerminal == Terminals.ADDOPR) {
            // monadicOpr ::= ADDOPR
            return new MonadicOprAddOpr(consume(Terminals.ADDOPR));
        } else {
            throw new GrammarError(Terminals.MONADICOPR, currentTerminal);
        }
    }

    /*
    factor ::= LITERAL
    factor ::= IDENT factorNTS
    factor ::= monadicOpr factor
    factor ::= LPAREN expression RPAREN
    */
    private IFactor factor() throws GrammarError {
        if (currentTerminal == Terminals.LITERAL) {
            // factor ::= LITERAL
            return new FactorLiteral(consume(Terminals.LITERAL));
        } else if (currentTerminal == Terminals.IDENT) {
            // factor ::= IDENT <factorNTS>
            return new FactorIdent(consume(Terminals.IDENT), factorNTS());
        } else if (currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR) {
            // factor ::= <monadicOpr> <factor>
            return new FactorMonadicOpr(monadicOpr(), factor());
        } else if (currentTerminal == Terminals.LPAREN) {
            // factor ::= LPAREN <expression> RPAREN
            return new FactorLParen(consume(Terminals.LPAREN), expression(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.FACTOR, currentTerminal);
        }
    }

    /*
    factorNTS ::= INIT
    factorNTS ::= expressionList
    factorNTS ::= ε
    */
    private IFactorNTS factorNTS() throws GrammarError {
        if (currentTerminal == Terminals.INIT) {
            // factorNTS ::= INIT
            return new FactorNTSInit(consume(Terminals.INIT));
        } else if (currentTerminal == Terminals.LPAREN) {
            // factorNTS ::= <expressionList>
            return new FactorNTSExpressionList(expressionList());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.COLON
            || currentTerminal == Terminals.DO || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC
            || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON
            || currentTerminal == Terminals.BECOMES || currentTerminal == Terminals.BOOLOPR || currentTerminal == Terminals.RELOPR
            || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.MULTOPR || currentTerminal == Terminals.CUSTOPR) {
            // factorNTS ::= ε
            return new IEpsilon.FactorNTS();
        } else {
            throw new GrammarError(Terminals.FACTORNTS, currentTerminal);
        }
    }

    /* expression ::= term1 expressionNTS */
    private IExpression expression() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            // expression ::= <term1> <exprNTS>
            return new Expression(term1(), expressionNTS());
        } else {
            throw new GrammarError(Terminals.EXPR, currentTerminal);
        }
    }

    /*
    expressionNTS ::= BOOLOPR term1 expressionNTS
    expressionNTS ::= ε
     */
    private IExpressionNTS expressionNTS() throws GrammarError {
        if (currentTerminal == Terminals.BOOLOPR) {
            // expressionNTS ::= BOOLOPR <term1> <expressionNTS>
            return new ExpressionNTS(consume(Terminals.BOOLOPR), term1(), expressionNTS());
        } else if (currentTerminal == Terminals.COMMA || currentTerminal == Terminals.RPAREN || currentTerminal == Terminals.COLON
            || currentTerminal == Terminals.DO || currentTerminal == Terminals.THEN || currentTerminal == Terminals.ENDPROC
            || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF || currentTerminal == Terminals.ELSE
            || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM || currentTerminal == Terminals.SEMICOLON
            || currentTerminal == Terminals.BECOMES) {
            // expressionNTS ::= ε
            return new IEpsilon.ExpressionNTS();
        } else {
            throw new GrammarError(Terminals.EXPRNTS, currentTerminal);
        }
    }

    /*
    expressionListNTS ::= COMMA expression expressionListNTS
    expressionListNTS ::= ε
    */
    private IExpressionListNTS expressionListNTS() throws GrammarError {
        if (currentTerminal == Terminals.COMMA) {
            // expressionListNTS ::= COMMA <expression> <expressionListNTS>
            return new ExpressionListNTS(consume(Terminals.COMMA), expression(), expressionListNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // expressionListNTS ::= ε
            return new IEpsilon.ExpressionListNTS();
        } else {
            throw new GrammarError(Terminals.EXPRLISTNTS, currentTerminal);
        }
    }

    /*
    expressionListLparenNTS ::= expression expressionListNTS
    expressionListLparenNTS ::= ε
    */
    private IExpressionListLParenNTS expressionListLParenNTS() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL || currentTerminal == Terminals.LBRACKET) {
            // expressionListLparenNTS ::= <expression> <expressionListNTS>
            return new ExpressionListLParenNTS(expression(), expressionListNTS());
        } else if (currentTerminal == Terminals.RPAREN) {
            // expressionListLparenNTS ::= ε
            return new IEpsilon.ExpressionListLParenNTS();
        } else {
            throw new GrammarError(Terminals.EXPRLISTLPARENNTS, currentTerminal);
        }
    }

    /* expressionList ::= LPAREN expressionListLparenNTS RPAREN */
    private IExpressionList expressionList() throws GrammarError {
        if (currentTerminal == Terminals.LPAREN) {
            // expressionList ::= LPAREN <expressionListLparenNTS> RPAREN
            return new ExpressionList(consume(Terminals.LPAREN), expressionListLParenNTS(), consume(Terminals.RPAREN));
        } else {
            throw new GrammarError(Terminals.EXPRLIST, currentTerminal);
        }
    }

    /*
    ifElseNTS ::= ELSE cpsCmd
    ifElseNTS ::= ε
    */
    private IIfElseNTS ifElseNTS() throws GrammarError {
        if (currentTerminal == Terminals.ELSE) {
            // ifElseNTS ::= ELSE <cpsCmd>
            return new IfElseNTS(consume(Terminals.ELSE), cpsCmd());
        } else if (currentTerminal == Terminals.ENDIF) {
            // ifElseNTS ::= ε
            return new IEpsilon.IfElseNTS();
        } else {
            throw new GrammarError(Terminals.IFELSENTS, currentTerminal);
        }
    }

    /*
    cmd ::= SKIP
    cmd ::= expression BECOMES expression
    cmd ::= IF expression THEN cpsCmd ifElseNTS ENDIF
    cmd ::= WHILE expression DO cpsCmd ENDWHILE
    cmd ::= CALL IDENT expressionList
    cmd ::= DEBUGIN expression
    cmd ::= DEBUGOUT expression
    */
    private ICmd cmd() throws GrammarError {
        if (currentTerminal == Terminals.SKIP) {
            // cmd ::= SKIP
            return new CmdSkip(consume(Terminals.SKIP));
        } else if (currentTerminal == Terminals.LPAREN || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL) {
            // cmd ::= <expression> BECOMES <expr>
            IExpression N_expr1 = expression();
            IExpression N_expr2 = expression();
            return new CmdExpression(N_expr1, consume(Terminals.BECOMES), N_expr2);
        } else if (currentTerminal == Terminals.IF) {
            // cmd ::= IF <expression> THEN <cpsCmd> <ifElseNTS> ENDIF
            return new CmdIfThen(consume(Terminals.IF), expression(), consume(Terminals.THEN), cpsCmd(), ifElseNTS(), consume(Terminals.ENDIF));
        } else if (currentTerminal == Terminals.WHILE) {
            // cmd ::= WHILE <expression> DO <cpsCmd> ENDWHILE
            return new CmdWhileDo(consume(Terminals.WHILE), expression(), consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDWHILE));
        } else if (currentTerminal == Terminals.CALL) {
            // cmd ::= CALL IDENT <expressionList>
            return new CmdCallIdentExpressionList(consume(Terminals.CALL), consume(Terminals.IDENT), expressionList());
        } else if (currentTerminal == Terminals.DEBUGIN) {
            // cmd ::= DEBUGIN <expression>
            return new CmdDebugIn(consume(Terminals.DEBUGIN), expression());
        } else if (currentTerminal == Terminals.DEBUGOUT) {
            // cmd ::= DEBUGOUT <expression>
            return new CmdDebugOut(consume(Terminals.DEBUGOUT), expression());
        } else {
            throw new GrammarError(Terminals.CMD, currentTerminal);
        }
    }

    /*
    cpsCmdNTS ::= SEMICOLON cmd cpsCmdNTS
    cpsCmdNTS ::= ε
    */
    private ICpsCmdNTS cpsCmdNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {
            // cpsCmdNTS ::= SEMICOLON <cmd> <cpsCmdNTS>
            return new CpsCmdNTS(consume(Terminals.SEMICOLON), cmd(), cpsCmdNTS());
        } else if (currentTerminal == Terminals.ENDPROC || currentTerminal == Terminals.ENDWHILE || currentTerminal == Terminals.ENDIF
            || currentTerminal == Terminals.ELSE || currentTerminal == Terminals.ENDFUN || currentTerminal == Terminals.ENDPROGRAM) {
            // cpsCmdNTS ::= ε
            return new IEpsilon.CpsCmdNTS();
        } else {
            throw new GrammarError(Terminals.CPSCMDNTS, currentTerminal);
        }
    }

    /* cpsCmd ::= cmd cpsCmdNTS */
    private ICpsCmd cpsCmd() throws GrammarError {
        if (currentTerminal == Terminals.DEBUGOUT || currentTerminal == Terminals.DEBUGIN || currentTerminal == Terminals.CALL
            || currentTerminal == Terminals.WHILE || currentTerminal == Terminals.IF || currentTerminal == Terminals.LPAREN
            || currentTerminal == Terminals.ADDOPR || currentTerminal == Terminals.NOTOPR
            || currentTerminal == Terminals.IDENT || currentTerminal == Terminals.LITERAL
            || currentTerminal == Terminals.SKIP) {
            // cpsCMD ::= <cmd> <cpsCmdNTS>
            return new CpsCmd(cmd(), cpsCmdNTS());
        } else {
            throw new GrammarError(Terminals.CPSCMD, currentTerminal);
        }
    }

    /*
    cpsStoDeclNTS ::= SEMICOLON stoDecl cpsStoDeclNTS
    cpsStoDeclNTS ::= ε
    */
    private ICpsStoDeclNTS cpsStoDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {
            // cpsStoDeclNTS ::= SEMICOLON <stoDecl> <cpsStoDeclNTS>
            return new CpsStoDeclNTS(consume(Terminals.SEMICOLON), stoDecl(), cpsStoDeclNTS());
        } else if (currentTerminal == Terminals.DO) {
            // cpsStoDeclNTS ::= ε
            return new IEpsilon.CpsStoDeclNTS();
        } else {
            throw new GrammarError(Terminals.CPSSTODECLNTS, currentTerminal);
        }
    }

    /* cpsStoDecl ::= stoDecl cpsStoDeclNTS */
    private ICpsStoDecl cpsStoDecl() throws GrammarError {
        if (currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) {
            // cpsStoDecl ::= <stoDecl> <cpsStoDeclNTS>
            return new CpsStoDecl(stoDecl(), cpsStoDeclNTS());
        } else {
            throw new GrammarError(Terminals.CPSSTODECL, currentTerminal);
        }
    }

    /*
    procDeclNTS ::= LOCAL cpsStoDecl
    procDeclNTS ::= ε
    */
    private IProcDeclNTS procDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.LOCAL) {
            // procDeclNTS ::= LOCAL <cpsStoDecl>
            return new ProcDeclNTS(consume(Terminals.LOCAL), cpsStoDecl());
        } else if (currentTerminal == Terminals.DO) {
            // procDeclNTS ::= ε
            return new IEpsilon.ProcDeclNTS();
        } else {
            throw new GrammarError(Terminals.PROCDECLNTS, currentTerminal);
        }
    }

    /* procDecl ::= PROC IDENT parameterList procDeclNTS DO cpsCmd ENDPROC */
    private IProcDecl procDecl() throws GrammarError {
        if (currentTerminal == Terminals.PROC) {
            // procDecl ::= PROC IDENT <parameterList> <procDeclNTS> DO <cpsCmd> ENDPROC
            return new ProcDecl(consume(Terminals.PROC), consume(Terminals.IDENT), parameterList(), procDeclNTS(),
                consume(Terminals.DO), cpsCmd(), consume(Terminals.ENDPROC));
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

    /*
    cpsDeclNTS ::= SEMICOLON decl cpsDeclNTS
    cpsDeclNTS ::= ε
    */
    private ICpsDeclNTS cpsDeclNTS() throws GrammarError {
        if (currentTerminal == Terminals.SEMICOLON) {
            // cpsDeclNTS ::= SEMICOLON <decl> <cpsDeclNTS>
            return new CpsDeclNTS(consume(Terminals.SEMICOLON), decl(), cpsDeclNTS());
        } else if (currentTerminal == Terminals.DO) {
            // cpsDeclNTS ::= ε
            return new IEpsilon.CpsDeclNTS();
        } else {
            throw new GrammarError(Terminals.CPSDECLNTS, currentTerminal);
        }
    }

    /* cpsDecl ::= decl cpsDeclNTS */
    private ICpsDecl cpsDecl() throws GrammarError {
        if (currentTerminal == Terminals.PROC || currentTerminal == Terminals.FUN ||
            currentTerminal == Terminals.CHANGEMODE || currentTerminal == Terminals.IDENT) {
            // cpsDecl ::= <decl> <cpsDeclNTS>
            return new CpsDecl(decl(), cpsDeclNTS());
        } else {
            throw new GrammarError(Terminals.CPSDECL, currentTerminal);
        }
    }

}
