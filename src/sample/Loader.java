package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Loader {

    public static ImageView ImageLoader(String imageName){
        //Attack
        Image imageAttackMelee = new Image(Loader.class.getResourceAsStream("attackMelee.png"));
        Image imageAttackMagic = new Image(Loader.class.getResourceAsStream("attackMagic.png"));
        Image imageBigDamage = new Image(Loader.class.getResourceAsStream("bigdamage.jpg"));

        //Item
        Image imageItem = new Image(Loader.class.getResourceAsStream("item.png"));

        //Run
        Image imageRun = new Image(Loader.class.getResourceAsStream("run.png"));
        Image imageRunAway = new Image(Loader.class.getResourceAsStream("runaway.jpg"));

        //Player
        Image imagePlayerOne = new Image(Loader.class.getResourceAsStream("playerone.jpg"));
        Image imagePlayerTwo = new Image(Loader.class.getResourceAsStream("playertwo.jpg"));

        //Null
        Image imageNull = new Image(Loader.class.getResourceAsStream("null.png"));

        if (imageName.equalsIgnoreCase("attackmelee")){
            return new ImageView(imageAttackMelee);
        } else if(imageName.equalsIgnoreCase("attackmagic")){
            return new ImageView(imageAttackMagic);
        } else if(imageName.equalsIgnoreCase("bigdamage")){
            return new ImageView(imageBigDamage);
        } else if(imageName.equalsIgnoreCase("item")){
            return new ImageView(imageItem);
        } else if(imageName.equalsIgnoreCase("run")){
            return new ImageView(imageRun);
        } else if(imageName.equalsIgnoreCase("runaway")){
            return new ImageView(imageRunAway);
        } else if(imageName.equalsIgnoreCase("playerone")){
            return new ImageView(imagePlayerOne);
        } else if(imageName.equalsIgnoreCase("playertwo")){
            return new ImageView(imagePlayerTwo);
        } else{
            return new ImageView(imageNull);
        }
    }
}
