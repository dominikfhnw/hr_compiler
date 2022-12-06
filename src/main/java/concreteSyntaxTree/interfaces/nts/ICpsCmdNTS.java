package concreteSyntaxTree.interfaces.nts;

import abstractSyntaxTree.interfaces.ICmd;
import concreteSyntaxTree.interfaces.IProduction;

import java.util.ArrayList;

public interface ICpsCmdNTS extends IProduction {

    ArrayList<ICmd> toAbstractSyntax(ArrayList<ICmd> temp);

}
