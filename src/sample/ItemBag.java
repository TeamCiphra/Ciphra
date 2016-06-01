package sample;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ItemBag {
    //Instance Variables
    private String itemName;
    private int itemAmount;

    public ItemBag(){
        itemName = "";
        itemAmount = 0;
    }

    public ItemBag(String name, int value){
        itemName = name;
        itemAmount = value;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount){
        this.itemAmount = itemAmount;
    }

    public static void display(int hp, int mp, int att){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Item Bag");
        window.setMinWidth(250);

        //Items
        ItemBag itemOne = new ItemBag("HP Pot", hp);
        ItemBag itemTwo = new ItemBag("Energy Pot", mp);
        ItemBag itemThree = new ItemBag("Damage Pot", att);

        //Labels
        Label itemOneLabel = new Label(itemOne.getItemName() + " x" + itemOne.getItemAmount());
//        itemOneLabel.textProperty().bind();
        Label itemTwoLabel = new Label(itemTwo.getItemName() + " x" + itemTwo.getItemAmount());
        Label itemThreeLabel = new Label(itemThree.getItemName() + " x" + itemThree.getItemAmount());

        //Buttons
        Button itemOneButton = new Button();
        itemOneButton.setGraphic(Loader.ImageLoader("hp_pot"));
        itemOneButton.setOnAction(e -> {
            itemOne.setItemAmount(itemOne.getItemAmount() - 1);
            itemOneLabel.setText(itemOne.getItemName() + " x" + itemOne.getItemAmount());
        });
        Button itemTwoButton = new Button();
        itemTwoButton.setGraphic(Loader.ImageLoader("mp_pot"));
        Button itemThreeButton = new Button();
        itemThreeButton.setGraphic(Loader.ImageLoader("attack_pot"));

        //HP Item Grid Pane
        GridPane itemOneGridPane = new GridPane();
        itemOneGridPane.setConstraints(itemOneButton, 0, 0);
        itemOneGridPane.setConstraints(itemOneLabel, 0, 1);
        itemOneGridPane.getChildren().addAll(itemOneButton, itemOneLabel);

        Scene bag = new Scene(itemOneGridPane);
        window.setScene(bag);
        window.show();
    }
}

