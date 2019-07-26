public class Player {

    private int playersMoney;

    public Player (int playersMoney){
        this.playersMoney = playersMoney;
    }

    public void betMoney(int removeMoney){
        if(removeMoney > playersMoney){
            System.out.println("You cannot bet more than you have");
        }else{
            this.playersMoney = this.playersMoney - removeMoney;
        }
    }
    public void winMoney(int addMoney){
        System.out.println("Player has won $" + addMoney);
        this.playersMoney = this.playersMoney + addMoney;
        System.out.println("Player now has $" + this.playersMoney);
    }
    public void looseMoney(int minusMoney){
        System.out.println("Player has lost $" + -minusMoney);
        System.out.println("Player now has $" + this.playersMoney);
    }
}
