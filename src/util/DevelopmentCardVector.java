package util;

import elements.Gem;

public class DevelopmentCardVector extends ResourceVector {
    public DevelopmentCardVector(){ super(); }
    public DevelopmentCardVector(byte[] amounts) { super(amounts); }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Gem.values().length; i++) {
            result.append(String.format("%s: %d; ", this.getUnits()[i].getSquareSymbol(), this.getAmounts()[i]));
        }
        return result.toString();
    }
}
