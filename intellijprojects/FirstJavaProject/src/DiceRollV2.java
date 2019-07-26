import java.util.Random;

public class DiceRollV2 {


    public int [] diceRoll(){
        Random rand = new Random();
        int die1 = rand.nextInt(6)+1;
        System.out.println("Die 1: " + die1);
        int die2 = rand.nextInt(6)+1;
        System.out.println("Die 2: " + die2);
        int[] dieArray  = {die1, die2};
        return dieArray;
    }


}
