package elements;

import economy.Gem;

import java.util.Map;

abstract public class DevelopmentCardReader {
    private final byte level;
    private final byte score;
    private final Gem bonus;
    private final Map<Gem, Byte> price;


    public DevelopmentCardReader(byte level, byte score, Gem bonus, Map<Gem, Byte> price) {
        this.level = level;
        this.score = score;
        this.bonus = bonus;
        this.price = price;
    }

    public byte getScore() {
        return this.score;
    }

    public Gem getBonus() {
        return this.bonus;
    }

    public Map<Gem, Byte> getPrice() {
        return this.price;
    }

    public byte getLevel() {
        return this.level;
    }
}
