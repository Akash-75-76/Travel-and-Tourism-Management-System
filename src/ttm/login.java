
package ttm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.*;


public class login extends JFrame  implements ActionListener{
    
    JButton password,login,signup;
    JTextField tfUname;
    JPasswordField tfpass;
    login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        add(p1);
        
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,150,200,240);
         p1.add(image);
         
         JPanel  p2=new JPanel();
         p2.setLayout(null);
         p2.setBounds(400,30,450,300);
         add(p2);
         
         JLabel lblUname=new JLabel("Username");
         lblUname.setBounds(60,20,100,25);
         lblUname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
         p2.add(lblUname);
         
        tfUname=new JTextField();
         tfUname.setBounds(60,60,300,30);
         p2.add(tfUname);
         tfUname.setBorder(BorderFactory.createEmptyBorder());
         
          JLabel lblpass=new JLabel("Password");
         lblpass.setBounds(60,110,100,25);
         lblpass.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
         p2.add(lblpass);
         
         tfpass=new JPasswordField();
         tfpass.setBounds(60,150,300,30);
         p2.add(tfpass);
         tfpass.setBorder(BorderFactory.createEmptyBorder());
         
         
         login=new JButton("Login");
         login.setBounds(60,200,130,30);
         login.setBackground(new Color(133,193,233));
         login.setForeground(Color.WHITE);
         login.setBorder(new LineBorder(new Color(133,193,233)));
         login.addActionListener(this);
         p2.add(login);
         
         
          signup=new JButton("SignUp");
         signup.setBounds(230,200,130,30);
         signup.setBackground(new Color(133,193,233));
         signup.setForeground(Color.WHITE);
         signup.setBorder(new LineBorder(new Color(133,193,233)));
         signup.addActionListener(this);
         p2.add(signup);
         
         
         
         password=new JButton("Forgot Password");
         password.setBounds(130,250,130,30);
         password.setBackground(new Color(133,193,233));
         password.setForeground(Color.WHITE);
         password.setBorder(new LineBorder(new Color(133,193,233)));
         password.addActionListener(this);
         p2.add(password);
         
         
         JLabel text=new JLabel("Trouble In Login");
         text.setBounds(300,250,150,20);
         text.setForeground(Color.RED);
         p2.add(text);
         
         
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            try{
                String username=tfUname.getText();
                String pass=tfpass.getText();
                String query="Select * from account where username='"+username+"' AND password='"+pass+"'";
                Conn c=new Conn();
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Loading(username);
                   
               }
               else
               {
                   
                   JOptionPane.showMessageDialog(null, "Incorrect Username or password");
               }
                
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignUp();
        }
        else
        {
            
            setVisible(false);
            new FogetPassword();
        }
        
    }
    public static void main(String args[])
    {
        new login();
    }
    
}
