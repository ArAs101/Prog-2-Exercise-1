package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    @Test

    void show_unfiltered_movies_initially() {
        List<Movie> initialMovies = Movie.initializeMovies();
        assertNotEquals(null, initialMovies);
    }


    @Test
    void filterAllMoviesBySearchboxSearchingInTitleAndDescription(){};
    //void




}
