package economy;

import org.jetbrains.annotations.NotNull;

class GemVector extends ValuableVector<Gem> {
    public GemVector(){
        super(Gem.values());
    }
    public GemVector(Gem @NotNull [] values) {
        super(values);
    }

    public int getNorm() {
        int norm = 0;
        for(int i = 0; i < this.getAmounts().length; i++) {
            norm += this.getAmounts()[i]*scalar;
        }

        return norm;
    }

    @Override
    public ValuableVector<Gem> add(ValuableVector<Gem> valuableVector) {
        GemVector sum = new GemVector();
        for(int i = 0; i < this.getAmounts().length; i++) {
            sum.getAmounts()[i] = this.getAmounts()[i] + valuableVector.getAmounts()[i];
        }
        return sum;
    }


}
