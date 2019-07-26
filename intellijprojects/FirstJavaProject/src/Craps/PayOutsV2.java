package Craps;

public class PayOutsV2 {
    private static double odds;


    public double oddsPayOutMulitplyer( int diceRoll){

        if (diceRoll == 4 || diceRoll == 10){
            odds = 3;
        }if(diceRoll == 5 || diceRoll == 9)
            odds = 2.5;
        {if(diceRoll == 6 || diceRoll == 8)
            odds = 2.2;
        }

        return odds;
    }
}
