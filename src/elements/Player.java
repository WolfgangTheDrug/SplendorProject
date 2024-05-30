package elements;

import util.DevelopmentCardVector;
import util.TokenVector;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final byte id;
    private final String name;
    private byte score;
    private byte goldTokens;
    private final TokenVector gemsFromTokens;
    private final DevelopmentCardVector gemsFromDevelopmentCards;
    private final List<DevelopmentCard> hand;
    private final List<NobleTile> nobleTiles;

    public Player(byte id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.goldTokens = 0;
        this.gemsFromTokens = new TokenVector();
        this.gemsFromDevelopmentCards = new DevelopmentCardVector();
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

    public TokenVector getGemsFromTokens() {
        return gemsFromTokens;
    }

    public DevelopmentCardVector getGemsFromDevelopmentCards() {
        return gemsFromDevelopmentCards;
    }

    public List<DevelopmentCard> getHand() {
        return hand;
    }

    public List<NobleTile> getNobleTiles() {
        return nobleTiles;
    }

    private void drawTokens(Gem...gemTokens){
        this.gemsFromTokens.add(TokenVector.fromGems(gemTokens));
    }

    private void draw2Tokens(Gem gem) {
        this.drawTokens(gem, gem);
    }

    private void draw3Tokens(Gem gem1, Gem gem2, Gem gem3) {
        this.drawTokens(gem1, gem2, gem3);
    }

    private void putTokensAway(byte[] gemTokenAmounts) {
        this.gemsFromTokens.subtract(TokenVector.fromGemAmounts(gemTokenAmounts));
    }

    private void drawGoldToken(){
        this.goldTokens += 1;
    }

    private void putGoldTokensAway() {
        this.goldTokens -= 1;
    }

}
