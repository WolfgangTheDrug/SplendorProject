package elements;

import economy.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int id;
    private final String name;
    private int score;
    private int cardCount;
    private GemTokenVector gemsFromTokens;
    private PreciousMetalTokenVector metalTokens;
    private GemCardVector gemsFromDevelopmentCards;
    private final List<DevelopmentCard> hand;
    private final List<NobleTile> nobleTiles;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.cardCount = 0;
        this.metalTokens = new PreciousMetalTokenVector();
        this.gemsFromTokens = new GemTokenVector();
        this.gemsFromDevelopmentCards = new GemCardVector();
        this.hand = new ArrayList<>();
        this.nobleTiles = new ArrayList<>();
    }

    public Player(int id) {
        this(id, "Player " + id);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDevelopmentCardCount() {
        return this.cardCount;
    }

    public GemTokenVector getGemsFromTokens() {
        return this.gemsFromTokens;
    }

    public void setGemsFromTokens(GemTokenVector gemsFromTokens) {
        this.gemsFromTokens = gemsFromTokens;
    }

    public PreciousMetalTokenVector getMetalTokens(){
        return this.metalTokens;
    }

    public void setMetalTokens(PreciousMetalTokenVector metalTokens) {
        this.metalTokens = metalTokens;
    }

    public GemCardVector getGemsFromDevelopmentCards() {
        return this.gemsFromDevelopmentCards;
    }

    public void setGemsFromDevelopmentCards(GemCardVector gemsFromDevelopmentCards) {
        this.gemsFromDevelopmentCards = gemsFromDevelopmentCards;
    }

    public List<DevelopmentCard> getHand() {
        return this.hand;
    }

    public List<NobleTile> getNobleTiles() {
        return this.nobleTiles;
    }

    public GemTokenVector getPurchasablePower() {
        GemTokenVector fromGemTokens = this.gemsFromTokens;
        GemCardVector fromDevelopmentCards = this.gemsFromDevelopmentCards;
        fromGemTokens.add(fromDevelopmentCards);
        return fromGemTokens;
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

    private void putGemTokensAway(int[] gemTokenAmounts) {
        this.gemsFromTokens.subtract(GemTokenVector.fromGemAmounts(gemTokenAmounts));
    }

    private void drawMetalToken(PreciousMetal...preciousMetalTokens){
        this.metalTokens.add(PreciousMetalTokenVector.fromMetals(preciousMetalTokens));
    }

    private void putMetalTokensAway(int[] metalTokensAmounts) {
        this.metalTokens.subtract(PreciousMetalTokenVector.fromMetalAmounts(metalTokensAmounts));
    }

    public void move(int moveID) {
        switch (moveID) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    public boolean requestMove(int moveID) {
    }
}
