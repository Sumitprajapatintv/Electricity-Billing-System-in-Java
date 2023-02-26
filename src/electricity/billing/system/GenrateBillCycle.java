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

public class GenrateBillCycle extends JFrame implements ActionListener {

    Choice meternumber, cmonth;
    JTable table;
    JButton search, print, printtt, Select;
    JTextField Accountn, Unitn;
    JButton Update;

    GenrateBillCycle() {
        super("Genrate Bill Cycle");

        setSize(700, 700);
        setLocation(400, 150);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        //JLabel lblmeternumber = new JLabel("Select");
        //lblmeternumber.setBounds(20, 20, 150, 20);
        //add(lblmeternumber);
        /*meternumber = new Choice();
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
        JLabel lblmonth = new JLabel("By Month");
        lblmonth.setBounds(10, 20, 60, 20);
        add(lblmonth);

        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i17 = i16.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Select = new JButton("Select", new ImageIcon(i17));
        Select.setBounds(15, 60, 100, 20);
        Select.addActionListener(this);
        add(Select);

        cmonth = new Choice();
        cmonth.setBounds(100, 20, 100, 20);
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

        JLabel lblusername = new JLabel("Account Number");
        lblusername.setBounds(220, 20, 100, 20);
        add(lblusername);
        Accountn = new JTextField();
        Accountn.setBounds(350, 20, 150, 20);
        add(Accountn);

        JLabel lblunit = new JLabel("Unit");
        lblunit.setBounds(220, 50, 100, 20);
        add(lblunit);
        Unitn = new JTextField();
        Unitn.setBounds(350, 50, 150, 20);
        add(Unitn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Update = new JButton("Update", new ImageIcon(i2));
        Update.setBounds(520, 50, 100, 20);
        Update.addActionListener(this);
        add(Update);

        table = new JTable();

        if (cmonth.getSelectedItem() == "January") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billJanuary2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "February") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billFeb2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "March") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billMar2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "April") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billApr2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "May") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billMay2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "June") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billJune2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "July") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billJul2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "August") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billAug2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "September") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billSep2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "October") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billOct2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "November") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billNov2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (cmonth.getSelectedItem() == "December") {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from billDec2023");

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
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

        if (ae.getSource() == Select) {
            if (cmonth.getSelectedItem() == "February") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billFeb2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "March") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billMar2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "April") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billApr2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "May") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billMay2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "June") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billJune2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "July") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billJul2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "August") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billAug2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "September") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billSep2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "October") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billOct2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "November") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billNov2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (cmonth.getSelectedItem() == "December") {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from billDec2023");

                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } /*
        }
        if (ae.getSource() == Select) {
            String query = "select * from '"+cmonth.getSelectedItem()+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                
              
            } catch (Exception e) {
                
            }


        }*/ else if (ae.getSource() == Update) {
            try {
                String Unitt = Unitn.getText();
                String Accnn = Accountn.getText();
                new CalculateBill(Accnn, Unitt, cmonth.getSelectedItem());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new GenrateBillCycle();
    }
}
