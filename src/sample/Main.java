package sample;

//Import
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class Main extends Application{

    //Scene Variables
    Stage window;
    Scene mainScene, items;
    final Insets GLOBAL_INSET = new Insets(5, 5, 5, 5);

    @Override
    public void start(Stage mainStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Main Stage
        window = mainStage;

        //Title
        mainStage.setTitle("Game Desu.exe");

        //GridPanes
        GridPane sceneBattle = new GridPane();//Battle Scene GridPane
        GridPane coreGridPane = new GridPane();//Core GridPane
        GridPane attackGrid = new GridPane();//Attack GridPane
        GridPane buttonGrid = new GridPane();//Button Field GridPane

        //Image Loading Start

        //Attack
//        ImageView imageAttackMelee = new ImageView(new Image(getClass().getResourceAsStream("attackMelee.png")));
//        imageAttackMelee.setFitWidth(64);
//        imageAttackMelee.setFitHeight(64);
        ImageView imageBigDamage = new ImageView(new Image(getClass().getResourceAsStream("bigdamage.jpg")));
        ImageView imageAttackMagic = new ImageView(new Image(getClass().getResourceAsStream("attackMagic.png")));
        imageAttackMagic.setFitWidth(64);
        imageAttackMagic.setFitHeight(64);

        //Item
        ImageView imageItem = new ImageView(new Image(getClass().getResourceAsStream("item.png")));
        imageItem.setFitWidth(64);
        imageItem.setFitHeight(64);

        //Run
        ImageView imageRun = new ImageView(new Image(getClass().getResourceAsStream("run.png")));
        imageRun.setFitWidth(64);
        imageRun.setFitHeight(64);
        ImageView imageRunAway = new ImageView(new Image(getClass().getResourceAsStream("runaway.jpg")));

        //Player
        ImageView playerOne = new ImageView(new Image(getClass().getResourceAsStream("playerone.jpg")));
        ImageView playerTwo = new ImageView(new Image(getClass().getResourceAsStream("playertwo.jpg")));

        //Image Loading End

        //Labels
        Label playerOneSprite = new Label();
        playerOneSprite.setGraphic(playerOne);
        Label playerOneWeapon = new Label("This is player One's weapon");
        Label playerTwoSprite = new Label();
        playerTwoSprite.setGraphic(playerTwo);
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
        attack.setGraphic(ImageLoader.ImageLoader("attack"));//Set Button Image
        attack.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        attack.setOnAction(e -> {
                    coreGridPane.getChildren().remove(battlePrompt);
                    coreGridPane.add(attackGrid, 0, 1);
                    coreGridPane.getChildren().remove(buttonGrid);
                    Button goBack = new Button("Go back");
                    coreGridPane.add(goBack, 1, 1);
                    goBack.setOnAction(f -> {
                        coreGridPane.getChildren().remove(attackGrid);
                        coreGridPane.add(battlePrompt, 0, 1);
                        coreGridPane.getChildren().remove(goBack);
                        coreGridPane.add(buttonGrid, 1, 1);
                    }
                    );
        }
        );//Lambda Action

        //Attack Melee
        attackMelee.setGraphic(ImageLoader.ImageLoader("attack"));
        attackMelee.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");

        //Attack Magic
        attackMagic.setGraphic(imageAttackMagic);
        attackMagic.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");

        //Item Button
        item.setGraphic(imageItem);//Set Button Image
        item.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        item.setOnAction(e -> window.setScene(items));//Lambda Action

        //Run Button
        run.setGraphic(imageRun);//Set Button Image
        run.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button formatting
        run.setOnAction(e -> Alerts.display("Warning!", imageRunAway, "RUN AWAY"));//Lambda Action

        //Button Config End

        //GridPane Config Start

        //Main GP Formatting
        coreGridPane.setVgap(10);
        coreGridPane.setHgap(10);
        coreGridPane.setPadding(GLOBAL_INSET);
        coreGridPane.setAlignment(Pos.CENTER);
        //Main GP GP Placement
        coreGridPane.setConstraints(sceneBattle, 0, 0);
        coreGridPane.setConstraints(battlePrompt, 0, 1);
        coreGridPane.setConstraints(buttonGrid, 1, 1);

        //Add Elements
        coreGridPane.getChildren().addAll(sceneBattle, battlePrompt, buttonGrid);
        coreGridPane.setHalignment(sceneBattle, HPos.CENTER);
        coreGridPane.setHalignment(battlePrompt, HPos.CENTER);
        coreGridPane.setHalignment(buttonGrid, HPos.CENTER);

        //Battle Scene
        sceneBattle.setHgap(10);
        sceneBattle.setPadding(GLOBAL_INSET);
        sceneBattle.setConstraints(playerOneSprite, 0, 0);
        sceneBattle.setConstraints(playerOneWeapon, 1, 0);
        sceneBattle.setConstraints(playerTwoWeapon, 2, 0);
        sceneBattle.setConstraints(playerTwoSprite, 3, 0);
        //Battle Scene Add Elements
        sceneBattle.getChildren().addAll(playerOneSprite, playerOneWeapon, playerTwoWeapon, playerTwoSprite);
        sceneBattle.setHalignment(playerOneSprite, HPos.CENTER);
        sceneBattle.setHalignment(playerOneWeapon, HPos.CENTER);
        sceneBattle.setHalignment(playerTwoWeapon, HPos.CENTER);
        sceneBattle.setHalignment(playerTwoSprite, HPos.CENTER);


        //Attack Action Grid
        attackGrid.setGridLinesVisible(true);
        attackGrid.setHgap(10);
        attackGrid.setPadding(GLOBAL_INSET);
        attackGrid.setAlignment(Pos.CENTER);
        attackGrid.setConstraints(attackMelee, 0, 0);
        attackGrid.setConstraints(attackMagic, 1, 0);
        //Attack Action Grid Add Elements
        attackGrid.getChildren().addAll(attackMelee, attackMagic);
        attackGrid.setHalignment(attackMelee, HPos.CENTER);
        attackGrid.setHalignment(attackMagic, HPos.CENTER);


        //Main Button Grid
        buttonGrid.setHgap(10);
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


        //Build Main
        mainScene = new Scene(coreGridPane, 854, 480);

        //New Back Button for Bag
        Button back = new Button("Go back");
        back.setOnAction(e -> window.setScene(mainScene));//Lambda Action

        //SP for new image
        StackPane itemBag = new StackPane();
        itemBag.getChildren().add(back);
        items = new Scene(itemBag,854, 480);

        window.setScene(mainScene);//Make the window Scene
        mainStage.show();//Show
    }

    public static void main(String[]args){
        launch(args);
    }

}
