package elements;

import economy.GemTokenVector;
import economy.PreciousMetalTokenVector;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Player> players;
    private final List<List<DevelopmentCard>> upcards;
    private final List<List<DevelopmentCard>> decks;
    private final List<NobleTile> nobles;
    private final GemTokenVector gems;
    private final PreciousMetalTokenVector metals;

    Board(BoardBuilder boardBuilder) {
        this.players = new ArrayList<>();
        this.upcards = new ArrayList<>();
        this.decks = new ArrayList<>();
        this.nobles = new ArrayList<>();
        this.gems = new GemTokenVector();
        this.metals = new PreciousMetalTokenVector();
    }
}
