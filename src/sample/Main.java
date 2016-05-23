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
        mainStage.setTitle("Game_Desu.exe");

        //GP
        GridPane main = new GridPane();

        //Images
        ImageView imageAttackMelee = new ImageView(new Image(getClass().getResourceAsStream("attackMelee.png")));
        imageAttackMelee.setFitWidth(64);
        imageAttackMelee.setFitHeight(64);
        ImageView imageBigDamage = new ImageView(new Image(getClass().getResourceAsStream("bigdamage.jpg")));
        ImageView imageAttackMagic = new ImageView(new Image(getClass().getResourceAsStream("attackMagic.png")));
        imageAttackMagic.setFitWidth(64);
        imageAttackMagic.setFitHeight(64);
        ImageView imageItem = new ImageView(new Image(getClass().getResourceAsStream("item.png")));
        imageItem.setFitWidth(64);
        imageItem.setFitHeight(64);
        ImageView imageRun = new ImageView(new Image(getClass().getResourceAsStream("run.png")));
        imageRun.setFitWidth(64);
        imageRun.setFitHeight(64);
        ImageView imageRunAway = new ImageView(new Image(getClass().getResourceAsStream("runaway.jpg")));
        ImageView playerOne = new ImageView(new Image(getClass().getResourceAsStream("playertwo.jpg")));
        ImageView playTwo = new ImageView(new Image(getClass().getResourceAsStream("playerone.jpg")));

        //Labels
        Label playerOneSprite = new Label();
        playerOneSprite.setGraphic(playerOne);
        Label playerOneWeapon = new Label("This is player One's weapon");
        Label playerTwoSprite = new Label();
        playerTwoSprite.setGraphic(playTwo);
        Label playerTwoWeapon = new Label("This is player Two's weapon");
        Label battlePrompt = new Label("Please choose an option.");

        Button attack = new Button();//Attack Button Creation

        //Battle Scene GP
        GridPane sceneBattle = new GridPane();
        sceneBattle.setGridLinesVisible(true);//Grid Line Toggle
        //Battle Scene Formatting
        sceneBattle.setHgap(10);
        sceneBattle.setPadding(GLOBAL_INSET);
        //Battle Scene Placement
        sceneBattle.setConstraints(playerOneSprite, 0, 0);
        sceneBattle.setConstraints(playerOneWeapon, 1, 0);
        sceneBattle.setConstraints(playerTwoWeapon, 2, 0);
        sceneBattle.setConstraints(playerTwoSprite, 3, 0);
        //Add Elements
        sceneBattle.getChildren().addAll(playerOneSprite, playerOneWeapon, playerTwoWeapon, playerTwoSprite);
        sceneBattle.setHalignment(playerOneSprite, HPos.CENTER);
        sceneBattle.setHalignment(playerOneWeapon, HPos.CENTER);
        sceneBattle.setHalignment(playerTwoWeapon, HPos.CENTER);
        sceneBattle.setHalignment(playerTwoSprite, HPos.CENTER);

        //Attack Melee
        Button attackMelee = new Button();
        attackMelee.setGraphic(imageAttackMelee);
        attackMelee.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");

        //Attack Magic
        Button attackMagic = new Button();
        attackMagic.setGraphic(imageAttackMagic);
        attackMagic.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");

        //Attack GP
        GridPane attackGrid = new GridPane();
        attackGrid.setGridLinesVisible(true);
        attackGrid.setHgap(10);
        attackGrid.setPadding(GLOBAL_INSET);
        attackGrid.setAlignment(Pos.CENTER);
        attackGrid.setConstraints(attackMelee, 0, 0);
        attackGrid.setConstraints(attackMagic, 1, 0);
        attackGrid.getChildren().addAll(attackMelee,attackMagic);

        //Item Button
        Button item = new Button();//Item Button Creation
        item.setGraphic(imageItem);//Set Button Image
        item.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        item.setOnAction(e -> window.setScene(items));//Lambda Action

        //Run Button
        Button run = new Button();//Run Button Creation
        run.setGraphic(imageRun);//Set Button Image
        run.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button formatting
        run.setOnAction(e -> Alerts.display("Warning!", imageRunAway, "RUN AWAY"));//Lambda Action

        //Button GP
        GridPane buttonGrid = new GridPane();
        buttonGrid.setGridLinesVisible(true);//Show Grid Lines
        //Button GP Formatting
        buttonGrid.setHgap(10);
        buttonGrid.setPadding(GLOBAL_INSET);
        buttonGrid.setAlignment(Pos.CENTER);
        //Button GP Button Placement
        buttonGrid.setConstraints(attack, 0, 0);
        buttonGrid.setConstraints(item, 1, 0);
        buttonGrid.setConstraints(run, 2, 0);
        //Add Elements
        buttonGrid.getChildren().addAll(attack, item, run);
        buttonGrid.setHalignment(attack, HPos.CENTER);
        buttonGrid.setHalignment(item, HPos.CENTER);
        buttonGrid.setHalignment(run, HPos.CENTER);

        //Attack Button
        attack.setGraphic(imageAttackMelee);//Set Button Image
        attack.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        attack.setOnAction(e -> {
                    main.getChildren().remove(battlePrompt);
                    main.add(attackGrid, 0, 1);
                    main.getChildren().remove(buttonGrid);
                    Button goBack = new Button("Go back");
                    main.add(goBack, 1, 1);
                    goBack.setOnAction(f -> {
                        main.getChildren().remove(attackGrid);
                        main.add(battlePrompt, 0, 1);
                        main.getChildren().remove(goBack);
                        main.add(buttonGrid, 1, 1);
                    });


                }
        );//Lambda Action



        main.setGridLinesVisible(true);//Grid Line Toggle
        //Main GP Formatting
        main.setVgap(10);
        main.setHgap(10);
        main.setPadding(GLOBAL_INSET);
        main.setAlignment(Pos.CENTER);
        //Main GP GP Placement
        main.setConstraints(sceneBattle, 0, 0);
        main.setConstraints(battlePrompt, 0, 1);
        main.setConstraints(buttonGrid, 1, 1);

        //Add Elements
        main.getChildren().addAll(sceneBattle, battlePrompt, buttonGrid);
        main.setHalignment(sceneBattle, HPos.CENTER);
        main.setHalignment(battlePrompt, HPos.CENTER);
        main.setHalignment(buttonGrid, HPos.CENTER);


        //Build Main
        mainScene = new Scene(main, 854, 480);

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
