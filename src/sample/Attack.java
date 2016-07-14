package sample;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Attack {

    static int playerHP, playerEnergy, playerATT, enemyHP, enemyATT, timeCounter;
    static double attPercent, defPercent;


    public static HashMap meleeAttack(HashMap gameStats){
        playerHP = (int)gameStats.get("playerHP");
        playerEnergy = (int)gameStats.get("playerEnergy");
        playerATT = (int)gameStats.get("playerATT");

        enemyHP = (int)gameStats.get("enemyHP");
        enemyATT = (int)gameStats.get("enemyATT");

        timeCounter = (int)gameStats.get("timeCounter");

        if (timeCounter % 2 == 0){
            //Player Attack

            //Multiples
            attPercent = ThreadLocalRandom.current().nextDouble(0.8, 1.2);
            defPercent = ThreadLocalRandom.current().nextDouble(0.8,1.2);

            //Calculate Damage
            playerATT = (int)(playerATT * attPercent);
            playerATT = (int)(playerATT / defPercent);
            enemyHP -= playerATT;
            timeCounter++;
            gameStats.put("enemyHP", enemyHP);
            gameStats.put("timeCounter", timeCounter);
        } else if (timeCounter % 2 != 0){
            //Enemy Attack

            //Multiples
            attPercent = ThreadLocalRandom.current().nextDouble(0.8, 1.2);
            defPercent = ThreadLocalRandom.current().nextDouble(0.8, 1.2);

            //Calculate Damage
            enemyATT = (int)(enemyATT * attPercent);
            enemyATT = (int)(enemyATT / defPercent);
            playerHP -= enemyATT;
            timeCounter++;
            gameStats.put("playerHP", playerHP);
            gameStats.put("timeCounter", timeCounter);
        }
        return gameStats;
    }
}
