package virtualMachine.interfaces;

public interface IVirtualMachine {

    // Error indicates that the program cannot be executed (e.g. division by zero)
    class ExecutionError extends Exception {
        public ExecutionError(String errorMessage) {
            super("Execution error: " + errorMessage);
        }
    }
}
