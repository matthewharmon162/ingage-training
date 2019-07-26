
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        Random rand = new Random();

        int randomNumber = rand.nextInt();
        int raandomNumberWithBound = rand.nextInt(10);
        System.out.println(randomNumber);
        System.out.println(raandomNumberWithBound);
    }


}
