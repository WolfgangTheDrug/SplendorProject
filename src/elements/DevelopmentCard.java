package elements;

import economy.Gem;
import economy.GemTokenVector;

import java.util.Map;

public class DevelopmentCard {
    private final byte level;
    private final byte score;
    private final Gem bonus;
    private final GemTokenVector price;
    private boolean isRevealed;

    public DevelopmentCard(byte level, byte score, Gem bonus, GemTokenVector price) {
        this.level = level;
        this.score = score;
        this.bonus = bonus;
        this.price = price;
        this.isRevealed = false;
    }

    public DevelopmentCard(DevelopmentCardReader reader) {
        this(
            reader.getLevel(),
            reader.getScore(),
            reader.getBonus(),
            reader.getPrice()
        );
    }

    public byte getScore() {
        return score;
    }

    public Gem getBonus() {
        return bonus;
    }

    public GemTokenVector getPrice() {
        return price;
    }

    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    public void reveal() {
        this.isRevealed = true;
    }

    @Override
    public String toString() {
        if (this.isRevealed) {
            return String.format(
                    "[%s | %d | %s]",
                    this.bonus.toString(),
                    this.score,
                    this.price.toString()
            );
        } else {
            return String.format(
                    "[--Level %d--]",
                    this.level
            );
        }
    }
}
