package economy;

public class GemCardVector extends GemVector {
    public GemCardVector(){
        super(Gem.values());
    }

    public GemCardVector(int[] amounts) {
        super(Gem.values());
        this.setAmounts(amounts);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Gem.values().length; i++) {
            result.append(String.format("%s: %d; ", this.getUnits()[i].getSymbol(true), this.getAmounts()[i]));
        }
        return result.toString();
    }
}
