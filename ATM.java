import javax.swing.*;
import java.awt.*;

public class ATM extends JFrame {
  public ATM(){
    setTitle("ATM");
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(4,2));
    JButton withdraw = new JButton("Withdraw");
    JButton deposit = new JButton("Deposit");
    JButton transfer = new JButton("Transfer To");
    JButton balance = new JButton("Balance");
    JTextField amount = new JTextField("");
    /*
    * Button group is used to group together radio buttons and
    * allow for only one radio button to be selected at any
    * given time
    */
    ButtonGroup group = new ButtonGroup();
    JRadioButton checking = new JRadioButton("Checking", true);
    JRadioButton savings = new JRadioButton("Savings", false);
    group.add(checking);
    group.add(savings);
    add(withdraw);
    add(deposit);
    add(transfer);
    add(balance);
    add(checking);
    add(savings);
    add(amount);

    pack();
    setVisible(true);

    
  }

  public static void main(String args[]){
    ATM atm = new ATM();
  }
}
