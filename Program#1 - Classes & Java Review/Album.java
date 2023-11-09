
class Album {
    // Instance Variables
    private String title;
    private String performer;
    private String genre;
    private int numSongs;

    // Default values
    private static String defaultTitle = "Renaissance";
    private static String defaultPerformer = "Beyonce";
    private static int defaultNumSongs = 10;
    private static String defaultGenre = "easy listening";
    private String[] validGenres = {"hip-hop", "easy listening", "orchestral", "your parents", "theatre"};


    // Constructors
    public Album() {
        title = defaultTitle;
        performer = defaultPerformer;
        genre = defaultGenre;
        numSongs = defaultNumSongs;
    }
    public Album(String inputTitle, String inputPerformer, String inputGenre, int inputNumSongs) {
        title = inputTitle;
        performer = inputPerformer;
        setGenre(inputGenre);
        setNumSongs(inputNumSongs);
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public String getPerformer() {
        return performer;
    }
    public String getGenre() {
        return genre;
    }
    public int getNumSongs() {
        return numSongs;
    }
    public void setTitle(String inputTitle) {
        title = inputTitle;
    }

    // Setters
    public void setPerformer(String inputPerformer) {
        performer = inputPerformer;
    }
    public void setGenre(String inputGenre) {
        for (String validGenre : validGenres) {
            if (validGenre.equals(inputGenre)) {
                genre = inputGenre;
                return;
            }
        }
        genre = defaultGenre;
    }
    public void setNumSongs(int numberOfSongs) {
        // Ensure that the number of songs is at least 10
        this.numSongs = Math.max(numberOfSongs, 10);
    }

    // toString method
    public String toString() {
        return "Performer: " + performer + "\nTitle: " + title + "\nGenre: " + genre + "\nNumber of Songs: " + numSongs;
    }

    // Checks if album has more than 50 songs
    public boolean isLong() {
        return numSongs > 50;
    }
}



