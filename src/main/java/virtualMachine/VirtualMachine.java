package virtualMachine;

import virtualMachine.interfaces.IInstructions.*;
import virtualMachine.interfaces.ICodeArray;
import virtualMachine.interfaces.IVirtualMachine;

public class VirtualMachine implements IVirtualMachine {

    private static final String SP_OVER_HP = "sp over hp";
    private final Data.IBaseData[] store;
    private IExecInstr[] code; // speichert den Programm-Code
    private int pc; // program counter
    private int sp; // stack pointer
    private int fp; // frame pointer
    private int hp; // heap pointer

    public VirtualMachine(ICodeArray code, int storeSize) throws ExecutionError {
        loadProgram(code);
        store = new Data.IBaseData[storeSize];
        execute();
    }

    private void execute() throws ExecutionError {
        pc= 0;
        sp= 0;
        hp= store.length - 1;
        fp= 0;
        while (pc > -1) {
            code[pc].execute(); // an der Stelle code[pc] steht eine Instruktion, die ausgeführt wird
        }
    }
    private void loadProgram(ICodeArray code) {
        this.code = new IExecInstr[code.getSize()];
        for (int i = 0; i < code.getSize(); i++) {
            this.code[i] = code.get(i).toExecInstr(this);
        }
    }

    // Stop hält die while-Schleife in der execute()-Methode an, indem pc auf -1 gesetzt wird.
    public class StopExec extends Stop implements IExecInstr {
        public void execute() {
            pc = -1;
        }
    }

    // Monadische Instruktion
    public class NegIntExec extends NegInt implements IExecInstr {
        public void execute() {
            store[sp - 1] = Data.intInv(store[sp - 1]);
            pc = pc + 1;
        }
    }

    // Dyadische Instruktionen

    public class AddIntExec extends AddInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intAdd(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class SubIntExec extends SubInt implements IExecInstr {
        /* Die Werte, die man subtrahieren möchte, werden auf den Stack gelegt.
           Die Werte werden mithilfe der Integer-Subtraktions-Methode in Data subtrahiert.
           Das Resultat wird auf sp - 1 abgespeichert. Der Stackpointer wird um 1 verringert.
           Der Programmcounter wird um 1 erhöht, damit der pc zur nächsten Instruktion kommt. */
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intSub(store[sp - 1], store[sp]); // store[sp] ist die oberste Stack-Position
            pc = pc + 1;
        }
    }

    public class MultIntExec extends MultInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intMult(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class DivTruncIntExec extends DivTruncInt implements IExecInstr {
        public void execute() throws ExecutionError {
            sp = sp - 1;
            store[sp - 1] = Data.intDivTrunc(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class ModTruncIntExec extends ModTruncInt implements IExecInstr {
        public void execute() throws ExecutionError {
            sp = sp - 1;
            store[sp - 1] = Data.intModTrunc(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class EqIntExec extends EqInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intEQ(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class NeIntExec extends NeInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intNE(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class GtIntExec extends GtInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intGT(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class GeIntExec extends GeInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intGE(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class LtIntExec extends LtInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intLT(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class LeIntExec extends LeInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intLE(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class UncondJumpExec extends UncondJump implements IExecInstr {
        public UncondJumpExec(int jumpAddr) {
            super(jumpAddr);
        }

        // pc wird auf die Jump-Addresse gesetzt.
        public void execute() {
            pc = jumpAddr;
        }
    }

    public class CondJumpExec extends CondJump implements IExecInstr {
        public CondJumpExec(int jumpAddr) {
            super(jumpAddr);
        }

        public void execute() {
            sp = sp - 1;
            pc = (Data.boolGet(store[sp])) ? pc + 1 : jumpAddr;
            // Falls der Integer-Wert als "true" interpretiert wird, springt der pc auf die nächste Instruktion.
            // Ansonsten springt er auf die Jump-Adresse, die vom Compiler erzeugt wurde.
        }
    }

    // Input- und Output-Instruktionen

    public class InputBoolExec extends InputBool implements IExecInstr {
        public InputBoolExec(String indicator) {
            super(indicator);
        }

        public void execute() throws ExecutionError {
            System.out.print("? " + indicator + " : bool = ");
            boolean input = InputUtility.readBool();
            int address = Data.intGet(store[sp - 1]);
            store[address] = Data.boolNew(input);
            sp = sp - 1;
            pc = pc + 1;
        }
    }

    public class OutputBoolExec extends OutputBool implements IExecInstr {
        public OutputBoolExec(String indicator) {
            super(indicator);
        }

        public void execute() {
            sp = sp - 1;
            boolean output = Data.boolGet(store[sp]);
            System.out.println("! " + indicator + " : bool = " + output);
            pc = pc + 1;
        }
    }

    // LoadImInt lädt den unmittelbaren Wert.
    public class LoadImIntExec extends LoadImInt implements IExecInstr {
        public LoadImIntExec(long value) {
            super(value);
        }

        public void execute() throws ExecutionError {
            if (sp > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = Data.intNew(value);
            sp = sp + 1;
            pc = pc + 1;
        }
    }

    // LoadAddrRel lädt die Adresse relativ zum Frame-Pointer.
    public class LoadAddrRelExec extends LoadAddrRel implements IExecInstr {
        public LoadAddrRelExec(int relAddress) {
            super(relAddress);
        }

        public void execute() throws ExecutionError {
            if (sp > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = Data.intNew(fp + relAddress);
            sp = sp + 1;
            pc = pc + 1;
        }
    }

    // Eine Dereferenz vertauscht eine Adresse mit einem Inhalt.
    public class DerefExec extends Deref implements IExecInstr {
        public void execute() {
            int address = Data.intGet(store[sp - 1]);
            store[sp - 1] = store[address];
            pc = pc + 1;
        }
    }

    // Store speichert die Instruktion mit Adresse auf dem Stack.
    public class StoreExec extends Store implements IExecInstr {
        public void execute() {
            int address = Data.intGet(store[sp - 2]);
            store[address] = store[sp - 1];
            sp = sp - 2;
            pc = pc + 1;
        }
    }

    // Dup dupliziert die Spitze vom Stack.
    public class DupExec extends Dup implements IExecInstr {
        public void execute() throws ExecutionError {
            if (sp > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = store[sp - 1].copy();
            sp = sp + 1;
            pc = pc + 1;
        }
    }

    // AllockBlock vergrössert den Stackpointer / reserviert Speicherplatz für die globalen Speicherplätze.
    public class AllocBlockExec extends AllocBlock implements IExecInstr {
        public AllocBlockExec(int size) {
            super(size); // Grösse wird durch den Compiler bestimmt.
        }

        public void execute() throws ExecutionError {
            sp = sp + size;
            if (sp > hp + 1) {
                throw new ExecutionError(SP_OVER_HP);
            }
            pc = pc + 1;
        }
    }

    // Call wird benötigt, wenn man eine Routine aufruft.
    public class CallExec extends Call implements IExecInstr {
        public CallExec(int routAddress) {
            super(routAddress);
        }

        public void execute() throws ExecutionError {
            if (sp + 2 > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = Data.intNew(fp);
            store[sp + 2] = Data.intNew(pc);
            fp = sp;
            sp = sp + 3;
            pc = routAddress;
        }
    }

    // Return wird benötigt, wenn man eine Routine verlässt.
    public class ReturnExec extends Return implements IExecInstr {
        public ReturnExec(int size) {
            super(size);
        }

        public void execute() throws ExecutionError {
            sp = fp - size;
            pc = Data.intGet(store[fp + 2]) + 1;
            fp = Data.intGet(store[fp]);
        }
    }

}
