package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.commands.CpsCmd;
import abstractSyntaxTree.factors.InitFactor;
import abstractSyntaxTree.parameterLists.Parameter;
import abstractSyntaxTree.declarations.StoDecl;
import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.Production;
import abstractSyntaxTree.interfaces.ICmd;
import abstractSyntaxTree.interfaces.IExpression;
import abstractSyntaxTree.interfaces.IFactor;
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
import scanner.Ident;
import scanner.enums.ChangeModes;
import scanner.enums.MechModes;
import java.util.ArrayList;

public interface IEpsilon {

    class CpsCmdNTS extends Production implements ICpsCmdNTS {
        @Override
        public ArrayList<ICmd> toAbstractSyntax(
            ArrayList<ICmd> temp) {
            return temp;
        }
    }

    class CpsDeclNTS extends Production implements ICpsDeclNTS {
        @Override
        public ArrayList<IDecl> toAbstractSyntax(ArrayList<IDecl> temp) {
            return temp;
        }
    }

    class CpsStoDeclNTS extends Production implements ICpsStoDeclNTS {
        @Override
        public ArrayList<StoDecl> toAbstractSyntax(ArrayList<StoDecl> temp) {
            return temp;
        }
    }

    class ExpressionNTS extends Production implements IExpressionNTS {
        @Override
        public IExpression toAbstractSyntax(IExpression expression) {
            return expression;
        }
    }

    class ExpressionListLParenNTS extends Production implements IExpressionListLParenNTS {
        @Override
        public ArrayList<IExpression> toAbstractSyntax() {
            return new ArrayList<>();
        }
    }

    class ExpressionListNTS extends Production implements IExpressionListNTS {
        @Override
        public ArrayList<IExpression> toAbstractSyntax(
            ArrayList<IExpression> temp) {
            return temp;
        }
    }

    class FactorNTS extends Production implements IFactorNTS {
        @Override
        public IFactor toAbstractSyntax(Ident ident) {
            return new InitFactor(ident, false);
        }
    }

    class FunDeclNTS extends Production implements IFunDeclNTS {
        @Override
        public ArrayList<StoDecl> toAbstractSyntax() {
            return new ArrayList<>();
        }
    }

    class IfElseNTS extends Production implements IIfElseNTS {
        @Override
        public CpsCmd toAbstractSyntax() {
            return null;
        }
    }

    class ParameterListNTS extends Production implements IParameterListNTS {
        @Override
        public ArrayList<Parameter> toAbstractSyntax() {
            return new ArrayList<>();
        }
    }

    class ParameterNTS extends Production implements IParameterNTS {
        @Override
        public ArrayList<Parameter> toAbstractSyntax(ArrayList<Parameter> temp) {
            return temp;
        }
    }

    class ProcDeclNTS extends Production implements IProcDeclNTS {
        @Override
        public ArrayList<StoDecl> toAbstractSyntax() {
            return new ArrayList<>();
        }
    }

    class Term1NTS extends Production implements ITerm1NTS {
        @Override public IExpression toAbstractSyntax(IExpression expression) {
            return expression;
        }
    }

    class Term2NTS extends Production implements ITerm2NTS {
        @Override public IExpression toAbstractSyntax(IExpression expression) {
            return expression;
        }
    }

    class Term3NTS extends Production implements ITerm3NTS {
        @Override public IExpression toAbstractSyntax(IExpression expression) {
            return expression;
        }
    }

    class Term4NTS extends Production implements ITerm4NTS {
        @Override public IExpression toAbstractSyntax(IExpression expression) {
            return expression;
        }
    }

    class ChangeModeNTS extends Production implements IChangeModeNTS {
        @Override
        public ChangeModes toAbstractSyntax() {
            return null;
        }
    }

    class MechModeNTS extends Production implements IMechModeNTS {
        @Override
        public MechModes toAbstractSyntax() {
            return null;
        }
    }

}
