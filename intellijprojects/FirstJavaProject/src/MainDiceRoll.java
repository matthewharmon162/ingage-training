import java.util.Scanner;

public class MainDiceRoll {
    private static int highestTotal =0;
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("How much money do you have?");
        int totalMoney = scanner.nextInt();
        int j=0;

        while (totalMoney > 0) {

//            System.out.println("What is your initial bet");
//            int yourBet =  scanner.nextInt();
            int yourBet = 10;

            DiceRoll d = new DiceRoll();
            int Dice1 = d.rollDice1();
            System.out.println("Dice1: " + Dice1);
            int Dice2 = d.rollDice1();
            System.out.println("Dice2: " + Dice2);
            int intialRoll = Dice1 + Dice2;
            int currentTotal = totalMoney;
            j++;

            if (intialRoll == 7 || intialRoll == 11) {
                int intialMoney = yourBet;
                int naturalWinMoney = d.naturalWin(yourBet);
                System.out.println("You win: " + (naturalWinMoney - intialMoney));
                totalMoney = totalMoney + naturalWinMoney - intialMoney;
                System.out.println("You now have: " + totalMoney);

            } else if (intialRoll == 2 || intialRoll == 3 || intialRoll == 12) {
                int intialMoney = yourBet;
                System.out.println("You lose: " + intialMoney);
                totalMoney = totalMoney - intialMoney;
                System.out.println("You now have: " + totalMoney);
            } else {
                int point = intialRoll;
                System.out.println("Your point is: " + point);
                int crapedInRoll;
                int i = 0;
                do {

                    Dice1 = d.rollDice1();
                    System.out.println("Dice1: " + Dice1);
                    Dice2 = d.rollDice1();
                    System.out.println("Dice2: " + Dice2);
                    crapedInRoll = Dice1 + Dice2;
                    i++;
                    System.out.println("You rolled: " + crapedInRoll);
                    if (crapedInRoll == 7) {
                        int oddsBet = yourBet * 2;
                        System.out.println("You lose: " + (oddsBet + yourBet));
                        totalMoney = totalMoney - oddsBet - yourBet;
                        System.out.println("You now have: " + totalMoney);
                        System.out.println("You have rolled " + i + " times");
                        break;
                    } else if (point == crapedInRoll) {
                        int oddsBet = yourBet * 2;
                        int oddsWin = d.pointWin(oddsBet, crapedInRoll);
                        System.out.println("You win: " + (yourBet + oddsWin));
                        totalMoney = totalMoney + oddsWin + yourBet;
                        System.out.println("You now have: " + totalMoney);
                        System.out.println("You have rolled " + i + " times");
                    }

                } while (point != crapedInRoll);

            }
            if (highestTotal < totalMoney){
                 highestTotal = totalMoney;

            }

        }
        System.out.println("Highest total: " + highestTotal);
        System.out.println("You lasted " + j + " rounds");

    }
}
