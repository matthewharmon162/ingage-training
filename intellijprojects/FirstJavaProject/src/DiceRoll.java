import java.util.Random;

public class DiceRoll {

    int intialBet;

    private int dice1;
    private int dice2;

    public  DiceRoll() {
        rollDice1();
        rollDice2();
    }

    public int rollDice1(){
        Random rand = new Random();
        dice1 = rand.nextInt(6)+1;
        return dice1;
    }
    public int rollDice2(){
        Random rand = new Random();

        dice2 = rand.nextInt(6)+1;
        return dice2;
    }

    public String getResult(){
        if (dice1+dice2 == 7){
            return "CRAP";
        }
        else{
            return "keep rolling";
        }
    }
    public int naturalWin(int naturalDollar){
        naturalDollar *= 2;
        return naturalDollar;
    }


    public int pointWin(int pointDollar, int diceRoll){
        if (diceRoll == 4 || diceRoll == 10){
            pointDollar *= (2);
        }if(diceRoll == 5 || diceRoll == 9)
            pointDollar *= (1.5);
        {if(diceRoll == 6 || diceRoll == 8)
            pointDollar *= (1.2);

        }
        return pointDollar;
    }

}
