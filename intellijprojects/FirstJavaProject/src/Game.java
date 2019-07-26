import java.util.stream.IntStream;

public class Game {

    private static DiceRollV2 d = new DiceRollV2();

    public boolean passAndComeBet(){
        int orginalTotal = IntStream.of(d.diceRoll()).sum();

        if (orginalTotal == 7 || orginalTotal == 11) {
            return true;
        }
        if (orginalTotal == 2 || orginalTotal == 3 || orginalTotal == 12) {
            return false;
        }
        while(true) {
            int newTotal = IntStream.of(d.diceRoll()).sum();
            if (orginalTotal == newTotal) {
                return true;
            }
            if (newTotal == 7)
                return false;
        }
    }
}
