
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATARED TELLER MACHINE");
        
        setLayout(null);
        
        
        //For image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);


        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("CARD NO.: ");
        cardno.setFont(new Font("osward",Font.BOLD,28));
        cardno.setBounds(120,120,250,30);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,120,250,30);
        //cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("osward",Font.BOLD,28));
        pin.setBounds(120,180,250,40);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,180,250,30);
        //pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
//        login.setBackground(Color.black);
//        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn =new Conn();//to establish connection with data base
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();//this cutted getText show that pinnumber is not a textField it is password field
            String query="select * from login where cardnumber='"+cardnumber+"'and pin='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    
    public static void main(String args[]){
        new Login();
        
    }
    
}
