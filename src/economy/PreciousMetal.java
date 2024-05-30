package economy;

public enum PreciousMetal implements Valuable {
    GOLD("🟡");
    private final String roundSymbol;

    PreciousMetal(String roundSymbol) {
        this.roundSymbol = roundSymbol;
    }

    @Override
    public String getSymbol(boolean isSquare) {
        return roundSymbol;
    }

    public String getSymbol() {
        return getSymbol(true);
    }
}
