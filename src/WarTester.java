public class WarTester {

    public static void main(String[] args) {

        WarDeck d1 = new WarDeck();
        d1.shuffle();
        System.out.println(d1);

        WarPlayer p1 = new WarPlayer(d1, 5);
        WarPlayer p2 = new WarPlayer(d1, 5);

        System.out.println("Player 1: " + p1);
        System.out.println("Player 2: " + p2);

        WarPlayer roundWinner;

        while (true) {

            WarCard p1PlayedCard = p1.playCard();
            WarCard p2PlayedCard = p2.playCard();

            System.out.println("Player 1 played: " + p1PlayedCard);
            System.out.println("Player 2 played: " + p2PlayedCard);

            if (p1PlayedCard.getFace() > p2PlayedCard.getFace()) {
                roundWinner = p1;
                break;
            } else if (p1PlayedCard.getFace() < p2PlayedCard.getFace()) {
                roundWinner = p2;
                break;
            }

            System.out.println("Cards were the same rank, playing again..\n");
        }

        System.out.println("");
    }
}
