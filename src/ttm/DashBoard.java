
package ttm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.event.*;


public class DashBoard  extends JFrame implements ActionListener{
     
    String username;
    JButton addpd,updatepd,viewpd,deletepd,checkpackage,bookpackage,viewpackage,viewhotels,bookhotel,viewbookedhotel,destinations,payment,calculator,notepad,about;
    DashBoard(String username)
    {
       
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(5,0,70,70);
        p1.add(image);
        
        JLabel heading=new JLabel("DashBoard");
        heading.setForeground(Color.WHITE);
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,16));
        p1.add(heading);
        
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        
        addpd=new JButton("Add Personal Details");
         addpd.setBounds(0,0,300,50);
         addpd.setBackground(new Color(0,0,102));
         addpd.setForeground(Color.WHITE);
         addpd.addActionListener(this);
   
         addpd.setFont(new Font("Tahoma",Font.PLAIN,20));
     
   
         p2.add(addpd);
      
         updatepd=new JButton("Update Personal Details");
         updatepd.setBounds(0,50,350,50);
         updatepd.setBackground(new Color(0,0,102));
         updatepd.setForeground(Color.WHITE);
         updatepd.addActionListener(this);
         updatepd.setFont(new Font("Tahoma",Font.PLAIN,20));
         
       
         p2.add(updatepd);
         
         viewpd=new JButton("View Details");
         viewpd.setBounds(0,100,300,50);
         viewpd.setBackground(new Color(0,0,102));
         viewpd.setForeground(Color.WHITE);
         viewpd.addActionListener(this);
         viewpd.setFont(new Font("Tahoma",Font.PLAIN,20));
   
  
         p2.add(viewpd);
         
         deletepd=new JButton("Delete Personal Details");
         deletepd.setBounds(0,150,300,50);
         deletepd.setBackground(new Color(0,0,102));
         deletepd.setForeground(Color.WHITE);
         deletepd.addActionListener(this);
         deletepd.setFont(new Font("Tahoma",Font.PLAIN,20));

         p2.add(deletepd);
      
         
         checkpackage=new JButton("Check Packages");
         checkpackage.setBounds(0,200,300,50);
         checkpackage.setBackground(new Color(0,0,102));
         checkpackage.setForeground(Color.WHITE);
         checkpackage.addActionListener(this);addpd.addActionListener(this);
         checkpackage.setFont(new Font("Tahoma",Font.PLAIN,20));

         p2.add(checkpackage);
         
         bookpackage=new JButton("Book Packages");
         bookpackage.setBounds(0,250,300,50);
         bookpackage.setBackground(new Color(0,0,102));
         bookpackage.setForeground(Color.WHITE);
         bookpackage.addActionListener(this);
         bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
     
         p2.add(bookpackage);
         
         viewpackage=new JButton("View Packages");
         viewpackage.setBounds(0,300,300,50);
         viewpackage.setBackground(new Color(0,0,102));
         viewpackage.setForeground(Color.WHITE);
         viewpackage.addActionListener(this);
         viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
  
         p2.add(viewpackage);
         
         viewhotels=new JButton("View Hotels");
         viewhotels.setBounds(0,350,300,50);
         viewhotels.setBackground(new Color(0,0,102));
         viewhotels.setForeground(Color.WHITE);
         viewhotels.addActionListener(this);
         viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));

         p2.add(viewhotels);
         
         bookhotel=new JButton("Book Hotel");
         bookhotel.setBounds(0,400,300,50);
         bookhotel.setBackground(new Color(0,0,102));
         bookhotel.setForeground(Color.WHITE);
         bookhotel.addActionListener(this);
         bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
    
         p2.add(bookhotel);
         
         viewbookedhotel=new JButton(" View Booked Hotel");
         viewbookedhotel.setBounds(0,450,300,50);
         viewbookedhotel.setBackground(new Color(0,0,102));
         viewbookedhotel.setForeground(Color.WHITE);
         viewbookedhotel.addActionListener(this);
         viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        
         p2.add(viewbookedhotel);
         
         
         destinations=new JButton("Destinations");
         destinations.setBounds(0,500,300,50);
         destinations.setBackground(new Color(0,0,102));
         destinations.setForeground(Color.WHITE);
         destinations.addActionListener(this);
         destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
    
         p2.add(destinations);
         
         
         payment=new JButton("Payment");
         payment.setBounds(0,550,300,50);
         payment.setBackground(new Color(0,0,102));
         payment.setForeground(Color.WHITE);
         payment.addActionListener(this);
         payment.setFont(new Font("Tahoma",Font.PLAIN,20));
     
         p2.add(payment);
         
         calculator=new JButton("Calculator");
         calculator.setBounds(0,600,300,50);
         calculator.setBackground(new Color(0,0,102));
         calculator.setForeground(Color.WHITE);
         calculator.addActionListener(this);
         calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
     
         p2.add(calculator);
         
         notepad=new JButton("Notepad");
         notepad.setBounds(0,650,300,50);
         notepad.setBackground(new Color(0,0,102));
         notepad.setForeground(Color.WHITE);
         notepad.addActionListener(this);
         notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
         
         p2.add(notepad);
         
         
         about=new JButton("About");
         about.setBounds(0,700,300,30);
         about.setBackground(new Color(0,0,102));
         about.setForeground(Color.WHITE);
         about.addActionListener(this);
         about.setFont(new Font("Tahoma",Font.PLAIN,20));
      
         p2.add(about);
         
         
         
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        
        image2.setBounds(0,0,1650,1000);
        add(image2);
        
        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setFont(new Font("Raleway",Font.BOLD,55));
        text.setForeground(Color.WHITE);
        text.setBounds(400,70,1200,70);
        image2.add(text);
         
         
         
      
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == addpd)
        {
             new AddCustomer(username);
        }
        else if(ae.getSource()==updatepd)
        {
             new UpdateCustomer(username);
        }
        else if(ae.getSource()==viewpd)
        {
             new ViewCustomer(username);
        }
        else if(ae.getSource()==checkpackage)
        {
            new CheckPackage();
        }
        else if(ae.getSource()==bookpackage)
        {
            new BookPackage(username);
        }
        else if(ae.getSource()==viewpackage)
        {
            new ViewPackage(username);
        }
        else if(ae.getSource()==viewhotels)
        {
            new CheckHotels();
        }
        else if(ae.getSource()==destinations)
        {
            new Destinations();
        }
       else if(ae.getSource()==bookhotel)
        {
            new BookHotel(username);
        }
        else if(ae.getSource()==viewbookedhotel)
        {
            new ViewBookedHotel(username);
        }
         else if(ae.getSource()==payment)
        {
            new Payment();
        }
         else if(ae.getSource()==calculator)
        {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                
                e.printStackTrace();
            }
        }
         else if(ae.getSource()==notepad)
        {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==deletepd)
        {
            new DeleteData(username);
        }
        
    }
    public static void main(String args[])
    {
        new DashBoard("");
        
    }
}