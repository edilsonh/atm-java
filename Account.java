public class Account {
  private double money;

  private static int totalWithdrawals = 0;

  public Account(double startMoney){
    money = startMoney;
  }

  public void Withdraw(double amount){
    if (totalWithdrawals > 4) {
      money -= 1.50;
    }
    money -= amount;
    totalWithdrawals += 1;
  }

  public void Deposit(double amount){
    money += amount;
  }

  public double Balance(){
    return money;
  }
}
