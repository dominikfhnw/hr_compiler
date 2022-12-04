package concreteSyntaxTree.interfaces;

import abstractSyntaxTree.interfaces.ICmd;
import java.util.ArrayList;

public interface ICpsCmdNTS extends IProduction {

    ArrayList<ICmd> toAbstractSyntax(ArrayList<ICmd> temp);

}
