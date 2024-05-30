package elements;

public enum PreciousMetal implements Valuable {
    GOLD("🟡", "🟨");
    private final String roundSymbol;
    private final String squareSymbol;

    PreciousMetal(String roundSymbol, String squareSymbol) {
        this.roundSymbol = roundSymbol;
        this.squareSymbol = squareSymbol;
    }

    public String getRoundSymbol() {
        return roundSymbol;
    }

    public String getSquareSymbol() {
        return squareSymbol;
    }
}
