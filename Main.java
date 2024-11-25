import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StreamingService service = new StreamingService();
        service.loadMovies("movies.txt");

        User user = new User();
        ArrayList<Movie> searchResults = user.search("drama", service.getMovies());

        System.out.println("Search results:");
        for (Movie movie : searchResults) {
            System.out.println(movie);
        }

        if (!searchResults.isEmpty()) {
            user.addFavorite(searchResults.get(0));
        }
    }
}