package virtualMachine;

import virtualMachine.interfaces.IInstructions.*;
import virtualMachine.interfaces.ICodeArray;
import virtualMachine.interfaces.IVirtualMachine;

public class VirtualMachine implements IVirtualMachine {

    private static final String SP_OVER_HP = ""; // needs to be specified

    private static final String EP_OVER_HP = ""; // needs to be specified
    private final Data.IBaseData[] store;
    private IExecInstr[] code; // stores program code
    private int ep; // extreme pointer
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
        ep= 0;
        hp= store.length - 1;
        fp= 0;
        while (pc > -1) {
            code[pc].execute();
        }
    }
    private void loadProgram(ICodeArray code) {
        this.code = new IExecInstr[code.getSize()];
        for (int i = 0; i < code.getSize(); i++) {
            this.code[i] = code.get(i).toExecInstr(this);
        }
    }

    // stop instruction
    public class StopExec extends Stop implements IExecInstr {
        public void execute() {
            pc = -1;
        }
    }

    // monadic instruction
    public class NegIntExec extends NegInt implements IExecInstr {
        public void execute() {
            store[sp - 1] = Data.intInv(store[sp - 1]);
            pc = pc + 1;
        }
    }

    // dyadic instructions

    public class AddIntExec extends AddInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intAdd(store[sp - 1], store[sp]);
            pc = pc + 1;
        }
    }

    public class SubIntExec extends SubInt implements IExecInstr {
        public void execute() {
            sp = sp - 1;
            store[sp - 1] = Data.intSub(store[sp - 1], store[sp]);
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

    // jump instructions

    public class UncondJumpExec extends UncondJump implements IExecInstr {
        public UncondJumpExec(int jumpAddr) {
            super(jumpAddr);
        }

        public void execute() {
            pc = jumpAddr;
        }
    }

    // input (input -> stack) and output (stack -> output) instructions

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

    // load immediate value (value -> stack)
    public class LoadImIntExec extends LoadImInt implements IExecInstr {
        public LoadImIntExec(long value) {
            super(value);
        }

        public void execute() throws ExecutionError {
            // remove following check if use ep
            if (sp > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = Data.intNew(value);
            sp = sp + 1;
            pc = pc + 1;
        }
    }

    // load address relative to frame pointer (address -> stack)
    public class LoadAddrRelExec extends LoadAddrRel implements IExecInstr {
        public LoadAddrRelExec(int relAddress) {
            super(relAddress);
        }

        public void execute() throws ExecutionError {
            // remove following check if use ep
            if (sp > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = Data.intNew(fp + relAddress);
            sp = sp + 1;
            pc = pc + 1;
        }
    }

    // load instruction with address on stack
    // load (inside stack -> top of stack) operation
    public class DerefExec extends Deref implements IExecInstr {
        public void execute() {
            int address = Data.intGet(store[sp - 1]);
            store[sp - 1] = store[address];
            pc = pc + 1;
        }
    }

    // store instruction with address on stack
    // store (top of stack -> inside stack) operation
    public class StoreExec extends Store implements IExecInstr {
        public void execute() {
            int address = Data.intGet(store[sp - 2]);
            store[address] = store[sp - 1];
            sp = sp - 2;
            pc = pc + 1;
        }
    }

    // stack instruction
    public class DupExec extends Dup implements IExecInstr {
        public void execute() throws ExecutionError {
            // remove following check if use ep
            if (sp > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = store[sp - 1].copy();
            sp = sp + 1;
            pc = pc + 1;
        }
    }

    // routine operations
    public class AllocBlockExec extends AllocBlock implements IExecInstr {
        public AllocBlockExec(int size) {
            super(size);
        }

        public void execute() throws ExecutionError {
            sp = sp + size;
            // remove following check if use ep
            if (sp > hp + 1) {
                throw new ExecutionError(SP_OVER_HP);
            }
            pc = pc + 1;
        }
    }

    public class AllocStackExec extends AllocStack implements IExecInstr {
        public AllocStackExec(int maxSize) {
            super(maxSize);
        }

        public void execute() throws ExecutionError {
            ep = sp + maxSize;
            if (ep > hp + 1) {
                throw new ExecutionError(EP_OVER_HP);
            }
            pc = pc + 1;
        }
    }

    public class CallExec extends Call implements IExecInstr {
        public CallExec(int routAddress) {
            super(routAddress);
        }

        public void execute() throws ExecutionError {
            // remove following check if use ep
            if (sp + 2 > hp) {
                throw new ExecutionError(SP_OVER_HP);
            }
            store[sp] = Data.intNew(fp);
            store[sp + 1] = Data.intNew(ep);
            store[sp + 2] = Data.intNew(pc);
            fp = sp;
            sp = sp + 3;
            pc = routAddress;
        }
    }

    public class ReturnExec extends Return implements IExecInstr {
        public ReturnExec(int size) {
            super(size);
        }

        public void execute() throws ExecutionError {
            sp = fp - size;
            pc = Data.intGet(store[fp + 2]) + 1;
            ep = Data.intGet(store[fp + 1]);
            fp = Data.intGet(store[fp]);
            if (ep > hp + 1) {
                throw new ExecutionError(EP_OVER_HP);
            }
        }
    }

}
