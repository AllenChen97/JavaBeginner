package B_Advanced.Concurrency.d_ConcurrentClass.b_Atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicDoubleBalance {

    private AtomicReference<Double> valueHolder = new AtomicReference<>();
    private volatile Double value;

    public AtomicDoubleBalance(Double doubleValue) {
        valueHolder.set(doubleValue);
        value = valueHolder.get();

    }

    public boolean incrementAndGet(Double addvalue) {
        for (; ; ) {
            value = valueHolder.get();
            Double next = value + addvalue;
            if (next < 0) {
                return false;
            }
            if (valueHolder.compareAndSet(value, next)) {
                return true;
            }
        }
    }

    public double getValue() {
        return valueHolder.get();
    }
}