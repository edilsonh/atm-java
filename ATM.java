import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    withdraw.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if (isDouble(amount.getText())) {
          Double amountDouble = Double.parseDouble(amount.getText());
          if ((amountDouble % 20) == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Please take your money!", "Withdraw Successful!", JOptionPane.WARNING_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter a multiple of 20!", "Invalid Entry!", JOptionPane.WARNING_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Pleae enter a numerical amount!", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
        }
      }
    });
  }

  public static boolean isDouble(String s){
    try{
      Double.parseDouble(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static void main(String args[]){
    ATM atm = new ATM();
  }
}
