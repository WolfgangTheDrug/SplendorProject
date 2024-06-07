package elements;

import economy.GemTokenVector;
import economy.PreciousMetalTokenVector;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<DevelopmentCard>> upcards = new ArrayList<>();
    private List<List<DevelopmentCard>> decks = new ArrayList<>();
    private List<NobleTile> nobles = new ArrayList<>();
    private GemTokenVector gems = new GemTokenVector();
    private PreciousMetalTokenVector metals = new PreciousMetalTokenVector();


    public List<List<DevelopmentCard>> getUpcards() {
        return upcards;
    }

    public List<List<DevelopmentCard>> getDecks() {
        return decks;
    }

    public void setDecks(List<List<DevelopmentCard>> decks) {
        this.decks = decks;
    }

    public List<NobleTile> getNobles() {
        return nobles;
    }

    public void setNobles(List<NobleTile> nobles) {
        this.nobles = nobles;
    }

    public GemTokenVector getGems() {
        return gems;
    }

    public void setGems(GemTokenVector gems) {
        this.gems = gems;
    }

    public PreciousMetalTokenVector getMetals() {
        return metals;
    }

    public void setMetals(PreciousMetalTokenVector metals) {
        this.metals = metals;
    }
}
