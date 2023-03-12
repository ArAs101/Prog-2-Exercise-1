package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
        //void sortMovies() {
    void show_unfiltered_movies_initially() {
        List<Movie> initialMovies = Movie.initializeMovies();
        assertNotEquals(null, initialMovies);
    }

    @Test
    void movie_list_is_sorted_ascending_if_button_displays_desc() {
        // GIVEN
        HomeController newController = new HomeController();
        //new list that is going to be tested
        ObservableList<Movie> exampleMovies = FXCollections.observableArrayList();
        Movie movieA = new Movie("MovieA", "descriptionA", List.of(Genre.ADVENTURE));
        Movie movieB = new Movie("MovieB", "descriptionB", List.of(Genre.HORROR));
        Movie movieC = new Movie("MovieC", "descriptionC", List.of(Genre.ROMANCE));
        exampleMovies.add(movieA);
        exampleMovies.add(movieB);
        exampleMovies.add(movieC);

        // WHEN
        ObservableList<Movie> actual = newController.sortMovies(); //actual

        // THEN
        //create expected list
        ObservableList<Movie> expected = FXCollections.observableArrayList();
        expected.add(movieA);
        expected.add(movieB);
        expected.add(movieC);
        //TEST
        assertEquals(expected, actual);
    }


    @Test
    void movie_list_is_sorted_descending_if_button_displays_asc() {
        // GIVEN
        HomeController newController = new HomeController();
        //new list that is going to be tested
        ObservableList<Movie> exampleMovies = FXCollections.observableArrayList();
        Movie movieA = new Movie("MovieA", "descriptionA", List.of(Genre.ADVENTURE));
        Movie movieB = new Movie("MovieB", "descriptionB", List.of(Genre.HORROR));
        Movie movieC = new Movie("MovieC", "descriptionC", List.of(Genre.ROMANCE));
        exampleMovies.add(movieA);
        exampleMovies.add(movieB);
        exampleMovies.add(movieC);

        // WHEN
        ObservableList<Movie> actual = newController.sortMovies(); //actual

        // THEN
        //create expected list
        ObservableList<Movie> expected = FXCollections.observableArrayList();
        expected.add(movieC);
        expected.add(movieB);
        expected.add(movieA);
        //TEST
        assertEquals(expected, actual);
    }
}
