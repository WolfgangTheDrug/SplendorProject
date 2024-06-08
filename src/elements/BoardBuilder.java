package elements;

import economy.Gem;
import economy.GemTokenVector;
import economy.PreciousMetal;
import economy.PreciousMetalTokenVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardBuilder {
    private final Board board;

    public BoardBuilder() {
        this.board = new Board();
    }

    private List<List<DevelopmentCard>> separateDevelopmentCardsByLevel (List<DevelopmentCard> fullDeck) {
        final int DECK_COUNT = 3;
        List<List<DevelopmentCard>> separatedDecks = new ArrayList<>(DECK_COUNT);
        for (int i = 0; i < DECK_COUNT; i++) {
            separatedDecks.add(new ArrayList<>());
        }

        Collections.shuffle(fullDeck);

        for (DevelopmentCard card : fullDeck) {
            separatedDecks.get(card.getLevel() - 1).add(card);
        }
        return separatedDecks;
    }

    public BoardBuilder placeDevelopmentCards(List<DevelopmentCard> fullDeck) {
        List<List<DevelopmentCard>> separatedDecks = this.separateDevelopmentCardsByLevel(fullDeck);
        board.setDecks(separatedDecks);
        return this;
    }



    public BoardBuilder placeNobleTiles(int playerCount, List<NobleTile> nobleTiles) {
        final int NOBLE_TILES_COUNT = playerCount + 1;

        Collections.shuffle(nobleTiles);
        List<NobleTile> drawnTiles = nobleTiles.subList(0, NOBLE_TILES_COUNT);
        this.board.setNobles(drawnTiles);
        return this;
    }

    public BoardBuilder placeGemTokens(int playerCount) {
        int gemTokenCount = playerCount + 2;
        if (playerCount == 4) {
            ++gemTokenCount;
        }

        int[] amounts = new int[Gem.values().length];
        Arrays.fill(amounts, gemTokenCount);

        GemTokenVector initialGemTokens = GemTokenVector.fromGemAmounts(amounts);
        this.board.setGems(initialGemTokens);
        return this;
    }

    public BoardBuilder placeMetalTokens() {
        int metalTokenCount = 5;

        int[] amounts = new int[PreciousMetal.values().length];
        Arrays.fill(amounts, metalTokenCount);

        PreciousMetalTokenVector initialMetalTokens = PreciousMetalTokenVector.fromMetalAmounts(amounts);
        this.board.setMetals(initialMetalTokens);
        return this;
    }

    public Board build() {
        return this.board;
    }
}
