package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Arrays;

public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail1 = new Label();
    private final Label detail2 = new Label();
    private final VBox layout = new VBox(title, detail1, detail2);

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setText(null);
            setGraphic(null);
        } else {
            this.getStyleClass().add("movie-cell");
            title.setText(movie.getTitle());
            detail1.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );

            detail2.setText(
                    movie.getGenres() != null
                            ? movie.getGenres().toString().replace("[","").replace("]","")
                            : "No genres available"
            );




            // color scheme
            title.getStyleClass().add("text-yellow");
            detail1.getStyleClass().add("text-white");
            detail2.getStyleClass().add("text-white");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

            // layout
            title.fontProperty().set(title.getFont().font(20));
            detail1.setMaxWidth(this.getScene().getWidth() - 30);
            detail1.setWrapText(true);
            detail2.setMaxWidth(this.getScene().getWidth() - 30);
            detail2.setWrapText(true);
            layout.setPadding(new Insets(10));
            layout.spacingProperty().set(10);
            layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);
            setGraphic(layout);
        }
    }
}

