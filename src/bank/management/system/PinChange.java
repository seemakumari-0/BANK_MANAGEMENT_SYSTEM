
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change,back;
    
    String pinnumber;
    PinChange(String pinnumber){
        
        this.pinnumber=pinnumber;//this will take the pinnumber from local and put in glabal
        setLayout(null);
        //for background image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(275,300,400,35);
        text.setForeground(Color.WHITE);
        image.add(text);//as we use image.add it will bring the text upon the background image

        
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setBounds(200,330,200,25);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);//as we use image.add it will bring the text upon the background image

        pin =new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(330,330,170,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setBounds(200,360,200,25);
        repintext.setForeground(Color.WHITE);
        image.add(repintext);//as we use image.add it will bring the text upon the background image

        repin =new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,22));
        repin.setBounds(330,360,170,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(350,470,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(350,500,150,30);
        change.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }
            
            Conn conn=new Conn();
            String query1="update bank set pin='"+rpin+"' where pin ='"+pinnumber+"'";
            String query2="update login set pin='"+rpin+"' where pin ='"+pinnumber+"'";
            String query3="update signupthree set pin='"+rpin+"' where pin ='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
           
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch (Exception e){
            System.out.print(e);
        }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String[] args){
        new PinChange("").setVisible(true);
        
    }
    
}
