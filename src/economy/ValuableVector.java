package economy;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ValuableVector<V extends Valuable> {
    private int[] amounts;
    private final V[] units;

    @Contract(pure = true)
    public ValuableVector(V @NotNull [] values){
        this.amounts = new int[values.length];
        this.units = values;
    }

    public int[] getAmounts() {
        return amounts;
    }

    public void setAmounts(int[] amounts) {
        this.amounts = amounts;
    }

    public Valuable[] getUnits() {
        return units;
    }

    public ValuableVector<V> add(ValuableVector<V> valuableVector) {
        ValuableVector<V> sum = new ValuableVector<>(this.units);
        for(int i = 0; i < this.getAmounts().length; i++) {
            sum.getAmounts()[i] = this.getAmounts()[i] + valuableVector.getAmounts()[i];
        }
        return sum;
    }

    public boolean isGreaterOrEqual(ValuableVector<V> valuableVector) {
        boolean result = true;
        for(int i = 0; i < this.getAmounts().length; i++) {
            if (this.getAmounts()[i] < valuableVector.getAmounts()[i]){
                result = false;
                break;
            }
        }
        return result;
    }

}
