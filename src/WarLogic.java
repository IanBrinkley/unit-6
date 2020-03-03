public class WarLogic {

    public static String valueToSuit(int value) {
        if (value == 1) {
            return "♤";
        } else if (value == 2) {
            return "♡";
        } else if (value == 3) {
            return "♢";
        } else if (value == 4) {
            return "♧";
        } else {
            return "Invalid suit.";
        }
    }

    // Aces are counted as value 14, not 1
    public static String valueToFace(int value) {
        if (value < 11 && value > 1) {
            return value + "";
        } else if (value == 11) {
            return "J";
        } else if (value == 12) {
            return "Q";
        } else if (value == 13) {
            return "K";
        } else if (value == 14) {
            return "A";
        } else {
            return "Invalid face.";
        }
    }
}
