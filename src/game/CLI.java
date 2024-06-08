package game;

import elements.Player;

import java.util.*;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);


    public int askForPlayerCount() {
        int result;

        System.out.println("Please input the number of players: ");
        result = this.scanner.nextInt();
        return result;
    }

    private boolean validateString(String inputString, String regexPattern) {
        return inputString != null && inputString.matches(regexPattern);
    }
    private boolean validatePlayerName(String playerName) {
        return validateString(playerName, "^\\w{3,}$");
    }
    public String askForPlayerName (int playerID, List<Player> players) {
        String newPlayerName = "";
        List<String> playersNames = players.stream().map(Player::getName).toList();

        boolean isValid = false;
        while(!isValid) {
            System.out.printf("%s %d.\n%s."
                    , "Please input name for Player"
                    , playerID
                    , "A valid name consists of at least 3 alphanumerical latin characters (no spaces or special characters)"
            );
            newPlayerName = this.scanner.nextLine();

            isValid = this.validatePlayerName(newPlayerName) && !playersNames.contains(newPlayerName);
        }

        return newPlayerName;
    }

    private boolean validateMoveChoice(String choice) {
        return validateString(choice, "^[1-5]$");
    }
    public int askAboutMove(Player player) {
        Map<Integer, String> moveOptions = new HashMap<>(5);
        moveOptions.put(1, "Take 3 gem tokens of different colors");
        moveOptions.put(2,  "Take 2 gem tokens of the same color");
        moveOptions.put(3, "Purchase 1 face-up development card from the middle of the table. or a previously reserved one");
        moveOptions.put(4, "Purchase 1 previously reserved development card");
        moveOptions.put(5, "Reserve 1 development card and take 1 gold token (joker)");
        String playersInput = "";

        boolean isValid = false;
        while (!isValid) {
            System.out.printf("%s %d (%s) %s. %s\n"
                    , "Player's"
                    , player.getId()
                    , player.getName()
                    , "move"
                    , "Please select one of the following options:"
            );
            moveOptions.forEach((index, description) -> System.out.printf("\t%d. %s.\n", index, description));
            playersInput = this.scanner.nextLine();

            isValid = this.validateMoveChoice(playersInput);
        }

        return Integer.parseInt(playersInput);
    }

    public void printScoreInfo(List<Player> players) {
        System.out.println("The final scores:");
        for (int i = 1; i <= players.size(); i++) {
            System.out.printf("\t%d. %s: %d\n"
                    , i
                    , players.get(i).getName()
                    , players.get(i).getScore()
            );
        }
    }

    public void printEndMessage(int turnCount) {
        System.out.printf("Congratulations! The game lasted %d turns.", turnCount);
    }
}
