package virtualMachine;

import virtualMachine.interfaces.IVirtualMachine;

public class Data {

    interface IBaseData {
        IBaseData copy();
    }

    static class IntData implements IBaseData {
        public static final long MAX_VALUE = Integer.MAX_VALUE;
        public static final long MIN_VALUE = Integer.MIN_VALUE;

        private final long intData;

        IntData(long intData) {
            if (intData > MAX_VALUE || intData < MIN_VALUE) {
                throw new RuntimeException("Int-Overflow.");
            }
            this.intData = intData;
        }

        long getData() {
            return intData;
        }

        public IntData copy() {
            return intCopy(this);
        }

        @Override
        public String toString() {
            return "IntData: " + intData;
        }
    }

    static class FloatData implements IBaseData {
        private final float f;

        FloatData(float f) {
            this.f = f;
        }

        float getData() {
            return f;
        }

        public FloatData copy() {
            return floatCopy(this);
        }
    }

    static IntData intNew(long intData) {
        return new IntData(intData);
    }

    static int intGet(IBaseData a) {
        return (int) ((IntData) a).getData();
    }

    static IntData intCopy(IBaseData a) {
        return intNew(intGet(a));
    }

    static IntData intInv(IBaseData a) {
        return intNew(-intGet(a));
    }

    static IntData intAdd(IBaseData a, IBaseData b) {
        return intNew(intGet(a) + intGet(b));
    }

    static IntData intSub(IBaseData a, IBaseData b) {
        return intNew(intGet(a) - intGet(b));
    }

    static IntData intMult(IBaseData a, IBaseData b) {
        return intNew((long) intGet(a) * intGet(b));
    }

    static IntData intDivTrunc(IBaseData a, IBaseData b) throws IVirtualMachine.ExecutionError {
        try {
            return intNew(intGet(a) / intGet(b));
        } catch (ArithmeticException e) {
            throw new VirtualMachine.ExecutionError("Integer division by zero.");
        }
    }

    static IntData intModTrunc(IBaseData a, IBaseData b) throws IVirtualMachine.ExecutionError {
        try {
            return intNew(intGet(a) % intGet(b));
        } catch (ArithmeticException e) {
            throw new VirtualMachine.ExecutionError("Integer remainder by zero.");
        }
    }

    static IntData intEQ(IBaseData a, IBaseData b) {
        return boolNew(intGet(a) == intGet(b));
    }

    static IntData intNE(IBaseData a, IBaseData b) {
        return boolNew(intGet(a) != intGet(b));
    }

    static IntData intGT(IBaseData a, IBaseData b) {
        return boolNew(intGet(a) > intGet(b));
    }

    static IntData intLT(IBaseData a, IBaseData b) {
        return boolNew(intGet(a) < intGet(b));
    }

    static IntData intGE(IBaseData a, IBaseData b) {
        return boolNew(intGet(a) >= intGet(b));
    }

    static IntData intLE(IBaseData a, IBaseData b) {
        return boolNew(intGet(a) <= intGet(b));
    }

    // bool data
    // booleans -> integers
    static IntData boolNew(boolean b) {
        return intNew(b ? 1 : 0);
    }

    static boolean boolGet(IBaseData a) {
        return ((IntData) a).getData() != 0;
    }

    static IntData boolInv(IBaseData a) {
        return boolNew(intGet(a) != 1);
    }

    static IntData boolAnd(IBaseData a, IBaseData b) {
        return boolNew(boolGet(a) & boolGet(b));
    }

    static IntData boolOr(IBaseData a, IBaseData b) {
        return boolNew(boolGet(a) | boolGet(b));
    }

    static IntData boolCAnd(IBaseData a, IBaseData b) {
        return boolNew(boolGet(a) && boolGet(b));
    }

    static IntData boolCOr(IBaseData a, IBaseData b) {
        return boolNew(boolGet(a) || boolGet(b));
    }

    static FloatData floatNew(float f) {
        return new FloatData(f);
    }

    static float floatGet(IBaseData a) {
        return ((FloatData) a).getData();
    }

    static FloatData floatCopy(IBaseData a) {
        return floatNew(floatGet(a));
    }

    static FloatData floatInv(IBaseData a) {
        return floatNew(-floatGet(a));
    }
}
