import java.util.ArrayList;

public class User {
    private String searchQuery;
    private ArrayList<Movie> favorites;

    public User() {
        this.favorites = new ArrayList<>();
    }

    public ArrayList<Movie> search(String query, ArrayList<Movie> movies) {
        ArrayList<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.matches(query)) {
                results.add(movie);
            }
        }
        return results;
    }

    public void addFavorite(Movie movie) {
        favorites.add(movie);
        System.out.println(movie.getTitle() + " added to favorites!");
    }
}
