package sample;

//Import
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
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
        //Main Stage
        window = mainStage;

        //Title
        mainStage.setTitle("Game Desu.exe");

        //StackPane
        StackPane mainStackPane = new StackPane();

        //GridPanes
        GridPane sceneBattle = new GridPane();//Battle Scene GridPane
        GridPane coreGridPane = new GridPane();//Core GridPane
        GridPane attackGrid = new GridPane();//Attack GridPane
        GridPane buttonGrid = new GridPane();//Button Field GridPane


        //Labels
        Label playerOneSprite = new Label();
        playerOneSprite.setGraphic(Loader.ImageLoader("playerone"));
        Label playerOneWeapon = new Label("This is player One's weapon");
        Label playerTwoSprite = new Label();
        playerTwoSprite.setGraphic(Loader.ImageLoader("playertwo"));
        Label playerTwoWeapon = new Label("This is player Two's weapon");
        Label battlePrompt = new Label("Please choose an option.");

        //Buttons
        Button attack = new Button();//Attack Button
        Button attackMelee = new Button();//AttackMelee Button
        Button attackMagic = new Button();//AttackMagic Button
        Button item = new Button();//Item Button
        Button run = new Button();//Run Button
        Button start = new Button("Start");//Start Battle

        //Set StackPane with the field and start button
        mainStackPane.getChildren().addAll(Loader.ImageLoader("field"), start);

        //StackPane Config
        start.setOnAction(e -> {
            mainStackPane.getChildren().remove(start);
            mainStackPane.getChildren().add(coreGridPane);
        });


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

        //Attack Melee
        attackMelee.setGraphic(Loader.ImageLoader("attackmelee"));
        attackMelee.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        attackMelee.setMinWidth(329);//Layout min


        //Attack Magic
        attackMagic.setGraphic(Loader.ImageLoader("attackmagic"));
        attackMagic.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        attackMagic.setMinWidth(329);//Layout min


        //Item Button
        item.setGraphic(Loader.ImageLoader("item"));//Set Button Image
        item.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button Formatting
        item.setOnAction(e -> {
            //Stack Pane for item overlay

            //TableView
            TableView<ItemBag> itemBagTable;
            //Table Column
            TableColumn<ItemBag, String> itemNameColumn = new TableColumn<>("Item Name");
            itemNameColumn.setMinWidth(200);
            itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            TableColumn<ItemBag, Integer> itemValueColumn = new TableColumn<>("Amount");
            itemValueColumn.setMaxWidth(50);
            itemValueColumn.setCellValueFactory(new PropertyValueFactory<>("itemAmount"));
            //TableView Setup
            itemBagTable = new TableView<>();
            itemBagTable.setItems(getItemBag());
            itemBagTable.setColumnResizePolicy();
            itemBagTable.getColumns().addAll(itemNameColumn, itemValueColumn);

            //Button
            Button goBack = new Button("Go back");

            //Item Bag Grid Pane
            GridPane itemBagGridPane = new GridPane();
            itemBagGridPane.setGridLinesVisible(true);
            itemBagGridPane.setPadding(GLOBAL_INSET);
            itemBagGridPane.setConstraints(itemBagTable, 0, 0);
            itemBagGridPane.setConstraints(goBack, 1, 1);
            itemBagGridPane.getChildren().addAll(itemBagTable,goBack);

            mainStackPane.getChildren().add(itemBagGridPane);
            //Stack Pane fall back
            goBack.setOnAction(f -> mainStackPane.getChildren().remove(itemBagGridPane));
        });//Lambda Action

        //Run Button
        run.setGraphic(Loader.ImageLoader("run"));//Set Button Image
        run.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");//Button formatting
        run.setOnAction(e -> {
            //Run Away Alert
            Alerts.display("Warning!", Loader.ImageLoader("runaway"), "RUN AWAY");
            //Stack Pane full reset
            mainStackPane.getChildren().remove(coreGridPane);
            mainStackPane.getChildren().add(start);
        });//Lambda Action

        //Button Config End

        //GridPane Config Start

        coreGridPane.setGridLinesVisible(true);
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
        buttonGrid.setGridLinesVisible(true);
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


        //Build Main
        mainScene = new Scene(mainStackPane, 854, 480);

        //New Back Button for Bag
        Button back = new Button("Go back");
        back.setOnAction(e -> window.setScene(mainScene));//Lambda Action


        //SP for new image
        StackPane itemBag = new StackPane();
        itemBag.getChildren().add(back);
        items = new Scene(itemBag,854, 480);

        window.setScene(mainScene);//Make the window Scene
        mainStage.setResizable(false);
        mainStage.show();//Show
    }


    public ObservableList<ItemBag> getItemBag(){
        ObservableList<ItemBag> itemBag = FXCollections.observableArrayList();
        itemBag.add(new ItemBag("Health Pot", 1337));
        itemBag.add(new ItemBag("Energy Pot", 1337));
        itemBag.add(new ItemBag("Sanic Pot", 1337));
        return itemBag;
    }

    public static void main(String[]args){
        launch(args);
    }

}