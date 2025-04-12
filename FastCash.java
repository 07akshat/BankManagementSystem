package bank.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawal, miniStatement, pinChange, FastCash, balanceEnquiry, exit;
    String pinnumber;
    FastCash(String pinnumber) {
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Transaction Selection Label
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(200, 300, 700, 35); // Adjusted for better alignment
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Left Side Buttons
        deposit = new JButton("Rs 100");
        deposit.setBounds(150, 350, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        FastCash = new JButton("Rs 500");
        FastCash.setBounds(150, 400, 150, 30);
        FastCash.addActionListener(this);
        image.add(FastCash);

        pinChange = new JButton("Rs 1000");
        pinChange.setBounds(150, 450, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        // Right Side Buttons
        withdrawal = new JButton("Rs 2000");
        withdrawal.setBounds(375, 350, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        miniStatement = new JButton("Rs 5000");
        miniStatement.setBounds(375, 400, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        balanceEnquiry = new JButton("Rs 10000");
        balanceEnquiry.setBounds(375, 450, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        // Exit Button (Centered Below)
        exit = new JButton("BACK");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
           String amount = ((JButton)ae.getSource()).getText().substring(3 );
           int balance = 0;
           Conn c = new Conn();
           try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"')");
               int Balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }

               }
               if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               Date date = new Date();
               String query = "insert into back value('"+pinnumber+"','"+date+"','"+withdrawal+"','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+ amount +" Debited Successfully");

               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }catch (Exception e){
               System.out.println(e);

           }
        }

    }

    public static void main(String args[]) {
        new FastCash("");
    }
}




