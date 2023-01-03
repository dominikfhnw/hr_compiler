package virtualMachine.interfaces;

import virtualMachine.interfaces.IInstructions.IInstr;

public interface ICodeArray {

    class CodeTooSmallError extends Exception { }

    void put(int loc, IInstr instr) throws CodeTooSmallError;

    void resize();

    String toString();

    int getSize();

    IInstr get(int loc);

    void fromString();
}
