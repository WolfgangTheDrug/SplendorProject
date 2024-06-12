package economy;

import org.jetbrains.annotations.NotNull;

public class PreciousMetalTokenVector extends ValuableVector<PreciousMetal> {
    public PreciousMetalTokenVector() {
        super(PreciousMetal.values());
    }

    public void subtract(PreciousMetalTokenVector preciousMetalTokenVector) {
        for(int i = 0; i < this.getAmounts().length; i++) {
            this.getAmounts()[i] -= preciousMetalTokenVector.getAmounts()[i];
        }
    }

    public static @NotNull PreciousMetalTokenVector fromMetals(PreciousMetal @NotNull ...preciousMetals) {
        PreciousMetalTokenVector result = new PreciousMetalTokenVector();

        for (PreciousMetal preciousMetal : preciousMetals) {
            for (int j = 0; j < PreciousMetal.values().length; j++) {
                if (preciousMetal == PreciousMetal.values()[j]) {
                    result.getAmounts()[j] += 1;
                }
            }
        }
        return result;
    }

    public static @NotNull PreciousMetalTokenVector fromMetalAmounts(int[] amounts) {
        PreciousMetalTokenVector result = new PreciousMetalTokenVector();
        result.setAmounts(amounts);
        return result;
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
