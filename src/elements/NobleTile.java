package elements;

import util.DevelopmentCardVector;

public class NobleTile {
    private final byte score;
    private final DevelopmentCardVector price;

    public NobleTile(byte score, DevelopmentCardVector price) {
        this.score = score;
        this.price = price;
    }

    public byte getScore() {
        return score;
    }

    public DevelopmentCardVector getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return String.format("[%d | %s]", this.score, this.price.toString());
    }
}
