public class Account {
  private double money;

  private static int numberOfTransactions = 0;

  public Account(double startMoney){
    money = startMoney;
  }

  public void Withdraw(double amount){
    money -= amount;
  }

  public void Deposit(double amount){
    money += amount;
  }

  public double Balance(){
    return money;
  }
}
