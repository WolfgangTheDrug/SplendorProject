package elements;


import economy.Gem;
import economy.GemTokenVector;
import economy.PreciousMetal;
import economy.PreciousMetalTokenVector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BoardBuilder {
    private List<List<DevelopmentCard>> decks;
    private List<List<DevelopmentCard>> upcards;
    private List<Player> players;
    private List<NobleTile> nobles;
    private GemTokenVector gems;
    private PreciousMetalTokenVector metals;

    public BoardBuilder(){
        this.decks = new ArrayList<>(3);
        this.upcards = new ArrayList<>(3);
        this.players = new ArrayList<>(2);
        this.nobles = new ArrayList<>(3);
        this.gems = new GemTokenVector();
        this.metals = new PreciousMetalTokenVector();
    }

    public BoardBuilder setDecks(List<DevelopmentCard> order1Deck, List<DevelopmentCard> order2Deck, List<DevelopmentCard> order3Deck) {
        Collections.shuffle(order1Deck);
        Collections.shuffle(order2Deck);
        Collections.shuffle(order3Deck);
        this.decks.add(order1Deck);
        this.decks.add(order2Deck);
        this.decks.add(order3Deck);
        return this;
    }

    public BoardBuilder setUpcards() {
        DevelopmentCard card;
        for (int i = 0; i < this.decks.size(); i++) {
            this.upcards.add(new ArrayList<>(4));
            card = this.decks.get(i).remove(0);
            card.reveal();
            this.upcards.get(i).add(card);
        }
        return this;
    }

    public BoardBuilder introducePlayer() {
        byte id = (byte) (this.players.size() + 1);
        Player player = new Player(id);
        this.players.add(player);
        return this;
    }

    public BoardBuilder introducePlayer(String name) {
        byte id = (byte) (this.players.size() + 1);
        Player player = new Player(id, name);
        this.players.add(player);
        return this;
    }

    public BoardBuilder introduceNobleTile(NobleTile nobleTile) {
        this.nobles.add(nobleTile);
        return this;
    }

    public BoardBuilder increaseGemsAmounts() {
        GemTokenVector gems = GemTokenVector.fromGems(Gem.values());
        this.gems.add(gems);
        return this;
    }

    public BoardBuilder increaseMetalsAmounts(){
        PreciousMetalTokenVector metals = PreciousMetalTokenVector.fromMetals(PreciousMetal.values());
        this.metals.add(metals);
        return this;
    }

    public Board build() {
        return new Board(this);
    }
}
