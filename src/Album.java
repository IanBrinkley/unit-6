public class Album {
    private String name;
    private String artist;
    private int size;
    private double time;
    public Album(String name, String artist, int size, double time) {
        this.name = name;
        this.artist = artist;
        this.size = size;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getSize() {
        return size;
    }

    public double getTime() {
        return time;
    }

    public String toString() {
        return name + ", by " + artist + " | " + size + " tracks, length: " + time + " minutes.";
    }
}
