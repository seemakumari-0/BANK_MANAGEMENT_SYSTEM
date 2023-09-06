
package bank.management.system;
import  javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
        
public class SignupOne extends JFrame implements ActionListener{
    
    //long random;
    JTextField nameTextField, fnameTextField, emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    
    Random ran = new Random();
    long random = Math.abs((ran.nextLong() %9000L)+1000L);
    
    
    SignupOne(){
        setLayout(null);
        

       //Math.abs make the no +ve
      // long random = 1000L + Math.abs(ran.nextLong() % 8000L);
 
      // System.out.println(random);
       

        JLabel formno=new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        
        JLabel personDetails=new JLabel("Page 1 : Person Details ");
        personDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(200,120,200,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(350,120,400,30);
        add (nameTextField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(200,170,200,30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(350,170,400,30);
        add (fnameTextField);
        
        JLabel dob=new JLabel("Date of birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(200,220,200,30);
        add(dob);
        
        //for adding calendar
        dateChooser=new JDateChooser();
        dateChooser.setBounds(350,220,400,30);
        
   //FOR writing the date in black colour
        //dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(200,270,100,30);
        add(gender);
        
        //for making radiobuttons
        male=new JRadioButton("Male");
        male.setBounds(350,270,100,30);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(500,270,100,30);
        add(female);
        
        //we group it so that only one can be selected at one time
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
       
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(200,320,200,30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(350,320,400,30);
        add (emailTextField);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,18));
        marital.setBounds(200,370,200,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(350,370,100,30);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(500,370,100,30);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(650,370,100,30);
        add(other);
        
        //we group it so that only one can be selected at one time
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(200,420,200,30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(350,420,400,30);
        add (addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(200,470,200,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(350,470,400,30);
        add (cityTextField);
        
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(200,520,200,30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(350,520,400,30);
        add (stateTextField);
        
        
        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,18));
        pincode.setBounds(200,570,200,30);
        add(pincode);
        
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(350,570,400,30);
        add (pincodeTextField);
        
        next=new JButton("next");
        next.setBounds(670,660,80,30);
        
        //as i need action on pressing next button so i'm adding action
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(850,800); //for making frame
        setLocation(350,10);
        setVisible(true);
         
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
         //in in front of a no. (or long) if we concate(+) with "" then it is converted to string earlier it was in long form because we want to string as input
         String formno = "" + random;
         //System.out.println(random);
         
         String name=nameTextField.getText();//we can take out the value from text field using getText
         String fname=fnameTextField.getText();
         String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //getUIComponent returns text field so we need to concate
         String email=emailTextField.getText();
         String gender =null;
         if(male.isSelected()){
             gender="Male";
         }else if(female.isSelected()){
             gender="Female";
         }
        // String email=emailTextField.getText();
         String marital =null;
         if(married.isSelected()){
             marital="Married";
         }else if(unmarried.isSelected()){
             marital="unmarried";
         }else if (other.isSelected()){
              marital="Other";
         }
         String address=addressTextField.getText();
         String city=cityTextField.getText();
         String state=stateTextField.getText();
         String pincode=pincodeTextField.getText();
         
         
         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null, "Name is Required");
             }else{
                 Conn c=new Conn();
                 String query ="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                 c.s.executeUpdate(query);
                 
                 setVisible(false); //we have to close the current as the data is successfully entered
                 //making object of signupTwo
                 new SignupTwo(formno).setVisible(true);
             }
             
             
         }catch(Exception e){
                     System.out.println(e);
                     
         }
         
    }
    
    public static void main(String args[]){
        new SignupOne();
        
        
    }
    
}
