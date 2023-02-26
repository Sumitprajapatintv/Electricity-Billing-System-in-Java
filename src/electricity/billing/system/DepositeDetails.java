/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

/**
 *
 * @author Sumit Prajapati
 */
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class DepositeDetails extends JFrame implements ActionListener{

    Choice meternumber, cmonth;
    JTable table;
    JButton search, print,printtt;
    
    DepositeDetails(){
        super("Deposit Details");
        
        setSize(700, 700);
        setLocation(400, 100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        /*
        JLabel lblmeternumber = new JLabel("Search By Account  Number");
        lblmeternumber.setBounds(20, 20, 150, 20);
        add(lblmeternumber);
        
        meternumber = new Choice();
        meternumber.setBounds(180, 20, 150, 20);
        add(meternumber);
        
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
        JLabel lblmonth = new JLabel("Search By Month");
        lblmonth.setBounds(20, 20, 100, 20);
        add(lblmonth);
        
        cmonth = new Choice();
        cmonth.setBounds(180, 20, 150, 20);
        cmonth.add("January");
        cmonth.add("February");
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
        
       table=new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from billJanuary2023");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        add(sp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        
        
       
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            
            
            String query1 = "select * from billJanuary2023";
            String query2 = "select * from billFeb2023";
            String query3 = "select * from billMar2023";
            String query4 = "select * from billApr2023";
            String query5 = "select * from billMay2023";
            String query6 = "select * from billJun2023";
            String query7 = "select * from billJul2023";
            String query8 = "select * from billAug2023";
            String query9 = "select * from billSept2023";
            String query10 = "select * from billOct2023";
            String query11 = "select * from billNov2023";
            String query12 = "select * from billDec2023";
            
            
            
          
          //System.out.println(cmonth.getSelectedItem());
            try {
                Conn c = new Conn();
                  if("January".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  else if("February".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query2);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  else if("March".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query3);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }else if("April".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query4);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                 else if("May".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query5);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  else if("June".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query6);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }else if("July".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query7);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  else if("August".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query8);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }if("September".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query9);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  else if("October".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query10);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  if("November".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query11);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  if("Decmber".equals(cmonth.getSelectedItem()))
                  {
                ResultSet rs = c.s.executeQuery(query12);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                  }
                  
                  
                  
                
              
            } catch (Exception e) {
                
            }

        } else  if(ae.getSource() == print){
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*
        else if(ae.getSource()==printtt){
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            new CalculateBill();
            //System.out.println(table.getValueAt(table.getSelectedRow(),0).toString());
            
        }
    });
        }
*/
       
    }
    

    public static void main(String[] args) {
        new DepositeDetails();
    }
}
