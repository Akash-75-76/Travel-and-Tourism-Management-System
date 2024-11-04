
package ttm;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class FogetPassword extends JFrame implements ActionListener
{
    JTextField tfun,tfname,tfans,tfquestion,tfpass;
    JButton search,retrive,back;
    FogetPassword()
    {
        setBounds(350,200,850,380);
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel un=new JLabel("Username");
        un.setFont(new Font("Tahoma",Font.BOLD,14));
        un.setBounds(40,20,100,25);
        p1.add(un);
        
        
         tfun=new JTextField();
        tfun.setBounds(220,20,150,25);
        tfun.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfun);
        
        search=new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(40,60,100,25);
        p1.add(lblname);
        
        
        tfname=new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel sq=new JLabel(" Security Question");
        sq.setFont(new Font("Tahoma",Font.BOLD,14));
        sq.setBounds(40,100,160,25);
        p1.add(sq);
        
        
        tfquestion=new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(40,140,150,25);
        p1.add(lblanswer);
        
        
        tfans=new JTextField();
        tfans.setBounds(220,140,150,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        retrive=new JButton("Retrive");
        retrive.setBackground(Color.gray);
        retrive.setForeground(Color.white);
        retrive.setBounds(380,140,100,25);
        retrive.addActionListener(this);
        p1.add(retrive);
        
        JLabel lblpass=new JLabel("Pasword");
        lblpass.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpass.setBounds(40,180,150,25);
        p1.add(lblpass);
        
        
        tfpass=new JTextField();
        tfpass.setBounds(220,180,150,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);
        
        
        back=new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
         try{
             String query="select * from account where username= '"+tfun.getText()+"'";
             Conn c=new Conn();
             ResultSet rs =c.s.executeQuery(query);
             while(rs.next())
             {
                 tfname.setText(rs.getString("name"));
                 tfquestion.setText(rs.getString("security"));
             }
             
         }catch(Exception e)
         {
            e.printStackTrace();
         }
        }
        else if(ae.getSource()==retrive)
        {
            try{
            String query="select * from account where ans= '"+tfans.getText()+"' AND  username ='"+tfun.getText()+"'";
             Conn c=new Conn();
             ResultSet rs =c.s.executeQuery(query);
             while(rs.next())
             {
                 tfpass.setText(rs.getString("password"));
                 tfquestion.setText(rs.getString("security"));
             }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(true);
            new login();
        }
    }
    public static void main(String args[])
    {
        new FogetPassword();
    }
    
}
