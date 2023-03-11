package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortState;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;


    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    public final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    public SortState sortState = SortState.NONE;

    private static int sortClicks = 0;

    private ObservableList<Movie> filteredMovies = FXCollections.observableArrayList();

    @FXML
    public Label sortingStatement;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values()); //get all values from enum Genre and fill the combo-box


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // working filter and query missing...
        searchBtn.setOnAction(event -> {

            if (genreComboBox.getSelectionModel().getSelectedItem() != null) {

                Genre tempSelectGenre = (Genre) genreComboBox.getSelectionModel().getSelectedItem();
                System.out.println(tempSelectGenre.toString()); //print selected genre to console

                List<Movie> tempMovies = new LinkedList<>();
                observableMovies.clear();
                for (Movie movie : allMovies) {
                    if (movie.getGenres().contains(tempSelectGenre)) {
                        tempMovies.add(movie);
                    }

                }
                observableMovies.addAll(tempMovies);
            }

            if (genreComboBox.getSelectionModel().getSelectedItem() == Genre.No_Filter) {
                observableMovies.clear();
                observableMovies.addAll(allMovies);
            }
        });


        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)") && sortClicks % 2 == 0) {
                this.sortMovies();

                sortBtn.setText("Sort (desc)");
                sortingStatement.setText("Sorting Order: Ascending");
            } else {

                observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
                sortState = SortState.DESCENDING;

                sortingStatement.setText("Sorting Order: Descending");
                sortBtn.setText("Sort (asc)");
            }
        });

        //search for query
        // to be continued...

    }

    public void initializeState() {
        observableMovies.clear();
        observableMovies.addAll(allMovies);
    }

    public void sortMovies() {
        observableMovies.sort(Comparator.comparing(Movie::getTitle));
        sortState = SortState.ASCENDING;
    }
}