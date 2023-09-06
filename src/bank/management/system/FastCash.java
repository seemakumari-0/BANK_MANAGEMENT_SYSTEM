
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;//here we specified that we have to take date from util only esle we will get error as date class is present in sql and util both package 

public class FastCash extends JFrame implements ActionListener {
    JButton n1,n2,n3,n4,n5,n6,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        //for background image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text =new JLabel("Select withdrawl amount");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.WHITE);
        image.add(text);//as we use image.add it will bring the text upon the background image

        n1=new JButton("Rs 100");
        n1.setBounds(170,415,150,30);
        n1.addActionListener(this);// for the action to perform
        image.add(n1);
        
        n2=new JButton("Rs 500");
        n2.setBounds(355,415,150,30);
        n2.addActionListener(this);// for the action to perform
        image.add(n2);
        
        n3=new JButton("Rs 1000");
        n3.setBounds(170,450,150,30);
        n3.addActionListener(this);// for the action to perform
        image.add(n3);
        
        n4=new JButton("Rs 2000");
        n4.setBounds(355,450,150,30);
        n4.addActionListener(this);// for the action to perform
        image.add(n4);
        
        n5=new JButton("Rs 5000");
        n5.setBounds(170,485,150,30);
        n5.addActionListener(this);// for the action to perform
        image.add(n5);
        
        n6=new JButton("Rs 10000");
        n6.setBounds(355,485,150,30);
        n6.addActionListener(this);// for the action to perform
        image.add(n6);
        
        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);// for the action to perform
        image.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
      //  setUndecorated(true);//this will remove the white line containing (close ,min and full screen)
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3); //substring(3) will minus the last 3 digit
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){ //rs.next will help in looping the row
                if(rs.getString("type").equals("Deposit")){
                    balance +=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }    
                }
            
             if(ae.getSource() != exit && balance < Integer.parseInt(amount)){ //amount is in string so convert it intoo int using Integer.parseInt
                 JOptionPane.showMessageDialog(null, "Insufficient Balance");
                 return;
             }

             
             Date date = new Date(); 
             String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Successfully");
             
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
                
             
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args){
        new FastCash("");
        
    }
}
