/*
* File: ATM.java
* Author: Edilson Hernandez
* Date: February 4, 2018
* Purpose: The purpose of this program is simulate an ATM. It perform four basic
* functions of Withdraw, Deposit, Transfer, and check Balance.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM extends JFrame {
  public ATM(double checkingInitialAmount, double savingsInitialAmount){
    Account checkingAccount= new Account(checkingInitialAmount);
    Account savingsAccount = new Account(savingsInitialAmount);
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
            try {
              if (checking.isSelected()) {
                checkingAccount.Withdraw(amountDouble);
                JOptionPane.showMessageDialog(new JFrame(), "Please take your money!", "Withdraw Successful!", JOptionPane.WARNING_MESSAGE);
              } else {
                savingsAccount.Withdraw(amountDouble);
                JOptionPane.showMessageDialog(new JFrame(), "Please take your money!", "Withdraw Successful!", JOptionPane.WARNING_MESSAGE);
              }
            } catch (InsufficientFundsException isf) {
              System.out.println(isf);
              JOptionPane.showMessageDialog(new JFrame(), "Your account did not have enough money to make this withdrawal!", "Not enough funds!!", JOptionPane.WARNING_MESSAGE);
            }
          } else {
            JOptionPane.showMessageDialog(new JFrame(), "Please enter a multiple of 20!", "Invalid Entry!", JOptionPane.WARNING_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Pleae enter a numerical amount!", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    deposit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if (isDouble(amount.getText())) {
          Double amountDouble = Double.parseDouble(amount.getText());
          if (checking.isSelected()) {
            checkingAccount.Deposit(amountDouble);
          } else {
            savingsAccount.Deposit(amountDouble);
          }
          JOptionPane.showMessageDialog(new JFrame(), "Money has been added to your account!", "Deposit Successfull!", JOptionPane.WARNING_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Please enter a numerical amount!", "Invalid Entry!", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    transfer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if (isDouble(amount.getText())) {
          Double amountDouble = Double.parseDouble(amount.getText());
          try {
            if (checking.isSelected()) {
              checkingAccount.Deposit(amountDouble);
              savingsAccount.Withdraw(amountDouble);
              JOptionPane.showMessageDialog(new JFrame(), "Money has been transferred!", "Transfer!", JOptionPane.WARNING_MESSAGE);
            } else {
              savingsAccount.Deposit(amountDouble);
              checkingAccount.Withdraw(amountDouble);
              JOptionPane.showMessageDialog(new JFrame(), "Money has been transferred!", "Transfer!", JOptionPane.WARNING_MESSAGE);
            }
          } catch (InsufficientFundsException isf) {
            System.out.println(isf);
            JOptionPane.showMessageDialog(new JFrame(), "Your account did not have enough money to make this transfer!", "Not enough funds!!", JOptionPane.WARNING_MESSAGE);
          }
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Please enter a numerical amount!", "Invalid Entry!", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    balance.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        double currentBalance = 0;
        if (checking.isSelected()) {
          currentBalance = checkingAccount.Balance();
        } else {
          currentBalance = savingsAccount.Balance();
        }
        String balanceText = "Your balance is $" + currentBalance;
        JOptionPane.showMessageDialog(new JFrame(), balanceText, "Balance!", JOptionPane.WARNING_MESSAGE);
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
    ATM atm = new ATM(3000, 6700);
  }
}
