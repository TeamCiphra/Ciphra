package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {

    public static ImageView ImageLoader(String imageName){
        //Attack
        Image imageAttackMelee = new Image(ImageLoader.class.getResourceAsStream("attackMelee.png"));
        Image imageBigDamage = new Image(ImageLoader.class.getResourceAsStream("bigdamage.jpg"));
        Image imageAttackMagic = new Image(ImageLoader.class.getResourceAsStream("attackMagic.png"));


        //Item
        Image imageItem = new Image(ImageLoader.class.getResourceAsStream("item.png"));

        //Run
        Image imageRun = new Image(ImageLoader.class.getResourceAsStream("run.png"));
        Image imageRunAway = new Image(ImageLoader.class.getResourceAsStream("runaway.jpg"));

        //Player
        Image playerOne = new Image(ImageLoader.class.getResourceAsStream("playerone.jpg"));
        Image playerTwo = new Image(ImageLoader.class.getResourceAsStream("playertwo.jpg"));

        if (imageName.equalsIgnoreCase("attack")){
            return new ImageView(imageAttackMelee);
        } else{
            return new ImageView(imageAttackMagic);
        }
    }
}
