package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;  
import java.util.Date;    
  

public class PayBill extends JFrame implements ActionListener{

    Choice cmonth,cch;
    JButton pay, back,PTO;
    String meter,str;
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
   
    //String str=formatter.format(date);
    PayBill(String meter) {
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
        
        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35, 200, 100, 20);
        add(lblmonth);
        
        
        
        cmonth = new Choice();
        cmonth.setBounds(300, 200, 200, 20);
        cmonth.add("January");
        cmonth.add("Febuary");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
        
        JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35, 260, 200, 20);
        add(lblunits);
        
        JLabel labelunits = new JLabel("");
        labelunits.setBounds(300, 260, 200, 20);
        add(labelunits);
        
        JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(35, 320, 200, 20);
        add(lbltotalbill);
        
        JLabel labeltotalbill = new JLabel("");
        labeltotalbill.setBounds(300, 320, 200, 20);
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
            
            rs = c.s.executeQuery("select * from bill where Account_No = '"+meter+"' AND month = 'January'");
            while(rs.next()) {
                labelunits.setText(rs.getString("units"));
                labeltotalbill.setText(rs.getString("totalbill"));
                //labelstatus.setText(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cmonth.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where Account_No = '"+meter+"' AND month = '"+cmonth.getSelectedItem()+"'");
                    while(rs.next()) {
                        labelunits.setText(rs.getString("units"));
                        labeltotalbill.setText(rs.getString("totalbill"));
                        //labelstatus.setText(rs.getString("status"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100, 360, 100, 25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 360, 100, 25);
        back.addActionListener(this);
        add(back);
        
        
        PTO = new JButton("Pay Total Outstanding");
        PTO .setBackground(Color.BLACK);
        PTO .setForeground(Color.WHITE);
        PTO .setBounds(360, 360, 180, 25);
        PTO .addActionListener(this);
        add(PTO );
        
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
                
                String kkl="NOT PAID";
                
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid',Time='"+str+"' where Account_No = '"+meter+"' AND month='"+cmonth.getSelectedItem()+"'");
                
                
                
                //c.s.executeUpdate("update bill set Time = '"+str+"' where Account_No = '"+meter+"'");
                
                c.s.executeUpdate("update OutstandingBill set LastPaid = '"+str+"' where Account_No = '"+meter+"'");
                
                ResultSet rs = c.s.executeQuery("select sum(totalbill)as Summm from bill where Account_No='"+meter+"' AND status='"+kkl+"'");
                
                int count=0;
           while (rs.next()) {

             count = rs.getInt("Summm") ;
               
                 System.out.println(count);
                 
                 
            }
                 c.s.executeUpdate("update OutstandingBill set outstanding= '"+count+"' where Account_No = '"+meter+"'");
                
                 if(cmonth.getSelectedItem()=="January")
                {
                     c.s.executeUpdate("update billJanuary2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="Febuary")
                {
                     c.s.executeUpdate("update billFeb2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="March")
                {
                     c.s.executeUpdate("update billMar2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="April")
                {
                     c.s.executeUpdate("update billApr2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="May")
                {
                     c.s.executeUpdate("update billMay2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="June")
                {
                     c.s.executeUpdate("update billJun2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="July")
                {
                     c.s.executeUpdate("update billJul2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="August")
                {
                     c.s.executeUpdate("update billAug2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="September")
                {
                     c.s.executeUpdate("update billSep2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="October")
                {
                     c.s.executeUpdate("update billOct2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="November")
                {
                     c.s.executeUpdate("update billNov2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                 else if(cmonth.getSelectedItem()=="December")
                {
                     c.s.executeUpdate("update billDec2023 SET status='Paid' where Account_No = '"+meter+"'");
                }
                
                
                
                
                 
                 
                 
                 
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter);
               
            
            
            setVisible(false);
        } 
            
              else if(ae.getSource()==PTO)
        {
            new PayTotal(meter);
        }
        
        
        
        else {
            setVisible(false);
        }
    }
     

    public static void main(String[] args){
       
        //System.out.println(java.time.LocalDate.now());
        
    //System.out.println(str);
     new PayBill("");
    }
}