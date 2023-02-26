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

public class CustomerDetails extends JFrame implements ActionListener {

    Choice meternumber, cmonth;
    JTable table;
    JButton search, print, printtt, Select,Delete;
    JTextField Accountn, Unitn;
    JButton Update;

    CustomerDetails() {
        super("Customer Details");

        setSize(900, 900);
        setLocation(400, 150);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Account Number");
        lblusername.setBounds(10, 20, 100, 20);
        add(lblusername);
        
        Accountn = new JTextField();
        Accountn.setBounds(150, 20, 150, 20);
        add(Accountn);

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
        table = new JTable();
        try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from Customer");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
/*
        
        */
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 60, 900, 600);
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
                Accountn.setText(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString());

            }
        });
        
        

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() ==Update) {
            try {
                //System.out.println(Accountn.getText());
                    Conn c = new Conn();
                    String query1 = "update customer SET status='Deactive' where Account_No='"+Accountn.getText()+"'";
                    c.s.executeUpdate(query1);
                    
                    JOptionPane.showMessageDialog(null, "Deactivated");
                //setVisible(false); 
                new CustomerDetails();

                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        else if (ae.getSource() ==Delete) {
            try {
                //System.out.println(Accountn.getText());
                    Conn c = new Conn();
                    String query2 = "Delete from customer where Account_No='"+Accountn.getText()+"'";
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                //setVisible(false); 
                new CustomerDetails();

                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            

    }

    public static void main(String[] args) {
        new CustomerDetails();
    }
}
