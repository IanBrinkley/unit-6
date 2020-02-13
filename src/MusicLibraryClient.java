public class MusicLibraryClient {
    public static void main(String[] args) {
        MusicLibrary myLibrary = new MusicLibrary();

        Album a1 = new Album("First", "one Guy", 10, 42.5);
        Album a2 = new Album("This Music", "Some Band", 9, 36);
        Album a3 = new Album("Play", "People", 12, 39.1);
        Album a4 = new Album("AAA", "helo", 5, 81);
        Album a5 = new Album("Ya like jazz", "Zach", 12, 24);
        Album a6 = new Album("Second", "two Guy", 9, 40);
        Album a7 = new Album("z", "a", 5, 30);
        Album a8 = new Album("c", "h", 12, 37.3);
        Album a9 = new Album("no", "u", 1, 69);
        Album a10 = new Album("u suck", "zach", 983, 0.1);

        myLibrary.add(a1);
        myLibrary.add(a2);
        myLibrary.add(a3);
        myLibrary.add(a4);
        myLibrary.add(a5);
        myLibrary.add(a6);
        myLibrary.add(a7);
        myLibrary.add(a8);
        myLibrary.add(a9);
        myLibrary.add(a10);
/*
        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        myLibrary.doubleSize();

        System.out.println(myLibrary);

*/

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        System.out.println(myLibrary.binarySearch("Second"));
        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        /*

        int firstIndex = myLibrary.findTitle("First");
        System.out.println(myLibrary.getAlbum(firstIndex));
        int someBandIndex = myLibrary.findArtist("People");
        System.out.println(myLibrary.getAlbum(someBandIndex));

        */
    }
}