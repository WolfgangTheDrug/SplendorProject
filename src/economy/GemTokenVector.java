package economy;

import org.jetbrains.annotations.NotNull;

public class GemTokenVector extends GemVector {
    public GemTokenVector(){
        super(Gem.values());
    }

    public GemTokenVector subtract(GemTokenVector gemTokenVector) {
        GemTokenVector difference = new GemTokenVector();
        for(int i = 0; i < this.getAmounts().length; i++) {
            difference.getAmounts()[i] = this.getAmounts()[i] - gemTokenVector.getAmounts()[i];
        }
        return difference;
    }

    public GemTokenVector multiply(int scalar) {
        GemTokenVector product = new GemTokenVector();
        for(int i = 0; i < this.getAmounts().length; i++) {
            product.getAmounts()[i] = this.getAmounts()[i]*scalar;
        }
        return product;
    }


    public static @NotNull GemTokenVector fromGems(Gem @NotNull ...gems) {
        GemTokenVector result = new GemTokenVector();

        for (Gem gem : gems) {
            for (int j = 0; j < Gem.values().length; j++) {
                if (gem == Gem.values()[j]) {
                    result.getAmounts()[j] += 1;
                }
            }
        }
        return result;
    }

    public static @NotNull GemTokenVector fromGemAmounts(int[] amounts) {
        GemTokenVector result = new GemTokenVector();
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
