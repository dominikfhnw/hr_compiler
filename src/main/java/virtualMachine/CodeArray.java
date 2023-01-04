package virtualMachine;

import virtualMachine.interfaces.ICodeArray;
import virtualMachine.interfaces.IInstructions.IInstr;

public class CodeArray implements ICodeArray {
    private IInstr[] code;
    private int size;

    public CodeArray(int size) {
        this.code = new IInstr[size];
        this.size = size;
    }

    @Override
    public void put(int local, IInstr instr) throws CodeTooSmallError {
        if (local >= code.length) {
            code[local] = instr;
        } else {
            throw new CodeTooSmallError();
        }
    }

    @Override
    public void resize() {
        int newSize = 0;
        while (newSize < code.length  && code[newSize] != null) {
                newSize++;
        }
        IInstr[] newCode = new IInstr[newSize];
        for (int i = 0; i < newSize; i++) {
            newCode[i] = code[i];
        }
        code = newCode;
        size = newSize;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public IInstr get(int local) {
        return code[local];
    }

    @Override
    public void fromString() {
        // TODO: implement
    }
}
