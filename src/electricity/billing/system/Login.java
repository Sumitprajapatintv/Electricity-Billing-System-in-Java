/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
//import static electricity.billing.system.SHA256.getSHA;
//import static electricity.billing.system.SHA256.toHexString;
import static electricity.billing.system.SHA256.getSHA;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Sumit Prajapati
 */
public class Login extends JFrame implements ActionListener  {
    
    JButton login,Cancel,Signup, NewConnection;
    JTextField username;
    Choice loginin;
    JPasswordField password;
    Login()
    {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername=new JLabel("Account Number");
        lblusername.setBounds(250,50,100,20);
        add(lblusername);
         username=new JTextField();
        username.setBounds(350,50,150,20);
        add(username);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(250,100,100,20);
        add(lblpassword);
        
         password=new JPasswordField();
        password.getPassword();
        password.setBounds(350,100,150,20);
        add(password);
        //JTextField password=new JTextField();
        //password.setBounds(350,100,150,20);
        //add(password);
        
        JLabel logininas=new JLabel("Login in as");
        logininas.setBounds(250,150,100,20);
        add(logininas);
        
         loginin =new Choice();
        loginin.add("Admin");
        loginin.add("User");
        loginin.setBounds(350,150,100,20);
        add(loginin);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        login=new JButton("Login",new ImageIcon(i2));
        login.setBounds(250,200,100,20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        Cancel=new JButton("Cancel",new ImageIcon(i4));
        Cancel.setBounds(400,200,100,20);
        Cancel.addActionListener(this);
        add(Cancel);
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
       Signup=new JButton("SignUp",new ImageIcon(i6));
        Signup.setBounds(320,260,100,20);
        Signup.addActionListener(this);
        add(Signup);
        
        ImageIcon i90=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i91=i90.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
       NewConnection=new JButton("New Connection Request",new ImageIcon(i91));
        NewConnection.setBounds(240,300,250,20);
        NewConnection.addActionListener(this);
        add(NewConnection);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image =new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);
        
        setSize(600,400);
        setLocation(350,100);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==login)
         {
             String AccountNumber=username.getText();
             String spassword=password.getText();
             //System.out.println(spassword);
             String user=loginin.getSelectedItem();
             
             
             
             //System.out.println(sspassword);
             
             
             try{
                 String sspassword = SHA256.toHexString(getSHA(spassword));
                 Conn c =new Conn();
                 String query="select * from login where Account_no= '"+AccountNumber+"' and password='"+sspassword+"' and user='"+user+"'";
                 ResultSet rs=c.s.executeQuery(query);
                 
                 if(rs.next())
                 {
                     String meter =rs.getString("Account_no");
                       setVisible(false);
                       new Projects(user,meter);
                 }else
                 {
                     JOptionPane.showMessageDialog(null, "Invalid Login");
                     username.setText("");
                     password.setText("");
                 }
                 
                 
             }catch(Exception e)
             {
                 e.printStackTrace();
             }
         }
         else if(ae.getSource()==Cancel)
         {
             setVisible(false);
         }
         else if(ae.getSource()==Signup)
          {
              setVisible(false);
              new Signup();
          }
         
          else if(ae.getSource()==NewConnection)
          {
              
              new NewCustomer();
          }
     }

    
    public static void main(String[] args)
    {
        new Login();
    }
    
}
