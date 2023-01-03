package virtualMachine.interfaces;

import virtualMachine.interfaces.IVirtualMachine.ExecutionError;
import virtualMachine.VirtualMachine;

public interface IInstructions {

    // Ausführbare Form von Instruktionen
    interface IExecInstr extends IInstr {
        void execute() throws ExecutionError;
    }

    // Nicht-ausführbare Form von Instruktionen
    interface IInstr {
        IExecInstr toExecInstr(VirtualMachine vm);
    }

    class Stop implements IInstr {
        public String toString() {
            return "Stop";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new StopExec();
        }
    }

    class NegInt implements IInstr {
        public String toString() {
            return "NegInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new NegIntExec();
        }
    }

    // dyadic instructions
    class AddInt implements IInstr {
        public String toString() {
            return "AddInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new AddIntExec();
        }
    }

    class SubInt implements IInstr {
        public String toString() {
            return "SubInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new SubIntExec();
        }
    }

    class MultInt implements IInstr {
        public String toString() {
            return "MultInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new MultIntExec();
        }
    }

    class DivTruncInt implements IInstr {
        public String toString() {
            return "DivTruncInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new DivTruncIntExec();
        }
    }

    class ModTruncInt implements IInstr {
        public String toString() {
            return "ModTruncInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new ModTruncIntExec();
        }
    }

    class EqInt implements IInstr {
        public String toString() {
            return "EqInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new EqIntExec();
        }
    }

    class NeInt implements IInstr {
        public String toString() {
            return "NeInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new NeIntExec();
        }
    }

    class GtInt implements IInstr {
        public String toString() {
            return "GtInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new GtIntExec();
        }
    }

    class GeInt implements IInstr {
        public String toString() {
            return "GeInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new GeIntExec();
        }
    }

    class LtInt implements IInstr {
        public String toString() {
            return "LtInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new LtIntExec();
        }
    }

    class LeInt implements IInstr {
        public String toString() {
            return "LeInt";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new LeIntExec();
        }
    }

    class UncondJump implements IInstr {
        protected int jumpAddr;

        public UncondJump(int jumpAddr) {
            this.jumpAddr = jumpAddr;
        }

        public String toString() {
            return "UncondJump(" + jumpAddr + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new UncondJumpExec(jumpAddr);
        }
    }

    class CondJump implements IInstr {
        protected int jumpAddr;

        public CondJump(int jumpAddr) {
            this.jumpAddr = jumpAddr;
        }

        public String toString() {
            return "CondJump(" + jumpAddr + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new CondJumpExec(jumpAddr);
        }
    }

    class InputBool implements IInstr {
        protected String indicator;

        public InputBool(String indicator) {
            this.indicator = indicator;
        }

        public String toString() {
            return "InputBool(\"" + indicator + "\")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new InputBoolExec(indicator);
        }
    }

    class OutputBool implements IInstr {
        protected String indicator;

        public OutputBool(String indicator) {
            this.indicator = indicator;
        }

        public String toString() {
            return "OutputBool(\"" + indicator + "\")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new OutputBoolExec(indicator);
        }
    }

    class LoadImInt implements IInstr {
        protected long value;

        public LoadImInt(long value) {
            this.value = value;
        }

        public String toString() {
            return "LoadImInt(" + value + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new LoadImIntExec(value);
        }
    }

    class LoadAddrRel implements IInstr {
        protected int relAddress;

        public LoadAddrRel(int relAddress) {
            this.relAddress = relAddress;
        }

        public String toString() {
            return "LoadAddrRel(" + relAddress + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new LoadAddrRelExec(relAddress);
        }
    }

    class Deref implements IInstr {
        public String toString() {
            return "Deref";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new DerefExec();
        }
    }

    class Store implements IInstr {
        public String toString() {
            return "Store";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new StoreExec();
        }
    }

    class Dup implements IInstr {
        public String toString() {
            return "Dup";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new DupExec();
        }
    }

    class AllocBlock implements IInstr {
        protected int size;

        public AllocBlock(int size) {
            this.size = size;
        }

        public String toString() {
            return "AllocBlock(" + size + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new AllocBlockExec(size);
        }
    }

    class Call implements IInstr {
        protected int routAddress;

        public Call(int routAddress) {
            this.routAddress = routAddress;
        }

        public String toString() {
            return "Call(" + routAddress + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new CallExec(routAddress);
        }
    }

    class Return implements IInstr {
        protected int size;

        public Return(int size) {
            this.size = size;
        }

        public String toString() {
            return "Return(" + size + ")";
        }

        public IExecInstr toExecInstr(VirtualMachine vm) {
            return vm.new ReturnExec(size);
        }
    }



}
