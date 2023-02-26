package electricity.billing.system;

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



public class CustomerBill extends JFrame implements ActionListener{
    
    JTable table;
    JButton Print,Payy,Back;
    JTextField Outs;
    String meter;
    CustomerBill(String meter) {
        super("Customer Bill Details");
        this.meter=meter;
        
       

        setSize(750, 700);
        setLocation(300, 40);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bill where Account_No= '"+meter+"'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        /*
        
         */
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 10, 750, 500);
        add(sp);
        
        JLabel Outstanding = new JLabel("Outstanding");
        Outstanding.setBounds(200, 530, 100, 20);
        add(Outstanding);
        
        
       Outs = new JTextField();
        Outs.setBounds(300, 530, 150, 20);
        add(Outs);
        
        
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image i23 = i22.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Payy = new JButton("Pay", new ImageIcon(i23));
        Payy.setBounds(450, 530, 100, 20);
        Payy.addActionListener((ActionListener) this);
        
        
        
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image i17 = i16.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Print = new JButton("Print", new ImageIcon(i17));
        Print.setBounds(260, 600, 100, 20);
        Print.addActionListener((ActionListener) this);
        add(Print);
        
        ImageIcon i25 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image i26 = i16.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Back = new JButton("Back", new ImageIcon(i26));
        Back.setBounds(400, 600, 100, 20);
       Back.addActionListener((ActionListener) this);
        add(Back);
        
              /*ImageIcon i18 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i19 = i18.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        ViewCustomer = new JButton("View Customer Details", new ImageIcon(i19));
        ViewCustomer.setBounds(300, 20, 200, 20);
        ViewCustomer.addActionListener(this);
        
        
        
        add(ViewCustomer);
*/
              
              
              
                try {
            Conn c = new Conn();
            String check="NOT PAID";
            ResultSet rs = c.s.executeQuery("select sum(totalbill)as Summm from bill where Account_No='"+meter+"' AND status='"+check+"'");
            
            //System.out.println(rs);
            //int summ=rs.getInt("Summm");
            //System.out.println(summ);
            int count=0;
           while (rs.next()) {

             count = rs.getInt("Summm") ;
               
                 System.out.println(count);
                 
                 
            }
           String summm=String.valueOf(count);
           
           Outs.setText(summm);
           //c.s.executeUpdate("Update OutstandingBill SET Account_No='"+meter+"',outstanding='"+count+"',LastPaid='NOT YET PAID' where Account_No='"+meter+"'");
             
              
               }catch (Exception e) {
                e.printStackTrace();
            }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {

        
          if (ae.getSource()==Print)
              
          {
              try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
          else if(ae.getSource()==Payy){
              new PayTotal(meter);
                 }
              else if(ae.getSource()==Back){
              new DashBord();   
        
        }
    }

    public static void main(String[] args) {
        new CustomerBill("");
    }
}