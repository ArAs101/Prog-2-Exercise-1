package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;
    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(object == this){
            return true;
        }
        if(!(object instanceof Movie other)){
            return false;
        }
        return this.title.equals(other.title) && this.description.equals(other.description) && this.genres.equals(other.genres);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() { return description; }
    public List<Genre> getGenres() { return genres; }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(
                "The Dog",
                "Movie about a cute dog.",
                Arrays.asList(Genre.ANIMATION, Genre.FAMILY)
        ));
        movies.add(new Movie(
                "CatsVenture",
                "A cute cat on an adventure.",
                Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE)
        ));
        movies.add(new Movie(
                "The Usual Suspects",
                "A sole survivor tells of the twisty events leading up to a horrific gun " +
                        "battle on a boat, which began when five criminals met at a seemingly random" +
                        "police lineup.",
                Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY)
        ));
        movies.add(new Movie(
                "Life is Beautiful",
                "When an open-minded Jewish librarian and his become victims of the Holocaust, " +
                        "he uses a perfect mixture of will, humour, and imagination to protect his son from " +
                        "the dangers around their camp.",
                Arrays.asList(Genre.DRAMA, Genre.ROMANCE)
        ));

        movies.add(new Movie(
                "M3GAN",
                "Horror movie about a highly intelligent humanoid doll.",
                Arrays.asList(Genre.HORROR, Genre.THRILLER, Genre.DRAMA)
        ));

        movies.add(new Movie(
                "The Godfather",
                "Don Vito Corleone aggressively tries to make his son step in his own footsteps...",
                Arrays.asList(Genre.CRIME, Genre.DRAMA)
        ));

        movies.add(new Movie(
                "John Wick Chapter 4",
                "John Wick uncovers a path to defeating The High Table. But before he can earn his " +
                        "freedom, Wick must face off against a new enemy with powerful alliances across the " +
                        "globe and forces that turn old friends into foes.",
                Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.THRILLER)
        ));

        movies.add(new Movie(
                "Among Us",
                "After the mysterious death of their young son, a couple desperately flees to a remote " +
                        "lake house to escape the unrelenting haunting following them only to discover the mysterious" +
                        " entity is still very much a part of their lives.",
                Arrays.asList(Genre.DRAMA, Genre.HORROR, Genre.THRILLER)
        ));

        movies.add(new Movie(
                "Avatar: The Way of Water",
                "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. " +
                        "Once a familiar threat returns to finish what was previously started, Jake must work " +
                        "with Neytiri and the army of the Na'vi race to protect their home.",
                Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)
        ));

        return movies;
    }
}
