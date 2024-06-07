package economy;

public enum Gem implements Valuable {
    DIAMOND("⚪️", "⬜️"),
    SAPPHIRE("🔵", "🟦"),
    EMERALD("🟢", "🟩"),
    RUBY("🔴", "🟥"),
    ONYX("⚫️", "⬛️");

    private final String roundSymbol;
    private final String squareSymbol;

    Gem(String roundSymbol, String squareSymbol) {
        this.roundSymbol = roundSymbol;
        this.squareSymbol = squareSymbol;
    }

    private String getRoundSymbol()  {
        return roundSymbol;
    }

    private String getSquareSymbol() {
        return squareSymbol;
    }

    @Override
    public String getSymbol(boolean isSquare) {
        return isSquare ? getSquareSymbol() : getRoundSymbol();
    }

}
