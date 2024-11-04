
package ttm;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;

    public ViewBookedHotel(String username)
    {
        setBounds(450,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text=new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,400,30);
        add(text);
        
        
        
        JLabel lblun=new JLabel("Username");
        lblun.setBounds(30,50,150,25);
        add(lblun);
        
         JLabel lblusername=new JLabel();
        lblusername.setBounds(220,50,150,25);
        add(lblusername);
        
         JLabel lblid=new JLabel("Hotel Name");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
         JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        
        JLabel lbnumber=new JLabel("Total Persons");
        lbnumber.setBounds(30,130,150,25);
        add(lbnumber);
        
         JLabel labelperson=new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        
        JLabel lbldays=new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
         JLabel labeldays=new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);
        
        JLabel lblac=new JLabel("AC-NON_AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);
        
         JLabel labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);
        
        JLabel food=new JLabel("Food Included");
       food.setBounds(30,250,150,25);
        add(food);
        
         JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);
        
        
        
        
        
         JLabel lbladdress=new JLabel("Total Cost");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
         JLabel labelprice=new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        
        
               
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(130,330,100,25);
      add(back);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(430,10,500,400);
        add(image);
        
        
        
     
        
        try{
            Conn c=new Conn();
            String query="select * from HotelBook where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
               
            
                  labelpackage.setText(rs.getString("name"));
                  labelprice.setText(rs.getString("price"));
                  
                   labelperson.setText(rs.getString("persons"));
                   labelfood.setText(rs.getString("food"));
                   labelac.setText(rs.getString("ac"));
                   labeldays.setText(rs.getString("days"));
                   
                     
                
            }
            
        }catch(Exception e)
        {
            
            e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==back)
       {
           setVisible(false);
           
       }
        
    }
    
    
    
    
    public static void main(String args[])
    {
        new ViewBookedHotel("Parth");
    }
    
}
