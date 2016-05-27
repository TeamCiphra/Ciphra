package sample;


import java.util.HashMap;

public class ItemBag {
    //Instance Variables
    HashMap itemBag = new HashMap();

    //Default Constructor
    public ItemBag(){
        itemBag.put("Health Potion", 0);
        itemBag.put("Energy Potion", 0);
        itemBag.put("Attack Boost Potion", 0);
        itemBag.put("Defense Boost Potion", 0);
        itemBag.put("Speed Boost Potion", 0);
    }

    public ItemBag(String classType){
        if (classType.equalsIgnoreCase("warrior")){
            itemBag.put("Health Potion", 2);
            itemBag.put("Energy Potion", 2);
            itemBag.put("Attack Boost Potion", 2);
            itemBag.put("Defense Boost Potion", 2);
            itemBag.put("Speed Boost Potion", 1);
        } else if (classType.equalsIgnoreCase("archer")){
            itemBag.put("Health Potion", 2);
            itemBag.put("Energy Potion", 2);
            itemBag.put("Attack Boost Potion", 2);
            itemBag.put("Defense Boost Potion", 1);
            itemBag.put("Speed Boost Potion", 2);
        } else if (classType.equalsIgnoreCase("dev")){
            itemBag.put("Health Potion", 1337);
            itemBag.put("Energy Potion", 1337);
            itemBag.put("Attack Boost Potion", 1337);
            itemBag.put("Defense Boost Potion",1337);
            itemBag.put("Speed Boost Potion", 1337);
        } else {
            itemBag.put("Health Potion", 0);
            itemBag.put("Energy Potion", 0);
            itemBag.put("Attack Boost Potion", 0);
            itemBag.put("Defense Boost Potion", 0);
            itemBag.put("Speed Boost Potion", 0);
        }


    }
}
