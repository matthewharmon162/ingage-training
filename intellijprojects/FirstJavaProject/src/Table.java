//import java.util.stream.IntStream;
//
//class GameBoard {
//     double payOut;
//     int chipValue;
//
//    public GameBoard(double payOut){
//        this.payOut = payOut;
//    }
//
//    public void placeBet(int betAmount){
//        this.chipValue = betAmount;
//    }
//
//}
//
//public class Table {
//    private static DiceRollV2 d = new DiceRollV2();
//    private static PayOuts p = new PayOuts();
//    private static int [] diceRoll;
//    int point;
//    int deltaMoney;
//    double payOutMulitplyer;
//
//
//    Craps.GameBoard passLine = new Craps.GameBoard(2);
//    Craps.GameBoard odds = new Craps.GameBoard(payOutMulitplyer);
//
//    public int resolvePassLine(int roll) {
//
//        if (roll == 7 || roll == 11) {
//            deltaMoney =  (int)(passLine.chipValue * passLine.payOut);
//            return deltaMoney;
//
//        }if (roll == 2 || roll == 3 || roll == 12) {
//            deltaMoney = -passLine.chipValue;
//            return deltaMoney;
//
//        }else {
//            System.out.println("Your point is: " + roll);
//            deltaMoney = 0;
//            return deltaMoney;
//        }
//    }
//    public int resolveOdds(int roll) {
//        point = roll;
//        payOutMulitplyer = p.oddsPayOutMulitplyer(point);
//
//        do {
//            diceRoll = d.diceRoll();
//            roll = IntStream.of(diceRoll).sum();
//
//            if(point == roll) {
//                deltaMoney =  (int)((odds.chipValue * payOutMulitplyer)+(passLine.chipValue * passLine.payOut));
//
//
//            }else if(roll == 7){
//                deltaMoney = -(odds.chipValue + passLine.chipValue);
//                break;
//            }
//        } while (point != roll);
//         return deltaMoney;
//
//    }
//}
