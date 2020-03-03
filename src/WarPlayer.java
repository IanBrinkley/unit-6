import java.util.ArrayList;

public class WarPlayer {

    private ArrayList<WarCard> hand = new ArrayList<>();

    public WarPlayer(WarDeck deck, int startingCards) {
        for (int i = 0; i < startingCards; i++) {
            hand.add(deck.drawCard());
        }
    }

    public WarCard playCard() {
        return hand.remove(0);
    }

    public ArrayList<WarCard> getHand() {
        return hand;
    }

    public void clearHand() {
        hand.clear();
    }

    public void addCard(WarCard card) {
        hand.add(card);
    }

    public String toString() {
        String result = "";
        for (WarCard card : hand) {
            result += card.toString() + "; ";
        }
        return result;
    }
}
