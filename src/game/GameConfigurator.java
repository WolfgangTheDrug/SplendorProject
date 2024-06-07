package game;

import economy.Gem;
import economy.GemCardVector;
import economy.GemTokenVector;
import elements.DevelopmentCard;
import elements.NobleTile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameConfigurator {

    private final List<int[]> developmentCardsData = new ArrayList<>();
    private final List<DevelopmentCard> developmentCards = new ArrayList<>();
    private final List<int[]> nobleTilesData = new ArrayList<>();
    private final List<NobleTile> nobleTiles = new ArrayList<>();

    public GameConfigurator() throws IOException {
        this.accessDevelopmentCardsCSV();
        this.accessNobleTilesCSV();

        this.readDevelopmentCards();
        this.readNobleTiles();
    }

    private void accessDevelopmentCardsCSV() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./config/card_list.csv"));
        String line;
        line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] valuesAsText = line.split(",");
            int value;
            int[] values = new int[valuesAsText.length];

            for (int i = 0; i < valuesAsText.length; i++) {
                if (valuesAsText[i].isEmpty()) {
                    value = 0;
                } else {
                    value = Integer.parseInt(valuesAsText[i]);
                }
                values[i] = value;
            }
            this.developmentCardsData.add(values);
        }
    }

    private void accessNobleTilesCSV() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./config/noble_list.csv"));
        String line;
        line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] valuesAsText = line.split(",");
            int value;
            int[] values = new int[valuesAsText.length];

            for (int i = 0; i < valuesAsText.length; i++) {
                if (valuesAsText[i].isEmpty()) {
                    value = 0;
                } else {
                    value = Integer.parseInt(valuesAsText[i]);
                }
                values[i] = value;
            }
            this.nobleTilesData.add(values);
        }
    }

    private void readDevelopmentCards() {
        for (int[] developmentCardDatum : this.developmentCardsData) {
            int level = developmentCardDatum[0];
            int score = developmentCardDatum[1];
            int[] bonusArray = Arrays.copyOfRange(developmentCardDatum, 2, 7);
            int[] priceArray = Arrays.copyOfRange(developmentCardDatum, 7, 12);
            int gemIndex = Arrays.binarySearch(bonusArray, 1);

            Gem bonus = Gem.values()[gemIndex];
            GemTokenVector price = GemTokenVector.fromGemAmounts(priceArray);

            DevelopmentCard developmentCard = new DevelopmentCard(level, score, bonus, price);
            this.developmentCards.add(developmentCard);
        }
    }

    public void readNobleTiles() {
        for (int[] nobleTileDatum : this.nobleTilesData) {
            int score = nobleTileDatum[0];
            int[] priceArray = Arrays.copyOfRange(nobleTileDatum, 1, 6);
            GemCardVector price = new GemCardVector(priceArray);
            NobleTile nobleTile = new NobleTile(score, price );
            this.nobleTiles.add(nobleTile);
        }
    }

    public List<DevelopmentCard> getDevelopmentCards() {
        return this.developmentCards;
    }

    public List<NobleTile> getNobleTiles() {
        return this.nobleTiles;
    }
}
