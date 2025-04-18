package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, miniStatement, pinChange, fastCash, balanceEnquiry, exit;
    String pinnumber;
    Transactions(String pinnumber) {
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Transaction Selection Label
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200, 300, 700, 35); // Adjusted for better alignment
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Left Side Buttons
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 350, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(150, 400, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(150, 450, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        // Right Side Buttons
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(375, 350, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(375, 400, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(375, 450, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        // Exit Button (Centered Below)
        exit = new JButton("Exit");
        exit.setBounds(260, 500, 150, 30); // Centered
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);

        }else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawal ){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);

        } else if(ae.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);


        }

    }


    public static void main(String args[]) {
        new Transactions("");
    }
}




