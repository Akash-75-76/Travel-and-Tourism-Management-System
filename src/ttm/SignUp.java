package ttm;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener
{
    JButton create,back;
    JTextField tfun,tfname,tfpass,tfans;
    Choice  security;
    
    SignUp()
    {
        
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel un=new JLabel("Username");
        un.setFont(new Font("Tahoma",Font.BOLD,14));
        un.setBounds(50,20,125,25);
        p1.add(un);
        
        
        tfun=new JTextField();
        tfun.setBounds(190,20,180,25);
        tfun.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfun);
        
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setBounds(50,60,125,25);
        p1.add(name);
        
        tfname=new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel pass=new JLabel("Password");
        pass.setFont(new Font("Tahoma",Font.BOLD,14));
        pass.setBounds(50,100,125,25);
        p1.add(pass);
        
        tfpass=new JTextField();
        tfpass.setBounds(190,100,180,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);
        
        
        JLabel sq=new JLabel("Security Question");
        sq.setFont(new Font("Tahoma",Font.BOLD,14));
        sq.setBounds(50,140,125,25);
        p1.add(sq);
        
        
        security=new Choice();
        security.add("Fav Player In Cricket");
        security.add("Your Lucy name");
        security.add("Your Fav Dish");
        security.add("Fav cartoon");
        security.add("Fav Destination");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        
        JLabel lblan=new JLabel("Answer");
        lblan.setFont(new Font("Tahoma",Font.BOLD,14));
        lblan.setBounds(50,180,125,25);
        p1.add(lblan);
        
        tfans=new JTextField();
        tfans.setBounds(190,180,180,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        
        create=new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back=new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==create)
        {
            String username=tfun.getText();
            String name=tfname.getText();
            String password=tfpass.getText();
            String question=security.getSelectedItem();
            String answer=tfans.getText();
            
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Succsessfully");
                setVisible(false);
                new login();
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new login();
         
        }
        
    }
   
    public static void main(String args[])
    {
     new SignUp();
    }
    
}

