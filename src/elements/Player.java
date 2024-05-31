package elements;

import economy.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final byte id;
    private final String name;
    private byte score;
    private final GemTokenVector gemsFromTokens;
    private final PreciousMetalTokenVector metalTokens;
    private final GemCardVector gemsFromDevelopmentCards;
    private final List<DevelopmentCard> hand;
    private final List<NobleTile> nobleTiles;

    public Player(byte id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.metalTokens = new PreciousMetalTokenVector();
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

    public PreciousMetalTokenVector getMetalTokens(){
        return metalTokens;
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

    private void drawGemTokens(Gem...gemTokens){
        this.gemsFromTokens.add(GemTokenVector.fromGems(gemTokens));
    }

    private void draw2GemTokens(Gem gem) {
        this.drawGemTokens(gem, gem);
    }

    private void draw3GemTokens(Gem gem1, Gem gem2, Gem gem3) {
        this.drawGemTokens(gem1, gem2, gem3);
    }

    private void putGemTokensAway(byte[] gemTokenAmounts) {
        this.gemsFromTokens.subtract(GemTokenVector.fromGemAmounts(gemTokenAmounts));
    }

    private void drawMetalToken(PreciousMetal...preciousMetalTokens){
        this.metalTokens.add(PreciousMetalTokenVector.fromMetals(preciousMetalTokens));
    }

    private void putMetalTokensAway(byte[] metalTokensAmounts) {
        this.metalTokens.subtract(PreciousMetalTokenVector.fromMetalAmounts(metalTokensAmounts));
    }



}
