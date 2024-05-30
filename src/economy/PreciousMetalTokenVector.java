package economy;

import org.jetbrains.annotations.NotNull;

public class PreciousMetalTokenVector extends ValuableVector<PreciousMetal> {
    public PreciousMetalTokenVector(PreciousMetal @NotNull [] values) {
        super(values);
    }

    public void add(PreciousMetalTokenVector preciousMetalTokenVector) {
        super.add(preciousMetalTokenVector);
    }

    public boolean isGreaterOrEqual(PreciousMetalTokenVector preciousMetalTokenVector) {
        return super.isGreaterOrEqual(preciousMetalTokenVector);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Gem.values().length; i++) {
            result.append(String.format("%s: %d; ", this.getUnits()[i].getSymbol(false), this.getAmounts()[i]));
        }
        return result.toString();
    }
}
