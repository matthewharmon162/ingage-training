public class MainCoin {

    public static void main(String[] args){
        Coin c = new Coin();
        System.out.println("Intial: " + c.getFaceUp());
        for(int i =0; i<10; i++){
            c.flip();
            System.out.println("After Flip: " + c.getFaceUp());
        }
    }
}
