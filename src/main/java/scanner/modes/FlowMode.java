package scanner.modes;

import scanner.enums.Terminals;
import scanner.Base;

public class FlowMode extends Base {
    enum FlowModes {
        IN,
        INOUT,
        OUT
    }

    private final FlowModes flowMode;

    FlowMode(FlowModes flowMode) {
        super(Terminals.FLOWMODE);
        this.flowMode = flowMode;
    }

    public FlowModes getFlowMode() {
        return flowMode;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + "," + getFlowMode().toString() + ")";
    }
}
