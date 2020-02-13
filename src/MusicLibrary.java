public class MusicLibrary {
    private Album[] library;
    private int usedSpots;
    public MusicLibrary() {
        library = new Album[10];
    }
    public void add(Album a) {
        if (usedSpots == library.length) {
            System.out.println("The library is full! Try calling doubleSize().");
        } else {
            library[usedSpots] = a;
            usedSpots++;
        }
    }
    public void doubleSize() {
        Album[] placeholder = new Album[library.length * 2];
        for(int i = 0; i < library.length; i++) {
            placeholder[i] = library[i];
        }
        library = placeholder;
    }
    public void remove(int index) {
        for(int i = index; i < library.length - 1; i++) {
            library[i] = library[i+1];
        }
        library[library.length - 1] = null;
        usedSpots--;
    }
    public String toString() {
        String result = "";
        result += "Max length: " + library.length;
        result += "\nCurrent # of songs: " + usedSpots;
        result += "\nAlbums: \n";
        for (int i = 0; i < library.length; i++) {
            if (library[i] != null) {
                result += i+1 + ": " + library[i] + "\n";
            }
        }
        return result;
    }
    public int findTitle(String title) {
        for (int i = 0; i < library.length; i++) {
            if (library[i] != null && library[i].getName().equals(title)) {
                return i;
            }
        }
        return -1;
    }
    public int findArtist(String artist) {
        for (int j = 0; j < library.length; j++) {
            if (library[j].getArtist().equals(artist)) {
                return j;
            }
        }
        return -1;
    }
    public Album getAlbum(int index) {
        if (index >= 0 && index < library.length) {
            return library[index];
        } else {
            System.out.println("Index out of bounds!");
            return null;
        }
    }
    public void sortByTitle() {
        int min;
        Album temp;

        for (int i = 0; i < library.length - 1; i++) {
            min = i;
            for (int scan = i + 1; scan < library.length; scan++) {
                if (library[scan] != null && library[min] != null && library[scan].getName().compareTo(library[min].getName()) < 0) {
                    min = scan;
                }
            }
            temp = library[min];
            library[min] = library[i];
            library[i] = temp;
        }
    }
    public void sortByArtist(){
        for(int i = 1; i < library.length; i++){
            Album key = library[i];
            int position = i;

            while (position > 0 && library[position - 1] != null && key != null && library[position - 1].getArtist().compareTo(key.getArtist()) > 0){
                library[position] = library[position - 1];
                position--;
            }
            library[position] = key;
        }
    }
    public void sortByLength(){
        for(int i = 1; i < library.length; i++){
            Album key = library[i];
            int position = i;

            while (position > 0 && library[position - 1].getTime() > key.getTime()){
                library[position] = library[position - 1];
                position--;
            }
            library[position] = key;
        }
    }

    public int binarySearch(String title) {
        sortByTitle();
        int low = 0, high = library.length-1, middle = (low + high)/2;

        while (!(library[middle].getName().equals(title)) && low <= high){
            if (title.compareTo(library[middle].getName()) < 0)
                high = middle - 1;
            else
                low = middle + 1;
            middle = (low + high)/2;
        }

        if (library[middle].getName().equals(title))
            return middle;
        else
            return -1;
    }
    public int binarySearch(int numMins) {
        sortByLength();
        int low = 0, high = library.length-1, middle = (low + high)/2;

        while (!(library[middle].getTime() != numMins) && low <= high){
            if (numMins < library[middle].getTime())
                high = middle - 1;
            else
                low = middle + 1;
            middle = (low + high)/2;
        }

        if (library[middle].getTime() == numMins)
            return middle;
        else
            return -1;
    }


}
