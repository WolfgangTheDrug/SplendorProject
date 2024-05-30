package elements;

public enum Gem implements Valuable{
    DIAMOND("⚪️", "⬜️"),
    ONYX("⚫️", "⬛️"),
    SAPPHIRE("🔵", "🟦"),
    RUBY("🔴", "🟥"),
    EMERALD("🟢", "🟩");

    private final String roundSymbol;
    private final String squareSymbol;

    Gem(String roundSymbol, String squareSymbol) {
        this.roundSymbol = roundSymbol;
        this.squareSymbol = squareSymbol;
    }

    public String getRoundSymbol()  {
        return roundSymbol;
    }

    public String getSquareSymbol() {
        return squareSymbol;
    }
}
