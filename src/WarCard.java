public class WarCard implements Comparable{

    private int face;
    private int suit;

    public WarCard(int face, int suit) {
        this.face = face;
        this.suit = suit;
    }

    public int getFace() {
        return face;
    }

    public int getSuit() {
        return suit;
    }

    public int compareTo(Object other) {
        WarCard otherCard = (WarCard) other;
        return face*suit - otherCard.getFace()*otherCard.getSuit();
    }

    public String toString() {
        return WarLogic.valueToFace(face) + WarLogic.valueToSuit(suit);
    }
}
