public class Account {
  private double money;

  private static int totalWithdrawals = 0;

  public Account(double startMoney){
    money = startMoney;
  }

  public void Withdraw(double amount) throws InsufficientFundsException{
    if (amount < this.money) {
      if (totalWithdrawals > 4) {
        money -= 1.50;
      }
      money -= amount;
      totalWithdrawals += 1;
    } else {
      throw new InsufficientFundsException(
        "Not enough money"
      );
    }
  }

  public void Deposit(double amount){
    money += amount;
  }

  public double Balance(){
    return money;
  }
}
