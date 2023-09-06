
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit ,cancel;
    String formno;
    
    SignupThree(String formno){
        
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,400,40);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setBounds(100,180,250,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(500,180,250,20);
        add(r2);
        
        r3=new JRadioButton("Current  Account");
        r3.setBounds(100,220,250,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(500,220,250,20);
        add(r4);
        
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,270,200,40);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-1345");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(420,270,400,40);
        add(number);
        
        JLabel n=new JLabel("(This  is your 16 digit card number)");
        n.setFont(new Font("Raleway",Font.BOLD,12));
        n.setBounds(100,290,400,40);
        add(n);
        
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,340,200,40);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(420,340,400,40);
        add(pnumber);
        
        JLabel p=new JLabel("(This  is your 4 digit password)");
        p.setFont(new Font("Raleway",Font.BOLD,12));
        p.setBounds(100,360,400,40);
        add(p);
        
        
       JLabel Services=new JLabel("Services Required:");
        Services.setFont(new Font("Raleway",Font.BOLD,22));
        Services.setBounds(100,410,400,40);
        add(Services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,460,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,460,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,200,30);
        add(c3);
        
        c4=new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,490,300,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,520,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declares that above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,600,600,30);
        add(c7);
        
        submit=new JButton("Submit");
        //submit.setBackground(Color.BLACK);
        //submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(420,700,100,30);
        //for performing action
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        //cancel.setBackground(Color.BLACK);
        //cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(620,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            //taking out the values given by the user
            String accountType=null; //accountType is radioButton 
            if(r1.isSelected()){
                accountType="Saving Account";  
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Eecuring Deeposite Account";
            }
            Random random =new Random();
            String cardnumber="" + Math.abs((random.nextLong() %90000000L)+504030200000000L);
            
            String pinnumber="" +Math.abs((random.nextLong() %9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility=facility +"ATM CARD";  
            }else if(c2.isSelected()){
                facility=facility +"Internet Banking";
            }else if(c3.isSelected()){
                facility=facility +"Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility +"Email and SMS";
            }else if(c5.isSelected()){
                facility=facility +"Cheque Book";
            }else if(c6.isSelected()){
                facility=facility +"e-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                    
                }else{
                    Conn conn=new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardnumber +" \n Pin: " + pinnumber);
                }
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                
            }catch(Exception e){
                System.out.println(e);
            }
         
        
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
            
            
        }
            
    }
    
    public static void main(String args[]){
    new SignupThree("");
    
        }
    
}
    
