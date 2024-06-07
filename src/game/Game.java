package game;

import elements.*;

import java.io.IOException;
import java.util.*;

public class Game {
    private final int GEM_TOKENS_COUNT = 7;
    private final int METAL_TOKENS_COUNT = 5;
    public static final int MIN_PLAYER_COUNT = 2;
    public static final int MAX_PLAYER_COUNT = 4;
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
        this.playerCount = cli.askForPlayerCount();
        this.players = new ArrayList<>(this.playerCount);
        
        GameConfigurator gameConfigurator = new GameConfigurator();

        this.allDevelopmentCards = gameConfigurator.getDevelopmentCards();
        this.allNobleTiles = gameConfigurator.getNobleTiles();

        BoardBuilder boardBuilder = ;
        this.board = new BoardBuilder()
                .placeDevelopmentCards(this.allDevelopmentCards)
                .placeNobleTiles(this.playerCount, this.allNobleTiles)
                .placeGemTokens(this.playerCount)
                .placeMetalTokens()
                .build();
        this.isGameOver = false;
    }

    public void start() throws Exception {
        this.setUp();

        while(!this.isGameOver) {
            this.nextTurn();
        }


        this.finish();
    }
    public void setUp() throws Exception {

        BoardCreator boardCreator;
        switch (this.playerCount) {
            case 2:
                boardCreator = new BoardCreatorFor2Players();
                break;
            case 3:
                boardCreator = new BoardCreatorFor3Players();
                break;
            case 4:
                boardCreator = new BoardCreatorFor4Players();
            default:
                throw new Exception(
                        String.format("Invalid amount of players. Correct numbers are between %d and %d", MIN_PLAYER_COUNT, MAX_PLAYER_COUNT)
                );
        }
        this.board = boardCreator.setUp();

    }
    public void nextTurn() {
        this.turnCount += 1;

        for(Player player : this.players) {
            boolean isValidMove = false;
            while (!isValidMove) {
                int moveID = this.cli.askAboutMove();
                isValidMove = player.checkMove(moveID);
            }
            player.move(moveID);
        }

    };

    public void sortPlayersByScore() {
        Comparator<Player> playerComparator = Comparator
                .comparing(Player::getScore)
                .reversed()
                .thenComparing(Player::getDevelopmentCardCount);

        this.players.sort(playerComparator);
    }

    public void finish() {
        this.sortPlayersByScore();
        this.cli.printScoreInfo(this.players);
        this.cli.printEndMessage(this.turnCount);
    }


}
