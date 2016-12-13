package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Loader {

    //Null
    static Image imageNull = new Image(Loader.class.getResourceAsStream("null.png"));

    public static ImageView ImageLoader(String imageName){
        //Attack
        Image imageAttackMelee = new Image(Loader.class.getResourceAsStream("attackMelee.png"));
        Image imageAttackMagic = new Image(Loader.class.getResourceAsStream("attackMagic.png"));
        Image imageBigDamage = new Image(Loader.class.getResourceAsStream("bigdamage.jpg"));

        //Item
        Image imageItem = new Image(Loader.class.getResourceAsStream("item.png"));
        Image imageItemBag = new Image(Loader.class.getResourceAsStream("itembag.png"));
        Image imageHPPot = new Image(Loader.class.getResourceAsStream("HP_Pot.png"));
        Image imageEnergyPot = new Image(Loader.class.getResourceAsStream("MP_Pot.png"));
        Image imageAttackPot = new Image(Loader.class.getResourceAsStream("ATT_Pot.png"));

        //Run
        Image imageRun = new Image(Loader.class.getResourceAsStream("run.png"));
        Image imageRunAway = new Image(Loader.class.getResourceAsStream("runaway.jpg"));


        //Field
        Image imageField = new Image(Loader.class.getResourceAsStream("field.png"));

        //Image Switch
        //Need to rewrite as case switch
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
        } else if(imageName.equalsIgnoreCase("field")){
            ImageView field = new ImageView(imageField);
            field.setFitWidth(854);
            field.setPreserveRatio(true);
            return field;
        } else if(imageName.equalsIgnoreCase("item bag")){
            ImageView itemBag = new ImageView(imageItemBag);
            return itemBag;
        } else if(imageName.equalsIgnoreCase("hp_pot")){
            return new ImageView(imageHPPot);
        } else if(imageName.equalsIgnoreCase("mp_pot")){
            return new ImageView(imageEnergyPot);
        } else if(imageName.equalsIgnoreCase("attack_pot")){
            return new ImageView(imageAttackPot);
        } else{
            //return null for errors
            return new ImageView(imageNull);
        }
    }

    public static ImageView PlayerLoader(String playerName){

        //Player
        Image imagePlayerOne = new Image(Loader.class.getResourceAsStream("playerone.png"));
        Image imagePlayerTwo = new Image(Loader.class.getResourceAsStream("playertwo.gif"));
        Image imagePlayerThree = new Image(Loader.class.getResourceAsStream("playerthree.gif"));

        int playertwoRandomInt = new Random().nextInt(1) + 1;

        if (playerName.equalsIgnoreCase("playerone")){
            return new ImageView(imagePlayerOne);
        } else if(playerName.equalsIgnoreCase("playertwo")){
            if (playertwoRandomInt == 0){
                return new ImageView(imagePlayerTwo);
            } else if (playertwoRandomInt == 1){
                return new ImageView(imagePlayerThree);
            } else{
                return new ImageView(imageNull);
            }
        } else{
            return new ImageView(imageNull);
        }
    }
}
