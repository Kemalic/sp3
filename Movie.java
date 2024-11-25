import java.util.ArrayList;

public class Movie {
    private String title;
    private int releaseYear;
    private ArrayList<String> categories;
    private double rating;

    public Movie(String title, int releaseYear, ArrayList<String> categories, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.categories = categories;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public boolean matches(String query) {
        query = query.toLowerCase();
        String finalQuery = query;
        return title.toLowerCase().contains(query) ||
                categories.stream().anyMatch(cat -> cat.toLowerCase().contains(finalQuery));
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + categories + " - Rating: " + rating;
    }
}
