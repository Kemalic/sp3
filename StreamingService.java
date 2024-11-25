import java.io.*;
import java.util.ArrayList;

public class StreamingService {
    private ArrayList<Movie> movies;

    public StreamingService() {
        this.movies = new ArrayList<>();
    }

    public void loadMovies(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[0];
                int year = Integer.parseInt(parts[1]);
                ArrayList<String> categories = new ArrayList<>();
                for (String cat : parts[2].split(",")) {
                    categories.add(cat.trim());
                }
                double rating = Double.parseDouble(parts[3]);
                movies.add(new Movie(title, year, categories, rating));
            }
        } catch (IOException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
