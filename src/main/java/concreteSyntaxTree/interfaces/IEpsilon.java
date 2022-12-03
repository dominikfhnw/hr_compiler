package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.Parameter;
import abstractSyntaxTree.StoDecl;
import abstractSyntaxTree.interfaces.IDecl;
import concreteSyntaxTree.Production;
import abstractSyntaxTree.interfaces.ICmd;

import java.util.ArrayList;

public interface IEpsilon {

    class GlobalNTS extends Production implements IGlobalNTS {
        @Override
        public ArrayList<IDecl> toAbstractSyntax() {
            return new ArrayList<>();
        }
    }

    class CpsDeclNTS extends Production implements ICpsDeclNTS {
        @Override
        public ArrayList<IDecl> toAbstractSyntax(ArrayList<IDecl> temp) {
            return temp;
        }
    }

    class CpsCmdNTS extends Production implements ICpsCmdNTS {
        @Override
        public ArrayList<ICmd> toAbstractSyntax(
            ArrayList<ICmd> temp) {
            return temp;
        }
    }

    class CpsStoDeclNTS extends Production implements ICpsStoDeclNTS {
        @Override
        public ArrayList<StoDecl> toAbstractSyntax(ArrayList<StoDecl> temp) {
            return temp;
        }
    }

    class FunDeclNTS extends Production implements IFunDeclNTS {
        @Override
        public ArrayList<StoDecl> toAbstractSyntax() {
            return new ArrayList<>();
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

}
