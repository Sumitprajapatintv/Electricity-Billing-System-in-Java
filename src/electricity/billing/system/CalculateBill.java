package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener{

    JTextField Actn ,tfname, tfaddress, tfstate, tfunits, tfemail, tfphone,tfMonth;
    JButton next, cancel;
    JLabel lblname, labeladdress;
    //Choice meternumber, cmonth;
    String Acc,Unittt,month;
    CalculateBill(String Acc,String Unittt,String month) {
        this.Acc=Acc;
        this.Unittt=Unittt;
        this.month=month;
        setSize(700, 500);
        setLocation(400, 150);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Genrate BILL Cycle");
        heading.setBounds(100, 10, 400, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Account_No");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);
        
        Actn=new JTextField();
        Actn.setBounds(350,80,150,20);
        add(Actn);
        Actn.setText(Acc);
        
        
        
        //meternumber = new Choice();
        /*
        try {
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                meternumber.add(rs.getString("Account_No"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        
        
        
        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        lblname = new JLabel("");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where Account_No = '"+Acc+"'");
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("adress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        Acc.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where Account_No= Acc");
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        labeladdress.setText(rs.getString("adress"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
*/
        
        JLabel lblcity = new JLabel("Units Consumed");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        
        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);
        
        tfunits.setText(Unittt);
        
        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);
        
        tfMonth = new JTextField();
        tfMonth.setBounds(240, 240, 200, 20);
        p.add(tfMonth);
        
        tfMonth.setText(month);
        
        
        next = new JButton("Submit");
        next.setBounds(120, 350, 100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 350, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = Actn.getText();
            String units = tfunits.getText();
            String month = tfMonth.getText();
            
            int totalbill = 0;
            int unit_consumed = Integer.parseInt(units);

            String query = "select * from tax";
            
           
            
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()) {
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*
            String query2="";
            if(month=="January")
            {
            query2 = "update billJanuary2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }
            else if(month=="February")
            {
                 query2 = "update billFeb2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }
            else if(month=="March")
            {
                 query2 = "update billMar2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }
            else if(month=="April")
            {
                 query2 = "update billApr2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }else if(month=="May")
            {
                query2 = "update billMay2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }else if(month=="June")
            {
                 query2 = "update billJun2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }else if(month=="July")
            {
                 query2 = "update billJul2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }else if(month=="August")
            {
                query2 = "update billAug2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }else if(month=="September")
            {
                query2 = "update billSept2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }
            else if(month=="October")
            {
                query2 = "update billOCt2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }
             else if(month=="November")
            {
             query2 = "update billOCt2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            }
             else if(month=="December")
            {
               query2 = "update billOCt2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
          }
*/
               String query2 = "update billJanuary2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
               //String query211="select sum(unit) as unitt from bill";
               String query21="insert into bill values('"+meter+"','January','"+units+"','"+totalbill+"','NOT PAID','')";
            String query3 = "update billFeb2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            String query31="insert into bill values('"+meter+"','Febuary','"+units+"','"+totalbill+"','NOT PAID','')";
            String query4 = "update billMar2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            String query41="insert into bill values('"+meter+"','March','"+units+"','"+totalbill+"','NOT PAID','')";
             String query5 = "update billApr2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query51="insert into bill values('"+meter+"','April','"+units+"','"+totalbill+"','NOT PAID','')";
             String query6 = "update billMay2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query61="insert into bill values('"+meter+"','May','"+units+"','"+totalbill+"','NOT PAID','')";
             String query7 = "update billJune2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query71="insert into bill values('"+meter+"','June','"+units+"','"+totalbill+"','NOT PAID','')";
             String query8 = "update billJul2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query81="insert into bill values('"+meter+"','July','"+units+"','"+totalbill+"','NOT PAID','')";
             String query9 = "update billAug2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query91="insert into bill values('"+meter+"','August','"+units+"','"+totalbill+"','NOT PAID','')";
            String query10 = "update billSep2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
            String query101="insert into bill values('"+meter+"','September','"+units+"','"+totalbill+"','NOT PAID','')";
             String query11 = "update billOct2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query111="insert into bill values('"+meter+"','October','"+units+"','"+totalbill+"','NOT PAID','')";
             String query12 = "update billNov2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query121="insert into bill values('"+meter+"','November','"+units+"','"+totalbill+"','NOT PAID','')";
             String query13 = "update billDec2023 SET units='"+units+"',totalbill='"+totalbill+"',status='NOT PAID' where Account_No='"+meter+"'";
             String query131="insert into bill values('"+meter+"','December','"+units+"','"+totalbill+"','NOT PAID','')";
          
             
               if("January".equals(month))
            {
           
         
            
            try {
             
             
                Conn c  =  new Conn();
               
             
                //System.out.println(month);
                
                c.s.executeUpdate(query2);
               c.s.executeUpdate(query21);
                //ResultSet rs;
                //rs = c.s.executeQuery("Select sum(bill) as bills from bill where Account_No='"+meter+"'");
                // int count = rs.getInt("bills");
                 //System.out.println(count);
                ///else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
            
           
           else if("February".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query31);
            
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
           
            else if("March".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query4);
            c.s.executeUpdate(query41);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            
            else if("April".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query5);
            c.s.executeUpdate(query51);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("May".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query6);
                c.s.executeUpdate(query61);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("June".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query7);
            c.s.executeUpdate(query71);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("July".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
               
                c.s.executeUpdate(query8);
             c.s.executeUpdate(query81);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            
            else if("August".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query9);
             c.s.executeUpdate(query91);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("September".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query10);
             c.s.executeUpdate(query101);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("October".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query11);
             c.s.executeUpdate(query111);
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("November".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query12);
                 c.s.executeUpdate(query121);
            
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            else if("December".equals(month)) {
            try {
             
             
                Conn c  =  new Conn();
               
                
                c.s.executeUpdate(query131);
            
                //else if(month=="February")
                //{
                  //   c.s.executeUpdate(query3);
               // }
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false); 
                new GenrateBillCycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
           }
            
            
           
           else {
            setVisible(false);
        }
               
               try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select sum(totalbill)as Summm from bill where Account_No='"+meter+"'");
            
            //System.out.println(rs);
            //int summ=rs.getInt("Summm");
            //System.out.println(summ);
            int count=0;
           while (rs.next()) {

             count = rs.getInt("Summm") ;
               
                 System.out.println(count);
                 
                 
            }
           c.s.executeUpdate("Update OutstandingBill SET Account_No='"+meter+"',outstanding='"+count+"',LastPaid='NOT YET PAID' where Account_No='"+meter+"'");
            
               }catch (Exception e) {
                e.printStackTrace();
            }
               
                

           }
            
           
           
             
        
    }
    
    public static void main(String[] args) {
        new CalculateBill("","","");
    }
}