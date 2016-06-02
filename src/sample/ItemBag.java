package sample;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;

public class ItemBag {
    //Instance Variables
    private String itemName;
    private int itemAmount;
    static int HP_Amount, Energy_Amount, ATT_Amount;

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



    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount){
        this.itemAmount = itemAmount;
    }

    public static HashMap display(HashMap playerStats, Stage parentStage){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Item Bag");
        window.setMinWidth(250);
        window.setMaxWidth(250);
        window.setMinHeight(250);
        window.setMaxHeight(250);

        //Move to local
        HP_Amount = (int)playerStats.get("HP_Pot_Amount");
        Energy_Amount = (int)playerStats.get("Energy_Pot_Amount");
        ATT_Amount = (int)playerStats.get("ATT_Pot_Amount");

        //Items
        ItemBag itemHPPot = new ItemBag("HP Pot", HP_Amount);
        ItemBag itemEnergyPot = new ItemBag("Energy Pot", Energy_Amount);
        ItemBag itemATTPot = new ItemBag("Damage Pot", ATT_Amount);

        //Labels
        Label itemHPPotLabel = new Label(itemHPPot.getItemName() + " x" + itemHPPot.getItemAmount());
        Label itemEnergyPotLabel = new Label(itemEnergyPot.getItemName() + " x" + itemEnergyPot.getItemAmount());
        Label itemATTPotLabel = new Label(itemATTPot.getItemName() + " x" + itemATTPot.getItemAmount());

        //Buttons
        Button itemHPPotButton = new Button();
        itemHPPotButton.setGraphic(Loader.ImageLoader("hp_pot"));
        itemHPPotButton.setOnAction(e -> {
            itemHPPot.setItemAmount(itemHPPot.getItemAmount() - 1);
            playerStats.put("HP_Pot_Amount", itemHPPot.getItemAmount());
            itemHPPotLabel.setText(itemHPPot.getItemName() + " x" + itemHPPot.getItemAmount());
        });
        Button itemEnergyPotButton = new Button();
        itemEnergyPotButton.setGraphic(Loader.ImageLoader("mp_pot"));
        itemEnergyPotButton.setOnAction(e -> {
            itemEnergyPot.setItemAmount(itemEnergyPot.getItemAmount() - 1);
            playerStats.put("Energy_Pot_Amount", itemEnergyPot.getItemAmount());
            itemEnergyPotLabel.setText(itemEnergyPot.getItemName() + " x" + itemEnergyPot.getItemAmount());
        });
        Button itemATTPotButton = new Button();
        itemATTPotButton.setGraphic(Loader.ImageLoader("attack_pot"));
        itemATTPotButton.setOnAction(e -> {
            itemATTPot.setItemAmount(itemATTPot.getItemAmount() - 1);
            playerStats.put("ATT_Pot_Amount", itemATTPot.getItemAmount());
            itemATTPotLabel.setText(itemATTPot.getItemName() + " x" + itemATTPot.getItemAmount());
        });
        Button goBack = new Button("Go Back");
        goBack.setOnAction(e -> window.close());

        //HP Item Grid Pane
        GridPane itemHPPotGridPane = new GridPane();
        itemHPPotGridPane.setHgap(5);
        itemHPPotGridPane.setConstraints(itemHPPotButton, 0, 0);
        itemHPPotGridPane.setConstraints(itemHPPotLabel, 1, 0);
        itemHPPotGridPane.getChildren().addAll(itemHPPotButton, itemHPPotLabel);

        //Energy Item Grid Pane
        GridPane itemEnergyPotGridPane = new GridPane();
        itemEnergyPotGridPane.setHgap(5);
        itemEnergyPotGridPane.setConstraints(itemEnergyPotButton, 0, 0);
        itemEnergyPotGridPane.setConstraints(itemEnergyPotLabel, 1, 0);
        itemEnergyPotGridPane.getChildren().addAll(itemEnergyPotButton, itemEnergyPotLabel);

        //ATT Item Grid Pane
        GridPane itemATTPotGridPane = new GridPane();
        itemATTPotGridPane.setHgap(5);
        itemATTPotGridPane.setConstraints(itemATTPotButton, 0, 0);
        itemATTPotGridPane.setConstraints(itemATTPotLabel, 1, 0);
        itemATTPotGridPane.getChildren().addAll(itemATTPotButton, itemATTPotLabel);

        //All Item Grid Pane
        GridPane itemBag = new GridPane();
        itemBag.setVgap(5);
        itemBag.setConstraints(itemHPPotGridPane, 0, 0);
        itemBag.setConstraints(itemEnergyPotGridPane, 0, 1);
        itemBag.setConstraints(itemATTPotGridPane, 0, 2);
        itemBag.setConstraints(goBack, 0, 3);
        itemBag.getChildren().addAll(itemHPPotGridPane, itemEnergyPotGridPane, itemATTPotGridPane, goBack);

        //Scroll Pane
        ScrollPane itemBagScrollPane = new ScrollPane();
        itemBagScrollPane.setPannable(true);
        itemBagScrollPane.setPrefWidth(150);
        itemBagScrollPane.setContent(itemBag);

        Scene bag = new Scene(itemBagScrollPane);
        window.setX(parentStage.getX() + 900);
        window.setY(parentStage.getY() + 100);
        window.setScene(bag);
        window.show();
        
        return playerStats;
    }
}

