package economy;

import org.jetbrains.annotations.NotNull;

abstract class GemVector extends ValuableVector<Gem> {
    public GemVector(){
        super(Gem.values());
    }
    public GemVector(Gem @NotNull [] values) {
        super(values);
    }

    public void add(GemVector gemVector) {
        super.add(gemVector);
    }

    public boolean isGreaterOrEqual(GemVector gemVector) {
        return super.isGreaterOrEqual(gemVector);
    }

    abstract public String toString();

}
