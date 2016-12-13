package sample;

//Import
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.HashMap;


public class Main extends Application{

    //Scene Variables
    Stage window;
    Scene mainScene, items;
    final Insets GLOBAL_INSET = new Insets(5, 5, 5, 5);
    private HashMap gameStats = new HashMap();

    @Override
    public void start(Stage mainStage) throws Exception{
        //Main Stage
        window = mainStage;

        //Title
        mainStage.setTitle("Game Desu.exe");

        //StackPane
        StackPane mainStackPane = new StackPane();

        Button start = new Button("Start");//Start Battle

        //Set StackPane with the field and start button
        mainStackPane.getChildren().addAll(Loader.ImageLoader("field"), start);

        //StackPane Config
        start.setOnAction(e -> {
            gameStats.clear();
            //set stats
            gameStats.put("playerHP", 50);
            gameStats.put("playerEnergy", 100);
            gameStats.put("playerATT", 10);
            //set enemy stats
            gameStats.put("enemyHP", 200);
            gameStats.put("enemyATT", 5);
            //set item amount
            gameStats.put("amountHPPot", 10);
            gameStats.put("amountEnergyPot", 10);
            gameStats.put("amountATTPot", 10);
            gameStats.put("amountDevPot", 1337);
            //Turn Counter
            gameStats.put("timeCounter", 0);
            mainStackPane.getChildren().remove(start);
            Battle.display(gameStats, mainStage ,mainStackPane);
        });
        

        //Build Main
        mainScene = new Scene(mainStackPane, 854, 480);
        window.setScene(mainScene);//Make the window Scene
        mainStage.setResizable(false);// make window un-resizable
        mainStage.show();//Show
    }

    public static void main(String[]args){
        launch(args);
    }



}