
package bank.management.system;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
        
public class SignupTwo extends JFrame implements ActionListener{
    
    //long random;
    JTextField pan,Aadhar;
    JButton next;
    JRadioButton sYes,sNo,eYes,eNo;
    JComboBox religion,category,income,education,occupation ;
    
    String formno;
    
    
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
       
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
        
      
        
        JLabel AdditionalDetails=new JLabel("Page 2 : Additional Details ");
        
        
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);
        
        JLabel sreligion=new JLabel("Religion:");
        sreligion.setFont(new Font("Raleway",Font.BOLD,18));
        sreligion.setBounds(200,120,200,30);
        add(sreligion);
        
        
        //for making combo box (dropdown)
        String valReligion[]={"Hindu","Muslin","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(350,120,400,30);
        add (religion);
      
        JLabel scategory=new JLabel("Category:");
        scategory.setFont(new Font("Raleway",Font.BOLD,18));
        scategory.setBounds(200,170,200,30);
        add(scategory);
        
         //for making combo box (dropdown)
        String valCategory[]={"General","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(350,170,400,30);
        add (category);
        
        
        
        
        JLabel sincome=new JLabel("Income:");
        sincome.setFont(new Font("Raleway",Font.BOLD,18));
        sincome.setBounds(200,220,200,30);
        add(sincome);
        
        //for making combo box (dropdown)
        String incomeCategory[]={"Null","<2,00,000","<5,00,000","More than 5,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(350,220,400,30);
        add (income);
        
  
        JLabel seducation=new JLabel("Qualification:");
        seducation.setFont(new Font("Raleway",Font.BOLD,18));
        seducation.setBounds(200,320,200,30);
        add(seducation);
        
        //for making combo box (dropdown)
        String educationVal[]={"Graduate","non-Graduation","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationVal);
        education.setBounds(350,320,400,30);
        add (education);

        
        JLabel soccupation=new JLabel("Occupation:");
        soccupation.setFont(new Font("Raleway",Font.BOLD,18));
        soccupation.setBounds(200,370,200,30);
        add(soccupation);
        
          //for making combo box (dropdown)
        String occupationVal[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationVal);
        occupation.setBounds(350,370,400,30);
        add (occupation);
        
        
        
        JLabel sPan=new JLabel("Pan Number:");
        sPan.setFont(new Font("Raleway",Font.BOLD,18));
        sPan.setBounds(200,420,200,30);
        add(sPan);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(350,420,400,30);
        add (pan);
        
        JLabel sAadhar=new JLabel("Aadhar Number:");
        sAadhar.setFont(new Font("Raleway",Font.BOLD,18));
        sAadhar.setBounds(200,470,200,30);
        add(sAadhar);
        
        Aadhar=new JTextField();
        Aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        Aadhar.setBounds(350,470,400,30);
        add (Aadhar);
        
        
        JLabel sSeniorCitizen=new JLabel("Senior Citizen:");
        sSeniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        sSeniorCitizen.setBounds(200,520,200,30);
        add(sSeniorCitizen);
        
        sYes=new JRadioButton("Yes");
        sYes.setBounds(370,520,100,30);
        add(sYes);
        
        sNo=new JRadioButton("No");
        sNo.setBounds(600,520,100,30);
        add(sNo);
      
        
        //we group it so that only one can be selected at one time
        ButtonGroup SeniorCitizengroup=new ButtonGroup();
        SeniorCitizengroup.add(sYes);
        SeniorCitizengroup.add(sNo);
        
        
        
        JLabel sExisitingAccount=new JLabel("Exisiting Account:");
        sExisitingAccount.setFont(new Font("Raleway",Font.BOLD,18));
        sExisitingAccount.setBounds(200,570,200,30);
        add(sExisitingAccount);
        
        eYes=new JRadioButton("Yes");
        eYes.setBounds(370,570,100,30);
        add(eYes);
        
        eNo=new JRadioButton("No");
        eNo.setBounds(600,570,100,30);
        add(eNo);
      
        
        //we group it so that only one can be selected at one time
        ButtonGroup eAccountt=new ButtonGroup();
        eAccountt.add(eYes);
        eAccountt.add(eNo);
        
        
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
        //String formno="" + random;
         String sreligion=(String) religion.getSelectedItem();//we can take out the value from dropdown using get.SelectedItem but it will return a object to we will add (String) in front to make it String as we need string
         String scategory=(String) category.getSelectedItem();
         String sincome=(String) income.getSelectedItem();
         String seducation=(String) education.getSelectedItem();
         String soccupation=(String) occupation.getSelectedItem();
         
         String seniorcitizen =null;
         if(sYes.isSelected()){
             seniorcitizen="Yes";
         }else if(sNo.isSelected()){
             seniorcitizen="No";
         }
         
         String existingaccount =null;
         if(sYes.isSelected()){
             existingaccount="Yes";
         }else if(sNo.isSelected()){
             existingaccount="No";
         }
         
        String sPan=pan.getText();
        String sAadhar=Aadhar.getText();
        

  
         
         try{
             Conn c=new Conn();
             String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+sPan+"','"+sAadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
             c.s.executeUpdate(query);
             
             //signup3 
             setVisible(false);
             new SignupThree(formno).setVisible(true);
             
         }catch(Exception e){
                     System.out.println(e);
                     new SignupThree(formno).setVisible(true);
         }
         
    }
    
    public static void main(String args[]){
        new SignupTwo("");
        
    }
    
}
