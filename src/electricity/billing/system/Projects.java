/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Sumit Prajapati
 */
public class Projects extends JFrame implements ActionListener {
    
    String atype,Accountn;
    Projects(String atype,String Accountn)
    {
        this.atype=atype;
        this.Accountn=Accountn;
      setExtendedState(JFrame.MAXIMIZED_BOTH); 
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/mainImages.jpg"));
      Image i2= i1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      add(image);
      
      
      JMenuBar mb=new JMenuBar();
      setJMenuBar(mb);
      
      JMenu master=new JMenu("Master");
      master.setForeground(Color.BLUE);
      
      JMenu Dashbord=new JMenu("Dashboard");
      Dashbord.setForeground(Color.BLUE);
      Dashbord.addActionListener(this);
      
      //mb.add(master);
       JMenuItem Dashh=new JMenuItem("DashBoard");
      Dashh.setFont(new Font("monospaced",Font.PLAIN,25));
      Dashh.setBackground(Color.white);
      ImageIcon icon87=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
      Image image55=icon87.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      Dashh.setIcon(new ImageIcon(image55));
      Dashh.setMnemonic('D');
      Dashh.addActionListener(this);
      Dashh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
      Dashbord.add(Dashh);
      
      
      
      
      JMenuItem newcustomer=new JMenuItem("New Customer");
      newcustomer.setFont(new Font("monospaced",Font.PLAIN,25));
      newcustomer.setBackground(Color.white);
      ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
      Image image1=icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      newcustomer.setIcon(new ImageIcon(image1));
      newcustomer.setMnemonic('D');
      newcustomer.addActionListener(this);
      newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
      master.add(newcustomer);
      
      
      
      JMenuItem customerdetails=new JMenuItem("Customer Details");
      customerdetails.setFont(new Font("monospaced",Font.PLAIN,25));
      customerdetails.setBackground(Color.white);
      ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
      Image image2=icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      customerdetails.setIcon(new ImageIcon(image2));
      customerdetails.addActionListener(this);
      customerdetails.setMnemonic('C');
      customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
      master.add(customerdetails);
      
      
      
      /*JMenuItem Depositedetails=new JMenuItem("Deposite Details");
      Depositedetails.setFont(new Font("monospaced",Font.PLAIN,25));
      Depositedetails.setBackground(Color.white);
      ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
      Image image3=icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      Depositedetails.setIcon(new ImageIcon(image3));
      Depositedetails.setMnemonic('M');
      Depositedetails.addActionListener(this);
      Depositedetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
      master.add(Depositedetails);
*/
      
      
      
      
      
      JMenuItem CalculateBill=new JMenuItem("Generate Bill Cycle");
      CalculateBill.setFont(new Font("monospaced",Font.PLAIN,25));
      CalculateBill.setBackground(Color.white);
      ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
      Image image4=icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      CalculateBill.setIcon(new ImageIcon(image4));
      CalculateBill.setMnemonic('D');
      CalculateBill.addActionListener(this);
      CalculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
      master.add(CalculateBill);
      
      
      JMenu info=new JMenu("Information");
      info.setForeground(Color.RED);
      //mb.add(info);
      
      JMenuItem updateInformation=new JMenuItem("View Information");
      updateInformation.setFont(new Font("monospaced",Font.PLAIN,25));
      updateInformation.setBackground(Color.white);
      ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
      Image image5=icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      updateInformation.setIcon(new ImageIcon(image5));
      updateInformation.setMnemonic('L');
      updateInformation.addActionListener(this);
      updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
      info.add(updateInformation);
      
      
      /*
      JMenuItem ViewInformation=new JMenuItem("View Information");
     ViewInformation.setFont(new Font("monospaced",Font.PLAIN,25));
      ViewInformation.setBackground(Color.white);
      ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
      Image image6=icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      ViewInformation.setIcon(new ImageIcon(image6));
      ViewInformation.setMnemonic('P');
      ViewInformation.addActionListener(this);
      ViewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
     info.add(ViewInformation);

*/
              
              
       JMenu user=new JMenu("View & Pay Bill");
      user.setForeground(Color.BLUE);
      //mb.add(user);     
      
      
       JMenuItem paybill=new JMenuItem("Pay bill");
     paybill.setFont(new Font("monospaced",Font.PLAIN,25));
      paybill.setBackground(Color.white);
      ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
      Image image7=icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
     paybill.setIcon(new ImageIcon(image7));
    paybill.addActionListener(this);
      paybill.setMnemonic('v');
      paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
      user.add(paybill);
      
      
       JMenuItem BillDetails=new JMenuItem("Bill Details");
     BillDetails.setFont(new Font("monospaced",Font.PLAIN,25));
      BillDetails.setBackground(Color.white);
      ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
      Image image8=icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      BillDetails.setIcon(new ImageIcon(image8));
      BillDetails.setMnemonic('Z');
       BillDetails.addActionListener(this);
      BillDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
     user.add(BillDetails);
      
      
      
      JMenu report=new JMenu("Print Bill");
      report.setForeground(Color.RED);
     // mb.add(report);
      
      JMenuItem genrateBill=new JMenuItem("Print BILL");
      genrateBill.setFont(new Font("monospaced",Font.PLAIN,25));
      genrateBill.setBackground(Color.white);
      ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
      Image image9=icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      genrateBill.setIcon(new ImageIcon(image9));
      genrateBill.setMnemonic('L');
      genrateBill.addActionListener(this);
      genrateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
      report.add(genrateBill);
      
      
      JMenu utility=new JMenu("Utility");
      utility.setForeground(Color.BLUE);
      //mb.add(utility);
      
      JMenuItem notepad=new JMenuItem("Notepad");
      notepad.setFont(new Font("monospaced",Font.PLAIN,25));
      notepad.setBackground(Color.white);
      ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
      Image image10=icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      notepad.setIcon(new ImageIcon(image10));
      notepad.setMnemonic('U');
      notepad.addActionListener(this);
      notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
      utility.add(notepad);
      
      JMenuItem calculator=new JMenuItem("Calculator");
      calculator.setFont(new Font("monospaced",Font.PLAIN,25));
      calculator.setBackground(Color.white);
      ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
      Image image11=icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      calculator.setIcon(new ImageIcon(image11));
      calculator.setMnemonic('U');
      calculator.addActionListener(this);
      calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
      utility.add(calculator);
      
      
      JMenu mexit=new JMenu("Exit");
      mexit.setForeground(Color.RED);
      
      mb.add(mexit);
      
      JMenuItem exit=new JMenuItem("Log Out");
     exit.setFont(new Font("monospaced",Font.PLAIN,25));
      exit.setBackground(Color.white);
      ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
      Image image12=icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
      //exit.addActionListener(this);
      exit.setIcon(new ImageIcon(image12));
      
      exit.setMnemonic('U');
      exit.addActionListener(this);
      exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
      mexit.add(exit);
      
      
        if (atype.equals("Admin")) {
            mb.add(master);
            mb.add(Dashbord);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        
        mb.add(utility);
        mb.add(mexit);
      
      setLayout(new FlowLayout());
      
      
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
    
        if (msg.equals("New Customer")) {
            new NewCustomer();
        }
        else if (msg.equals("Customer Details")) {
            new CustomerDetails();
            }
        else if (msg.equals("Deposite Details")) {
            new DepositeDetails();
            }
        else if (msg.equals("Generate Bill Cycle")) {
            new GenrateBillCycle();
            }
        else if (msg.equals("View Information")) {
            new UpdateInformation(Accountn);
            }
        else if (msg.equals("Update Information")) {
            new UpdateInformation(Accountn);
            }
        else if (msg.equals("Bill Details")) {
            new CustomerBill(Accountn);
            }
        else if (msg.equals("DashBoard")) {
            new DashBord();
            }
        else if (msg.equals("Print BILL")) {
            new GenerateBill(Accountn);
            }
        else if (msg.equals("Notepad")) {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");
                
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            }
        else if (msg.equals("Calculator")) {
             try
            {
                Runtime.getRuntime().exec("calc.exe");
                
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            }
        else if (msg.equals("Log Out")) {
            setVisible(false);
            new Login();
            }
        else if(msg.equals("Pay bill"))
        {
            new PayBill(Accountn);
        }
        else if(msg.equals("Genrate Bill"))
        {
            new GenerateBill(Accountn);
        }
    }
    
    public static void main(String[] args)
    {
        new Projects("","");
    }
}
