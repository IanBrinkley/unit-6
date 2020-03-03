import java.util.ArrayList;
import java.util.Collections;

public class WarDeck {

    private ArrayList<WarCard> cards = new ArrayList<>();

    public WarDeck() {
        for (int suit = 1; suit <= 4; suit++) {
            for (int face = 2; face <= 14; face++) {
                cards.add(new WarCard(face, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public WarCard drawCard() {
        return cards.remove(0);
    }

    public String toString() {
        String result = "";
        for (WarCard card : cards) {
            result += card.toString() + "| ";
        }
        return result;
    }
}
