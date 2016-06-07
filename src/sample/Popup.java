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


public class Popup {

    public static void alert(String title, ImageView picture, String message){
        //Stage setup
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        //Labels
        Label labelImage = new Label();
        Label labelText = new Label();

        //Button
        Button closeButton = new Button("Close");
        GridPane Grid = new GridPane();


        //Grid Pane setup

        //Label Modifications/Sets
        labelImage.setGraphic(picture);
        labelText.setText(message);
        labelText.setStyle("-fx-font-size: 32; -fx-font-family: Impact");

        //Button Action
        closeButton.setOnAction(e -> window.close());


        //Grid Pane Setup
        Grid.setGridLinesVisible(true);
        Grid.setVgap(10);
        Grid.setHgap(10);
        Grid.setPadding(new Insets(10, 10, 10, 10));
        //Add elements
        GridPane.setConstraints(labelImage, 0, 0);
        GridPane.setConstraints(labelText, 0, 1);
        GridPane.setConstraints(closeButton,0,2);
        Grid.getChildren().addAll(labelImage, labelText, closeButton);
        Grid.setHalignment(labelText, HPos.CENTER);
        Grid.setHalignment(closeButton, HPos.CENTER);

        //Add Grid Pane to the Scene
        Scene scene = new Scene(Grid);
        window.setScene(scene);
        window.showAndWait();
    }
}
