package game;

import economy.GemTokenVector;
import elements.*;

import java.io.IOException;
import java.util.*;

public class Game {
    private final int GEM_TOKENS_COUNT = 7;
    private final int METAL_TOKENS_COUNT = 5;
    private final int MIN_PLAYER_COUNT = 2;
    private final int MAX_PLAYER_COUNT = 4;
    private final CLI cli;
    private final List<DevelopmentCard> allDevelopmentCards;
    private final List<NobleTile> allNobleTiles;
    private final List<Player> players;
    private int playerCount;
    private Board board;
    private boolean isGameOver;
    private int turnCount;

    public Game() throws IOException {
        this.cli = new CLI();
        this.playerCount = this.cli.askForPlayerCount();
        this.players = new ArrayList<>(this.playerCount);
        int playersAdded = 1;
        while (playersAdded <= this.playerCount) {
            String newPlayerName = this.cli.askForPlayerName(playersAdded, this.players);
            Player newPlayer = new Player(playersAdded, newPlayerName);
            this.players.add(newPlayer);
        }

        GameConfigurator gameConfigurator = new GameConfigurator();
        this.allDevelopmentCards = gameConfigurator.getDevelopmentCards();
        this.allNobleTiles = gameConfigurator.getNobleTiles();

        this.board = new BoardBuilder()
                .placeDevelopmentCards(this.allDevelopmentCards)
                .placeNobleTiles(this.playerCount, this.allNobleTiles)
                .placeGemTokens(this.playerCount)
                .placeMetalTokens()
                .build();
        this.isGameOver = false;
    }

    public void play() throws Exception {

        while(!this.isGameOver) {
            this.nextTurn();
        }

        this.finish();
    }

    public void nextTurn() {
        this.turnCount += 1;

        for(Player player : this.players) {
            boolean isValidMove = false;
            while (!isValidMove) {
                int moveID = this.cli.askAboutMove(player);
                switch (moveID) {
                    case 1:
                        GemTokenVector request = this.cli.askAboutGems(3);
                        if (this.board.getGems().isGreaterOrEqual(request)){
                            this.board.setGems(this.board.getGems().subtract(request));
                            player.setGemsFromTokens((GemTokenVector) player.getGemsFromTokens().add(request));
                            isValidMove = true;
                        }
                        break;
                    case 2:
                        GemTokenVector request = this.cli.askAboutGems(2);
                        if (this.board.getGems().isGreaterOrEqual(request.multiply(2))){
                            CODE HERE
                            isValidMove = true;
                        }
                        break;
                    case 3:
                        int x = this.cli.askAboutCardLevel();
                        int y = this.cli.askAboutCardColumn();
                        DevelopmentCard request = this.board.getDecks().get(x).get(y);
                        GemTokenVector price = request.getPrice();
//                        if (player.getGemsFromTokens())
                        break;

                }
                isValidMove = player.requestMove(move);
            }
            player.move(moveID);
        }

    };

    private void sortPlayersByScore() {
        Comparator<Player> playerComparator = Comparator
                .comparing(Player::getScore)
                .thenComparing(Player::getDevelopmentCardCount)
                .reversed();

        this.players.sort(playerComparator);
    }

    public void finish() {
        this.sortPlayersByScore();
        this.cli.printEndMessage(this.turnCount);
        this.cli.printScoreInfo(this.players);
    }
}
