import java.text.DecimalFormat;
import java.util.ArrayList;

public class WarGame {

    public static void main(String[] args) {

        DecimalFormat fmt = new DecimalFormat("##.00");

        // keeping track of games that reach limit because am curious
        int maxRoundsPerGame = 10000;
        int limitReachingGames = 0;

        int totalRounds = 0;
        int totalGames = 2000;

        //simulate several games
        for (int g = 0; g < totalGames; g++) {

            // can I just say this game is a logic nightmare
            WarDeck gameDeck = new WarDeck();
            gameDeck.shuffle();

            WarPlayer p1 = new WarPlayer(gameDeck, 26);
            WarPlayer p2 = new WarPlayer(gameDeck, 26);

            int roundCount = 0;

            // while neither player has 0 cards...
            while (p1.getHand().size() != 0 && p2.getHand().size() != 0) {

                roundCount++;

                // keep track of all the cards played in a round
                ArrayList<WarCard> roundCards = new ArrayList<>();

                /*
                System.out.println("p1: " + p1.getHand());
                System.out.println("p2: " + p2.getHand());
                */

                WarCard p1Played = p1.playCard();
                WarCard p2Played = p2.playCard();

                roundCards.add(p1Played);
                roundCards.add(p2Played);

                // keep track of who wins
                WarPlayer roundWinner;

                // i keep running into infinite loops, so we'll cap rounds at this.
                if (roundCount >= maxRoundsPerGame)  {
                    p1.clearHand();
                    p2.clearHand();
                    limitReachingGames++;
                }

                // if the cards are the same
                if (p1Played.getFace() == p2Played.getFace()) {
                    if (p1.getHand().size() > 3 && p2.getHand().size() > 3) { // if both players have at least 4 cards to play
                        WarCard[] p1Troop = new WarCard[4];
                        WarCard[] p2Troop = new WarCard[4];

                        // sending out the troop !!!
                        for (int i = 0; i < 4; i++) {
                            p1Troop[i] = p1.playCard();
                            p2Troop[i] = p2.playCard();

                            roundCards.add(p1Troop[i]);
                            roundCards.add(p2Troop[i]);
                        }

                        int p1Sum = 0, p2Sum = 0;
                        WarCard p1HighestFaceCard = p1Troop[0];
                        WarCard p2HighestFaceCard = p2Troop[0];

                        // calculating troop sum and highest troop card
                        for (WarCard card : p1Troop) {
                            p1Sum += card.getFace();
                            if (card.getFace() > p1HighestFaceCard.getFace()) {
                                p1HighestFaceCard = card;
                            }
                        }
                        for (WarCard card : p2Troop) {
                            p2Sum += card.getFace();
                            if (card.getFace() > p2HighestFaceCard.getFace()) {
                                p2HighestFaceCard = card;
                            }
                        }

                        if (p1Sum == p2Sum) { // 1st cards equal, troops are equal

                            if (p1HighestFaceCard.getFace() == p2HighestFaceCard.getFace()) { // 1st cards equal, troop sums equal, highest cards equal

                                if (p1HighestFaceCard.compareTo(p2HighestFaceCard) > 0) { // p1 has better suit, what a fancy lad
                                    roundWinner = p1;
                                } else {
                                    roundWinner = p2;
                                }
                            } else { // 1st cards equal, troop sums equal, highest cards not equal

                                if (p1HighestFaceCard.getFace() > p2HighestFaceCard.getFace()) { // p1 has better value
                                    roundWinner = p1;
                                } else {
                                    roundWinner = p2;
                                }
                            }
                        } else { // 1st cards equal, troops not equal
                            if (p1Sum > p2Sum) { // p1 has better troop
                                roundWinner = p1;
                            } else {
                                roundWinner = p2;
                            }
                        }
                    } else { // a player ran out of cards
                        if (p2.getHand().size() < 3) { // player 2 ran out of cards
                            roundWinner = p1;
                        } else {
                            roundWinner = p2;
                        }
                    }
                } else { // 1st cards not equal
                    if (p1Played.getFace() > p2Played.getFace()) {
                        roundWinner = p1;
                    } else {
                        roundWinner = p2;
                    }
                }
                for (WarCard card : roundCards) {
                    roundWinner.addCard(card);
                }
            }
            totalRounds += roundCount;
        }
        System.out.println("Average number of rounds from " + totalGames + " games: " + fmt.format((double) totalRounds / totalGames));
        System.out.println("Games that reached the limit of " + maxRoundsPerGame + ": " + limitReachingGames + " (" + fmt.format((double) limitReachingGames * 100 / totalGames) + "% of games)");
    }
}
