package util;

import elements.Gem;

public class TokenVector extends ResourceVector {
    public TokenVector(){
        super();
    }

    public TokenVector(byte[] amounts){
        super(amounts);
    }

    public void add(TokenVector tokenVector) {
        super.add(tokenVector);
    }

    public boolean isGreaterOrEqual(TokenVector tokenVector) {
        return super.isGreaterOrEqual(tokenVector);
    }
    public void subtract(TokenVector tokenVector) {
        for(int i = 0; i < this.getAmounts().length; i++) {
            this.getAmounts()[i] -= tokenVector.getAmounts()[i];
        }
    }

    public static TokenVector fromGems(Gem...gems) {
        TokenVector result = new TokenVector();

        for (Gem gem : gems) {
            for (int j = 0; j < Gem.values().length; j++) {
                if (gem == Gem.values()[j]) {
                    result.getAmounts()[j] += 1;
                }
            }
        }
        return result;
    }

    public static TokenVector fromGemAmounts(byte[] amounts) {
        return new TokenVector(amounts);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Gem.values().length; i++) {
            result.append(String.format("%s: %d; ", this.getUnits()[i].getRoundSymbol(), this.getAmounts()[i]));
        }
        return result.toString();
    }


}
