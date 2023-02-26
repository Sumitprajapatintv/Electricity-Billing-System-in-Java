/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class Spalash extends JFrame implements Runnable{
    Thread t;
    
    Spalash()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/mainSpalash.jpg"));
        Image i2=i1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);
        //int x=1;
        
            setSize(720,500);
            setLocation(250,100);
            try
            {
                Thread.sleep(500);
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
        
        t=new Thread(this);
        t.start();
        setVisible(true);
      
    }
    public void run()
    {
        try{
            Thread.sleep(300);
            setVisible(false);
            
            new Login();
        }catch(Exception e)
        {
            e.printStackTrace(); 
        }
    }
    
    public static void main(String[] args)
    {
        new Spalash();
    }
}
