package Craps;

import Craps.Table;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MainDiceRollV4 {

    private static int totalMoney;
    private static int bet;
    private static int roll;
    private static int pointNumber;
    private static DiceRollV d = new DiceRollV();
    private static int [] diceRoll;
    private static int deltaMoney;
    private static int payOutMulitplyer;
    private static String status;
    private static Scanner scanner = new Scanner(System.in);
    public static String response;
    public static boolean keepPlaying = true;

    public static void main(String[] args) {

        GameBoard passLine = new GameBoard(2, bet, pointNumber, status );

        GameBoard odds = new GameBoard(payOutMulitplyer, bet, pointNumber, status);












        totalMoney = howMuchStartingMoney();
        Player playerOne = new Player(totalMoney);
        Table table = new Table();

        // loop

        while(keepPlaying){
            System.out.println("Pass Line Bet");
            bet = howMuchIsBet();
            playerOne.betMoney(bet);

            diceRoll = d.diceRoll();
            roll = IntStream.of(diceRoll).sum();

            table.passLine.placeBet(bet);
            deltaMoney = table.resolvePassLine(roll);

            if (deltaMoney == 0) {
                System.out.println("Odds Bet");
                bet = howMuchIsBet();

                playerOne.betMoney(bet);
                table.odds.placeBet(bet);

                deltaMoney = table.resolveOdds(roll);
            }
            if (deltaMoney > 0) {
                playerOne.winMoney(deltaMoney);
            }
            if (deltaMoney < 0) {
                playerOne.looseMoney(deltaMoney);
            }
            keepPlaying = keepPlaying();
        }
    }

    public static int howMuchStartingMoney(){
        System.out.println("How much money do you have?");
        totalMoney = scanner.nextInt();
        return totalMoney;
    }
    public static int howMuchIsBet(){
        System.out.println("What is your bet: ");
        bet = scanner.nextInt();
        return bet;
    }
    public static boolean keepPlaying(){
        System.out.println("Do you want to keep gambling");
        Scanner scanners = new Scanner(System.in);
        response = scanners.nextLine();
        if(response.equals("no")){
            keepPlaying = false;
        }else {
            keepPlaying = true;
        }
        return keepPlaying;
    }
}

