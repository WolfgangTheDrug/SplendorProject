package elements;

import economy.Gem;
import economy.GemCardVector;
import economy.GemTokenVector;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final byte id;
    private final String name;
    private byte score;
    private byte goldTokens;
    private final GemTokenVector gemsFromTokens;
    private final GemCardVector gemsFromDevelopmentCards;
    private final List<DevelopmentCard> hand;
    private final List<NobleTile> nobleTiles;

    public Player(byte id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.goldTokens = 0;
        this.gemsFromTokens = new GemTokenVector();
        this.gemsFromDevelopmentCards = new GemCardVector();
        this.hand = new ArrayList<>();
        this.nobleTiles = new ArrayList<>();
    }

    public Player(byte id) {
        this(id, "Player " + id);
    }

    public byte getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public GemTokenVector getGemsFromTokens() {
        return gemsFromTokens;
    }

    public GemCardVector getGemsFromDevelopmentCards() {
        return gemsFromDevelopmentCards;
    }

    public List<DevelopmentCard> getHand() {
        return hand;
    }

    public List<NobleTile> getNobleTiles() {
        return nobleTiles;
    }

    private void drawTokens(Gem...gemTokens){
        this.gemsFromTokens.add(GemTokenVector.fromGems(gemTokens));
    }

    private void draw2Tokens(Gem gem) {
        this.drawTokens(gem, gem);
    }

    private void draw3Tokens(Gem gem1, Gem gem2, Gem gem3) {
        this.drawTokens(gem1, gem2, gem3);
    }

    private void putTokensAway(byte[] gemTokenAmounts) {
        this.gemsFromTokens.subtract(GemTokenVector.fromGemAmounts(gemTokenAmounts));
    }

    private void drawGoldToken(){
        this.goldTokens += 1;
    }

    private void putGoldTokensAway() {
        this.goldTokens -= 1;
    }

}
