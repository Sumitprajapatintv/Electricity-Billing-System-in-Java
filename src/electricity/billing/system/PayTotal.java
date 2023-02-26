package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;  
import java.util.Date;    
                                         

public class PayTotal extends JFrame implements ActionListener{

    Choice cmonth,cch;
    JButton pay, back;
    String meter,str;
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
   
    //String str=formatter.format(date);
    PayTotal(String meter) {
       // System.out.println(meter);
        this.meter = meter;
        setLayout(null);
        setBounds(300, 150, 900, 600);
        
        JLabel heading = new JLabel("Electicity Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(120, 5, 400, 30);
        add(heading);
         
        JLabel lblmeternumber = new JLabel("Account Number");
        lblmeternumber.setBounds(35, 80, 200, 20);
        add(lblmeternumber);
        
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(300, 80, 200, 20);
        add(meternumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 140, 200, 20);
        add(lblname);
        
        JLabel labelname = new JLabel("");
        labelname.setBounds(300, 140, 200, 20);
        add(labelname);
        
        JLabel lbltotalbill = new JLabel("Outstanding");
        lbltotalbill.setBounds(35, 200, 200, 20);
        add(lbltotalbill);
        
        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setBounds(300, 200, 200, 20);
        add(labeltotalbill);
        
        
       // var str= ();
        
        //System.out.println(str);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where Account_No = '"+meter+"'");
            while(rs.next()) {
                meternumber.setText(meter);
                labelname.setText(rs.getString("name"));
            }
            
            rs = c.s.executeQuery("select * from OutstandingBill where Account_No = '"+meter+"'");
            while(rs.next()) {
                
                labeltotalbill.setText(rs.getString("outstanding"));
                //labelstatus.setText(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100, 260, 100, 25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 260, 100, 25);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 120, 600, 300);
        add(image);
        
        setVisible(true);
    }
      
     // System.out.println(formatter.format(date));  
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            try {
                //System.out.println(formatter.format(date));  
                 str=formatter.format(date);
                 System.out.println(str);
                System.out.println(str.length());
                
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid',Time='"+str+"' where Account_No = '"+meter+"' and status='NOT PAID'");
                
                //c.s.executeUpdate("update bill set Time = '"+str+"' where Account_No = '"+meter+"' and status='NOT PAID'");
                
                c.s.executeUpdate("update OutstandingBill set LastPaid = '"+str+"' where Account_No = '"+meter+"'");
                
                 c.s.executeUpdate("update OutstandingBill set outstanding= '0' where Account_No = '"+meter+"'");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
        } else {
            setVisible(false);
        }
    }
     

    public static void main(String[] args){
       
        //System.out.println(java.time.LocalDate.now());
        
    //System.out.println(str);
     new PayTotal("");
    }
}