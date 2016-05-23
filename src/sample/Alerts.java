package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Alerts {

    public static void display(String title, ImageView picture, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label labelImage = new Label();
        labelImage.setGraphic(picture);
        Label labelText = new Label();
        labelText.setText(message);
        labelText.setStyle("-fx-font-size: 32; -fx-font-family: Impact");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        GridPane Grid = new GridPane();
        Grid.setGridLinesVisible(true);
        Grid.setVgap(10);
        Grid.setHgap(10);
        Grid.setPadding(new Insets(10, 10, 10, 10));

        GridPane.setConstraints(labelImage, 0, 0);
        GridPane.setConstraints(labelText, 0, 1);
        GridPane.setConstraints(closeButton,0,2);
        Grid.getChildren().addAll(labelImage, labelText, closeButton);
        Grid.setHalignment(labelText, HPos.CENTER);
        Grid.setHalignment(closeButton, HPos.CENTER);


        Scene scene = new Scene(Grid);
        window.setScene(scene);
        window.showAndWait();

    }
}
