package elements;

import economy.GemCardVector;

public class NobleTile {
    private final int score;
    private final GemCardVector price;

    public NobleTile(int score, GemCardVector price) {
        this.score = score;
        this.price = price;
    }

    public int getScore() {
        return score;
    }

    public GemCardVector getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return String.format("[%d | %s]", this.score, this.price.toString());
    }
}
