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
import javax.swing.text.View;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Objects;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private int sortedRow;

    public CustomTableCellRenderer(int sortedRow) {
        this.sortedRow = sortedRow;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row == sortedRow) {
            c.setBackground(Color.GREEN); // set the background color of the cell to green for the sorted row
        } else {
            c.setBackground(table.getBackground()); // set the background color of the cell to the default color
        }

        return c;
    }
}


public class DashBord extends JFrame implements ActionListener {

    Choice meternumber, cmonth;
    JTable table;
    JButton search, ViewCustomer, ViewBillSummery, Select, Delete,Back,Print;
    JTextField Accountn, Unitn,jtf;
    JButton Update,PTO;
    String Acn;
    TableRowSorter sorter;
     
   JLabel searchLbl;
    TableModel model;
   
   //TableRowSorter sorter;
   JScrollPane sp;

    DashBord() {
        super("DashBord");

        setSize(1200, 750);
        setLocation(200, 40);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Account Number");
        lblusername.setBounds(10, 20, 100, 20);
        add(lblusername);

        Accountn = new JTextField();
         //Accountn.setText("  ");
        Accountn.setBounds(150, 20, 150, 20);
        add(Accountn);
        
        String text = Accountn.getText();
  //if (text.trim().length() == 0) {
   //  rowSorter.setRowFilter(null);
  //} else {
  //   rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
  //}
        
          //ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        //Image i17 = i16.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Select = new JButton("Search");
        Select.setBounds(320, 20, 100, 20);
        Select.addActionListener(this);
        add(Select);             
        

        JLabel lblTotalc = new JLabel("Total Consumer :");
        lblTotalc.setBounds(800, 20, 100, 20);
        add(lblTotalc);

        JLabel labelTotalc = new JLabel("");
        labelTotalc.setBounds(900, 20, 100, 20);
        add(labelTotalc);

        JLabel lblActive = new JLabel("Active Consumer :");
        lblActive.setBounds(800, 40, 400, 20);
        add(lblActive);

        JLabel labelActive = new JLabel("");
        labelActive.setBounds(915, 40, 100, 20);
        add(labelActive);

        JLabel lblInActive = new JLabel("InActive Consumer :");
        lblInActive.setBounds(800, 60, 400, 20);
        add(lblInActive);

        JLabel labelInActive = new JLabel("");
        labelInActive.setBounds(920, 60, 100, 20);
        add(labelInActive);
        
          JLabel lblmonth = new JLabel("Sort By");
        lblmonth.setBounds(20, 70, 100, 20);
        add(lblmonth);
        
        //model = new DefaultTableModel(rowData, columnNames);
      
        
        
        
        cmonth = new Choice();
        cmonth.setBounds(150, 70, 100, 20);
        cmonth.add("Adress");
        cmonth.add("City");
        cmonth.add("Outstanding");
        
                ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i17 = i16.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Select = new JButton("Select", new ImageIcon(i17));
        Select.setBounds(150, 90, 100, 20);
        Select.addActionListener(this);
        add(Select);             
        
        PTO = new JButton("Print");
        PTO .setBackground(Color.gray);
        PTO .setForeground(Color.BLACK);
        PTO .setBounds(360, 650, 180, 25);
        PTO .addActionListener(this);
        add(PTO );
        
        
        Back = new JButton("Back");
        Back .setBackground(Color.gray);
        Back .setForeground(Color.BLACK);
        Back .setBounds(600, 650, 180, 25);
        Back .addActionListener(this);
        add(Back );
       
        add(cmonth);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select count(Account_No) AS rowcount from customer");
            //System.out.println(rs);
            while (rs.next()) {

                int count = rs.getInt("rowcount") ;
               labelTotalc.setText(rs.getString("rowcount"));
                 //System.out.println(count);
            }
            rs = c.s.executeQuery("select count(status) AS rowcountt from customer where status='Active'");
            //System.out.println(rs);
            while (rs.next()) {

                int count = rs.getInt("rowcountt") ;
                labelActive.setText(rs.getString("rowcountt"));
                //System.out.println(count);
            }
            
            rs = c.s.executeQuery("select count(status) AS rowcountt from customer where status='Deactive'");
            //System.out.println(rs);
            while (rs.next()) {

                int count = rs.getInt("rowcountt") ;
                labelInActive.setText(rs.getString("rowcountt"));
                //System.out.println(count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Update = new JButton("Disabled Connection", new ImageIcon(i2));
        Update.setBounds(320, 20, 200, 20);
        Update.addActionListener(this);
        add(Update);

        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image i5 = i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Delete = new JButton("Delete Customer", new ImageIcon(i5));
        Delete.setBounds(550, 20, 180, 20);
        Delete.addActionListener(this);
        
        
        add(Delete);
         */
        table = new JTable(model);
        
            
        
        
        
         
        
         
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT customer.Account_No, customer.adress,customer.city,customer.status,OutstandingBill.outstanding,OutstandingBill.LastPaid\n" +
"FROM customer\n" +
"LEFT JOIN OutstandingBill ON customer.Account_No=OutstandingBill.Account_No order by Account_No;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(table.getModel());
            table.setRowSorter(rowSorter);
            
            
            
            
               Accountn.getDocument().addDocumentListener(new DocumentListener(){
                   
                   

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = Accountn.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));   
                    
                    
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = Accountn.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            
            

        });
               
               
               

      //JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
    //String txt = Accountn.getText();
   
               
               
               
            
         DefaultTableCellRenderer MyCellrendar = new DefaultTableCellRenderer();
         
         
 
