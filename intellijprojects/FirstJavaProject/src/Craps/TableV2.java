package Craps;

import java.util.stream.IntStream;

class GameBoard {
    double payOut;
    int chipValue;
    int pointNumber;
    String status;

    public GameBoard(double payOut, int chipValue, int pointNumber, String status){
        this.payOut = payOut;
        this.chipValue = chipValue;
        this.pointNumber = pointNumber;
        this.status = status;
    }

    public void setPayOut(int payOut){

        this.payOut = payOut;
    }

    public double getPayOut(){
        return this.payOut;
    }

    public void setChipValue(int chipValue){

        this.chipValue = chipValue;
    }

    public double getChipValue(){
        return this.chipValue;
    }

    public void placeBet(int betAmount){
        this.chipValue = betAmount;
    }



}

public class Table {
    private static DiceRollV d = new DiceRollV();
    private static PayOutsV2 p = new PayOutsV2();
    private static int [] diceRoll;
    int point;
    int deltaMoney;
    double payOutMulitplyer;


    GameBoard passLine = new GameBoard(2);
    GameBoard odds = new GameBoard(payOutMulitplyer);

    public int resolvePassLine(int roll) {

        if (roll == 7 || roll == 11) {
            deltaMoney =  (int)(passLine.chipValue * passLine.payOut);
            return deltaMoney;

        }if (roll == 2 || roll == 3 || roll == 12) {
            deltaMoney = -passLine.chipValue;
            return deltaMoney;

        }else {
            System.out.println("Your point is: " + roll);
            deltaMoney = 0;
            return deltaMoney;
        }
    }
    public int resolveOdds(int roll) {
        point = roll;
        payOutMulitplyer = p.oddsPayOutMulitplyer(point);

        do {
            diceRoll = d.diceRoll();
            roll = IntStream.of(diceRoll).sum();

            if(point == roll) {
                deltaMoney =  (int)((odds.chipValue * payOutMulitplyer)+(passLine.chipValue * passLine.payOut));


            }else if(roll == 7){
                deltaMoney = -(odds.chipValue + passLine.chipValue);
                break;
            }
        } while (point != roll);
         return deltaMoney;

    }
}
