package economy;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

abstract public class ValuableVector<V extends Valuable> {
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

    public void add(ValuableVector<V> valuableVector) {
        for(int i = 0; i < this.amounts.length; i++) {
            this.amounts[i] += valuableVector.amounts[i];
        }
    }

    public boolean isGreaterOrEqual(ValuableVector<V> valuableVector) {
        boolean result = true;
        for(int i = 0; i < this.amounts.length; i++) {
            if (this.amounts[i] < valuableVector.amounts[i]){
                result = false;
                break;
            }
        }
        return result;
    }

}
