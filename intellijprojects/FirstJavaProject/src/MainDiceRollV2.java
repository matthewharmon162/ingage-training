//import java.util.Scanner;
//import java.util.stream.IntStream;
//
//public class MainDiceRollV2 {
//
//    private static int highestTotal =0;
//    private static Scanner scanner = new Scanner(System.in);
//    private static DiceRollV2 d = new DiceRollV2();
//    private static PayOuts p = new PayOuts();
//    private static int [] diceRoll;
//    private static int roll;
//    private static int passBet;
//    private static int totalMoney;
//    private static int totalChange;
//    private static int j;
//    private static int i;
//  //  private static Game g = new Game();
//
//    public static void main(String[] args) {
//        Player p1 = new Player();
//
//        totalMoney = howMuchStartingMoney();
//        p1.setMoney(totalMoney);
//
//        Game g1 = new Game();
//
//        diceRoll = d.diceRoll();
//        g1.setRollResult(diceRoll);
//
//        System.out.println("What is your initial bet");
//        passBet = scanner.nextInt();
//
//        g1.setPassBetMoney(passBet);
//        totalChange  = g1.passAndComeBet();
//
//        totalMoney = totalMoney + totalChange;
//        p1.setMoney(totalMoney);
//
//
//    }
//
//    public static void comeAndOdds(){
//
//        j=0;
//
//        do {
//            System.out.println("What is your initial bet");
//            passBet = scanner.nextInt();
//
//
//            diceRoll = d.diceRoll();
//            roll= IntStream.of(diceRoll).sum();
//
//            totalMoney = howMuchMoneyAfterBet(totalMoney,passBet);
//
//            j++;
//
//            if (roll == 7 || roll == 11) {
//
//                totalMoney = howMuchMoneyAfterPassComeWin(totalMoney, passBet);
//
//            } else if (roll == 2 || roll == 3 || roll == 12) {
//
//                System.out.println("You lose: $" + passBet);
//                System.out.println("You now have: $" + totalMoney);
//
//            } else {
//                int point = roll;
//
//                System.out.println("Your point is: " + point);
//                int pointRoll;
//
//                System.out.println("What is your odds bet");
//                int oddsBet = scanner.nextInt();
//
//
//                i = 0;
//                totalMoney = totalMoney - oddsBet;
//
//                do {
//                    diceRoll = d.diceRoll();
//                    pointRoll = IntStream.of(diceRoll).sum();
//                    i++;
//                    System.out.println("You rolled: " + pointRoll);
//
//                    if (point == pointRoll) {
//                        totalMoney = howMuchMoneyAfterOddsWin(totalMoney, oddsBet, passBet, pointRoll);
//                        System.out.println("You have rolled " + i + " times");
//
//                    }else if (pointRoll == 7) {
//                        System.out.println("You lose: $" + (oddsBet + passBet));
//                        System.out.println("You now have: $" + totalMoney);
//                        System.out.println("You have rolled " + i + " times");
//                        break;
//
//                    }
//
//                } while (point != pointRoll);
//
//            }
//            if (highestTotal < totalMoney){
//                highestTotal = totalMoney;
//
//            }
//
//        }while(totalMoney > 0);
//        System.out.println("Highest total: $" + highestTotal);
//        System.out.println("You lasted " + j + " rounds");
//    }
//
//    public static int howMuchStartingMoney(){
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How much money do you have?");
//        int totalMoney = scanner.nextInt();
//        return totalMoney;
//
//    }
//    public static int howMuchMoneyAfterBet(int totalMoney, int passBet ){
//
//        int totalMoneyMinusPassBet = totalMoney - passBet;
//        return totalMoneyMinusPassBet;
//    }
//
//    public static int howMuchMoneyAfterPassComeWin(int totalMoney, int passBet){
//
//        int comeOutWin = p.comeOutPayOut(passBet);
//        int totalPassComeWinPayOut = totalMoney +  comeOutWin;
//        System.out.println("You now have: $" + totalPassComeWinPayOut);
//        return totalPassComeWinPayOut;
//    }
//    public static int howMuchMoneyAfterOddsWin(int totalMoney, int oddsBet, int passBet, int pointRoll){
//
//        int totalWin = p.pointPayOut(oddsBet, passBet, pointRoll);
//        int totalOddsWinPayout = totalMoney + totalWin;
//        System.out.println("You now have: $" + totalOddsWinPayout);
//        return totalOddsWinPayout;
//    }
////    public static int rollTotal(int dice1, int dice2){
////        int roll = dice1 + dice2;
////        System.out.println("You rolled: " + roll);
////        return roll;
////    }
//
//}
