
package ttm;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class ViewPackage extends JFrame implements ActionListener{
    JButton back;

    public ViewPackage(String username)
    {
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text=new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);
        
        
        
        JLabel lblun=new JLabel("Username");
        lblun.setBounds(30,50,150,25);
        add(lblun);
        
         JLabel lblusername=new JLabel();
        lblusername.setBounds(220,50,150,25);
        add(lblusername);
        
         JLabel lblid=new JLabel("Package");
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
        
        
        JLabel lblname=new JLabel("Id");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
         JLabel labelid=new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        JLabel lblgender=new JLabel("Number");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
         JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        
        
        JLabel lblcountry=new JLabel("PhoneNo");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
         JLabel labelphone=new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
        
        
         JLabel lbladdress=new JLabel("Price");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
         JLabel labelprice=new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        
        
        
         
        
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(130,360,100,25);
      add(back);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(430,10,500,400);
        add(image);
        
        
        
     
        
        try{
            Conn c=new Conn();
            String query="select * from bookpackage where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                 labelnumber.setText(rs.getString("number"));
                  labelpackage.setText(rs.getString("package"));
                  labelprice.setText(rs.getString("price"));
                   labelphone.setText(rs.getString("phone"));
                   labelperson.setText(rs.getString("persons"));
                    
                     
                
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
        new ViewPackage("Parth");
    }
    
}
