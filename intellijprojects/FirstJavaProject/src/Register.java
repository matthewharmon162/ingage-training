public class Register {

    public static void main(String[] args){
        Book twoCities = new Book("A tale of two cities",
                "charles",
                "7.99");

        Purchase purchase = new Purchase();
        purchase.buy(twoCities);

        System.out.println(purchase);
    }
}
