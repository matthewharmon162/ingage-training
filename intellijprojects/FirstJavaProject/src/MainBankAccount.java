public class MainBankAccount {

    public static void main(String[] args){

        BankAccount myBankAccount = new BankAccount(4141, 100);

        myBankAccount.deposit(-60);
        myBankAccount.withdraw(150);

        myBankAccount.deposit(100);
        myBankAccount.withdraw(200);
    }
}
