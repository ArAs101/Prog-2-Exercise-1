package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genre) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() { return genres;}

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        movies.add(new Movie("M3GAN", "Creepy Doll", Arrays.asList(Genre.HORROR, Genre.THRILLER)));
        movies.add(new Movie("Sissi", "The Life of Austrian empress Sissi", Arrays.asList(Genre.DOCUMENTARY, Genre.DRAMA)));
        return movies;
    }
}
