package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.HashMap;

public class Battle {


    static final Insets GLOBAL_INSET = new Insets(5, 5, 5, 5);
    static HashMap gameStats;


    public static HashMap display(HashMap gameStat, Stage mainStage, StackPane mainStackPane){
        //gameStat to gameStats Unload
        gameStats = gameStat;

        //GridPanes
        GridPane sceneBattle = new GridPane();//Battle Scene GridPane
        GridPane coreGridPane = new GridPane();//Core GridPane
        GridPane attackGrid = new GridPane();//Attack GridPane
        GridPane buttonGrid = new GridPane();//Button Field GridPane


        //Labels
        Label playerOneSprite = new Label();
        playerOneSprite.setGraphic(Loader.PlayerLoader("playerone"));
        //weapon placeholder
        Label playerOneWeapon = new Label("This is player One's weapon");

        Label playerTwoSprite = new Label();
        playerTwoSprite.setGraphic(Loader.PlayerLoader("playertwo"));
        //weapon placeholder
        Label playerTwoWeapon = new Label("This is player Two's weapon");
        Label battlePrompt = new Label("Please choose an option.");

        //Buttons
        Button attack = new Button();//Attack Button
        Button attackMelee = new Button();//AttackMelee Button
        Button attackMagic = new Button();//AttackMagic Button
        Button item = new Button();//Item Button
        Button run = new Button();//Run Button


        //Button Configs Start
        //Attack Button
        attack.setGraphic(Loader.ImageLoader("attackmelee"));//Set Button Image
        attack.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        attack.setOnAction(e -> {
                    //Button Scene Shift
                    coreGridPane.getChildren().remove(battlePrompt);
                    coreGridPane.add(attackGrid, 0, 1);
                    coreGridPane.getChildren().remove(buttonGrid);
                    Button goBack = new Button("Go back");
                    //configure button dimension
                    goBack.setMinHeight(36);
                    goBack.setMinWidth(156);
                    coreGridPane.add(goBack, 1, 1);
                    coreGridPane.setHalignment(goBack, HPos.CENTER);
                    //Reset
                    goBack.setOnAction(f -> {
                                coreGridPane.getChildren().remove(attackGrid);
                                coreGridPane.add(battlePrompt, 0, 1);
                                coreGridPane.getChildren().remove(goBack);
                                coreGridPane.add(buttonGrid, 1, 1);
                            }
                    );
                }
        );//Lambda Action


        //Battle scene integration
        Label playerHealth = new Label("Hit Points: ");
        playerHealth.setContentDisplay(ContentDisplay.TOP);
        playerHealth.setWrapText(true);
        playerHealth.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        //modified variable playerHealth based on items
        playerHealth.setOnMouseEntered(e -> playerHealth.setText((int)gameStats.get("playerHP") + "/50"));
        playerHealth.setOnMouseExited(e -> playerHealth.setText("Hit Points: "));

        Label enemyHealth = new Label("Hit Points: ");
        enemyHealth.setContentDisplay(ContentDisplay.TOP);
        enemyHealth.setWrapText(true);
        enemyHealth.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        //modified variable enemyHealth based on items
        enemyHealth.setOnMouseEntered(e -> enemyHealth.setText((int)gameStats.get("enemyHP") + "/200"));
        enemyHealth.setOnMouseExited(e -> enemyHealth.setText("Hit Points: "));

        //Attack Melee
        attackMelee.setGraphic(Loader.ImageLoader("attackmelee"));
        attackMelee.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        attackMelee.setMinWidth(329);//Layout min
        attackMelee.setOnAction(e -> Attack.meleeAttack(gameStats));


        //Attack Magic
        attackMagic.setGraphic(Loader.ImageLoader("attackmagic"));
        attackMagic.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        attackMagic.setMinWidth(329);//Layout min


        //Item Button
        item.setGraphic(Loader.ImageLoader("item"));//Set Button Image
        item.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        item.setOnAction(e -> gameStats = ItemBag.display(gameStats, mainStage));//Lambda Action

        //Run Button
        run.setGraphic(Loader.ImageLoader("run"));//Set Button Image
        run.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button formatting
        run.setOnAction(e -> {
            //Run Away Alert
            Popup.alert("Warning!", Loader.ImageLoader("runaway"), "RUN AWAY");
            //Stack Pane full reset
            mainStackPane.getChildren().remove(coreGridPane);
            //IDK how to get back right now
        });//Lambda Action

        //Button Config End


        //GridPane Config Start

        //Main GP Formatting
        coreGridPane.setVgap(5);
        coreGridPane.setHgap(5);
        coreGridPane.setPadding(GLOBAL_INSET);
        coreGridPane.setAlignment(Pos.CENTER);
        //Main GP GP Placement
        coreGridPane.setConstraints(sceneBattle, 0, 0);
        coreGridPane.setColumnSpan(sceneBattle, coreGridPane.REMAINING);
        coreGridPane.setConstraints(battlePrompt, 0, 1);
        coreGridPane.setConstraints(buttonGrid, 1, 1);
        coreGridPane.getColumnConstraints().add(new ColumnConstraints(674));
        coreGridPane.getColumnConstraints().add(new ColumnConstraints(170));


        //Add Elements
        coreGridPane.getChildren().addAll(sceneBattle, battlePrompt, buttonGrid);
        coreGridPane.setHalignment(sceneBattle, HPos.CENTER);
        coreGridPane.setHalignment(battlePrompt, HPos.CENTER);
        coreGridPane.setHalignment(buttonGrid, HPos.CENTER);

        //Battle Scene
        sceneBattle.setHgap(5);
        sceneBattle.setPadding(GLOBAL_INSET);
        //place sprites and weapons in different cells
        sceneBattle.setConstraints(playerOneSprite, 0, 0);
        sceneBattle.setConstraints(playerHealth, 0, 0);
        sceneBattle.setConstraints(playerOneWeapon, 1, 0);
        sceneBattle.setConstraints(playerTwoWeapon, 2, 0);
        sceneBattle.setConstraints(playerTwoSprite, 3, 0);
        sceneBattle.setConstraints(enemyHealth, 3, 0);
        //Battle Scene Add Elements
        sceneBattle.getChildren().addAll(playerOneSprite, playerHealth, playerOneWeapon, playerTwoWeapon, playerTwoSprite, enemyHealth);
        sceneBattle.setHalignment(playerOneSprite, HPos.CENTER);
        sceneBattle.setValignment(playerHealth, VPos.BOTTOM);
        sceneBattle.setHalignment(playerOneWeapon, HPos.CENTER);
        sceneBattle.setHalignment(playerTwoWeapon, HPos.CENTER);
        sceneBattle.setHalignment(playerTwoSprite, HPos.CENTER);//center sprite 2
        sceneBattle.setValignment(enemyHealth, VPos.BOTTOM);

        //Attack Action Grid
        attackGrid.setHgap(5);
        attackGrid.setPadding(GLOBAL_INSET);
        attackGrid.setAlignment(Pos.CENTER);
        attackGrid.setConstraints(attackMelee, 0, 0);
        attackGrid.setConstraints(attackMagic, 1, 0);
        //Attack Action Grid Add Elements
        attackGrid.getChildren().addAll(attackMelee, attackMagic);
        attackGrid.setHalignment(attackMelee, HPos.CENTER);
        attackGrid.setHalignment(attackMagic, HPos.CENTER);
        attackGrid.getColumnConstraints().add(new ColumnConstraints(329));
        attackGrid.getColumnConstraints().add(new ColumnConstraints(329));

        //Main Button Grid
        buttonGrid.setHgap(5);
        buttonGrid.setPadding(GLOBAL_INSET);
        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setConstraints(attack, 0, 0);
        buttonGrid.setConstraints(item, 1, 0);
        buttonGrid.setConstraints(run, 2, 0);
        //Main Button Grid Add Elements
        buttonGrid.getChildren().addAll(attack, item, run);
        buttonGrid.setHalignment(attack, HPos.CENTER);
        buttonGrid.setHalignment(item, HPos.CENTER);
        buttonGrid.setHalignment(run, HPos.CENTER);


        //GridPane Config End

        mainStackPane.getChildren().add(coreGridPane);

        return gameStats;
    }
}
