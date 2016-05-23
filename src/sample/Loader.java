package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Loader {

    public static ImageView ImageLoader(String imageName){
        //Attack
        Image imageAttackMelee = new Image(Loader.class.getResourceAsStream("attackMelee.png"));
        Image imageBigDamage = new Image(Loader.class.getResourceAsStream("bigdamage.jpg"));
        Image imageAttackMagic = new Image(Loader.class.getResourceAsStream("attackMagic.png"));

        //Item
        Image imageItem = new Image(Loader.class.getResourceAsStream("item.png"));

        //Run
        Image imageRun = new Image(Loader.class.getResourceAsStream("run.png"));
        Image imageRunAway = new Image(Loader.class.getResourceAsStream("runaway.jpg"));

        //Player
        Image playerOne = new Image(Loader.class.getResourceAsStream("playerone.jpg"));
        Image playerTwo = new Image(Loader.class.getResourceAsStream("playertwo.jpg"));

        if (imageName.equalsIgnoreCase("attack")){
            return new ImageView(imageAttackMelee);
        } if else(imageName.equalsIgnoreCase(""))



        else{
            return new ImageView(imageAttackMagic);
        }
    }

    public static Label LabelLoader(String labelName){

    }
}