 //MyCellrendar.setBackground(Color.yellow);
 MyCellrendar.setForeground(Color.BLUE);

 table.getColumnModel().getColumn(0).setCellRenderer(MyCellrendar);
 table.getColumnModel().getColumn(5).setCellRenderer(MyCellrendar);
            
          
            
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        
        
         
         sp = new JScrollPane(table);
        sp.setBounds(0, 130, 1195, 500);
        add(sp);
        
          
        
         
        
        
        
        
        /*
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
         */
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                //new CalculateBill();
                //setVisible(false);
                //new GenrateBillCycle();
                String pr=table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
                String mr=table.getValueAt(table.getSelectedRow(), 0).toString();
                //String str=Accountn.getText();
                if(pr.length()<=9)
                {
             //System.out.println(str);
            try {
                //System.out.println(Accountn.getText());
               // Conn c = new Conn();
                //String query2 = "Select * from Customer where Account_No='"+Accountn+"'";
                //c.s.executeUpdate(query2);

                //JOptionPane.showMessageDialog(null, "Deleted Successfully");
                //setVisible(false); 
               // new CustomerDetails();
                new ViewInformation(mr); 
            } catch (Exception e) {
                e.printStackTrace();
            }
                }
                else if(pr.length()==19 || pr.length()==12)
                {
                    //String strr=Accountn.getText();
             //System.out.println(str);
            try {
                //System.out.println(Accountn.getText());
               // Conn c = new Conn();
                //String query2 = "Select * from Customer where Account_No='"+Accountn+"'";
                //c.s.executeUpdate(query2);

                //JOptionPane.showMessageDialog(null, "Deleted Successfully");
                //setVisible(false); 
               // new CustomerDetails();
                new CustomerBill(mr); 
            } catch (Exception e) {
                e.printStackTrace();
            }
                }
               
                

            }
        });
        
        

        
        

        

        setVisible(true);
    }
   

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Select) {
            if (cmonth.getSelectedItem() == "Adress") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT customer.Account_No, customer.adress,customer.city,customer.status,OutstandingBill.outstanding,OutstandingBill.LastPaid\n" +
"FROM customer\n" +
"LEFT JOIN OutstandingBill ON customer.Account_No=OutstandingBill.Account_No order by adress");
                System.out.println("jkdfn");

                table.setModel(DbUtils.resultSetToTableModel(rs));
                DefaultTableCellRenderer MyCellrendar = new DefaultTableCellRenderer();
 
 //MyCellrendar.setBackground(Color.yellow);
 MyCellrendar.setForeground(Color.BLUE);

 table.getColumnModel().getColumn(0).setCellRenderer(MyCellrendar);
 table.getColumnModel().getColumn(5).setCellRenderer(MyCellrendar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            else if (cmonth.getSelectedItem() == "City") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT customer.Account_No, customer.adress,customer.city,customer.status,OutstandingBill.outstanding,OutstandingBill.LastPaid\n" +
"FROM customer\n" +
"LEFT JOIN OutstandingBill ON customer.Account_No=OutstandingBill.Account_No order by city");
                System.out.println("jkdfn");

                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                DefaultTableCellRenderer MyCellrendar = new DefaultTableCellRenderer();
 
 //MyCellrendar.setBackground(Color.yellow);
 MyCellrendar.setForeground(Color.BLUE);

 table.getColumnModel().getColumn(0).setCellRenderer(MyCellrendar);
 table.getColumnModel().getColumn(5).setCellRenderer(MyCellrendar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            else   if (cmonth.getSelectedItem() == "Outstanding") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("SELECT customer.Account_No, customer.adress,customer.city,customer.status,OutstandingBill.outstanding,OutstandingBill.LastPaid\n" +
"FROM customer\n" +
"LEFT JOIN OutstandingBill ON customer.Account_No=OutstandingBill.Account_No order by outstanding");
                System.out.println("jkdfn");

                table.setModel(DbUtils.resultSetToTableModel(rs));
                DefaultTableCellRenderer MyCellrendar = new DefaultTableCellRenderer();
 
 //MyCellrendar.setBackground(Color.yellow);
 MyCellrendar.setForeground(Color.BLUE);

 table.getColumnModel().getColumn(0).setCellRenderer(MyCellrendar);
 table.getColumnModel().getColumn(5).setCellRenderer(MyCellrendar);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        } else if (ae.getSource() == ViewCustomer) {
             String str=Accountn.getText();
             System.out.println(str);
            try {
                //System.out.println(Accountn.getText());
               // Conn c = new Conn();
                //String query2 = "Select * from Customer where Account_No='"+Accountn+"'";
                //c.s.executeUpdate(query2);

                //JOptionPane.showMessageDialog(null, "Deleted Successfully");
                //setVisible(false); 
               // new CustomerDetails();
                new UpdateInformation(str); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == ViewBillSummery) {
             String str=Accountn.getText();
             //System.out.println(str);
            try {
                //System.out.println(Accountn.getText());
               // Conn c = new Conn();
                //String query2 = "Select * from Customer where Account_No='"+Accountn+"'";
                //c.s.executeUpdate(query2);

                //JOptionPane.showMessageDialog(null, "Deleted Successfully");
                //setVisible(false); 
               // new CustomerDetails();
                new CustomerBill(str); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource() == Print) {
             String str=Accountn.getText();
             
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        
        else if (ae.getSource() == Back) {
             String str=Accountn.getText();
             
            try {
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
             //System.out.println(str);
            
            
        

    }
    

    public static void main(String[] args) {
        new DashBord();
    }
}
