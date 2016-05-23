package sample;
import java.util.Random;
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

    Stage window;
    Scene attackScene, items;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Random rand = new Random();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        Label attackLabel = new Label("This is the attack scene");
        primaryStage.setTitle("Attack Scene Test");

        Image imageItem = new Image(getClass().getResourceAsStream("item.png"));
        Button item = new Button();
        item.setGraphic(new ImageView(imageItem));
        item.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        item.setOnAction(e -> window.setScene(items));

        Image imageAttack = new Image(getClass().getResourceAsStream("attackMelee.png"));
        Button attack = new Button();
        attack.setGraphic(new ImageView(imageAttack));
        attack.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        Image imageBigDamage = new Image(getClass().getResourceAsStream("attackMagic.png"));
        attack.setOnAction(e -> Alerts.display("Warning!", imageBigDamage, (rand.nextInt(80) + 21) + " DAMAGE!!!"));

        Image imageRun = new Image(getClass().getResourceAsStream("run.png"));
        Button run = new Button();
        run.setGraphic(new ImageView(imageRun));
        run.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        Image imageRunAway = new Image(getClass().getResourceAsStream("run.png"));
        run.setOnAction(e -> Alerts.display("Warning!", imageRunAway, "RUN AWAY"));

        Image imageHealth = new Image(getClass().getResourceAsStream("greenBar.png"));
        Label health = new Label();
        health.setGraphic(new ImageView(imageHealth));
        health.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        Image imageHealthBar = new Image(getClass().getResourceAsStream("greenBar.png"));
        health.(e -> Alerts.display("Your Health", imageHealthBar, (rand.nextInt(40)+1) + "/40"));

        Image enemyHealth = new Image(getClass().getResourceAsStream("greenBar.png"));
        Button eHealth = new Button();
        eHealth.setGraphic(new ImageView(enemyHealth));
        eHealth.setStyle("-fx-base: #8080ff; -fx-focus-color: transparent");
        Image imageEHealthBar = new Image(getClass().getResourceAsStream("greenBar.png"));
        eHealth.setOnAction(e -> Alerts.display("Enemy Health", imageEHealthBar, (rand.nextInt(40)+1) + "/40"));

        GridPane battle = new GridPane();
        battle.setGridLinesVisible(false);
        battle.setPrefSize(854, 480);
        battle.setVgap(10);
        battle.setHgap(10);
        battle.setPadding(new Insets(10, 10, 10, 10));
        battle.setAlignment(Pos.CENTER);

        GridPane.setConstraints(attackLabel, 0, 2);
        GridPane.setConstraints(attack, 1, 3);
        GridPane.setConstraints(item, 2, 3);
        GridPane.setConstraints(run, 3, 3);
        GridPane.setConstraints(health, 0, 0);
        GridPane.setConstraints(eHealth, 3, 0);

        battle.getChildren().addAll(attackLabel, attack, item, run, health, eHealth);
        battle.setHalignment(attackLabel, HPos.CENTER);
        battle.setHalignment(attack, HPos.CENTER);
        battle.setHalignment(item, HPos.CENTER);
        battle.setHalignment(run, HPos.CENTER);
        battle.setHalignment(health, HPos.CENTER);
        battle.setHalignment(eHealth, HPos.CENTER);

        attackScene = new Scene(battle, 854, 480);

        Button back = new Button("Go back");
        back.setOnAction(e -> window.setScene(attackScene));

        StackPane itemBag = new StackPane();
        itemBag.getChildren().add(back);
        items = new Scene(itemBag,200,200);

        window.setScene(attackScene);
        primaryStage.show();
    }

    public static void main(String[]args){
        launch(args);
    }

}
