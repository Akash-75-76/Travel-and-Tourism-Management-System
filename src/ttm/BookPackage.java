
package ttm;
import java.awt.*;
import javax.swing.*;
import java. awt.event.*;
import java.sql.*;

public class BookPackage  extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField persons;
    String username;
    JLabel lblun,lblusername,lbnumber, lblname,  labelname,lblgender,labelgender,lblcountry,labelcountry,lbltotal,labelprice;
    JButton checkprice,bookpackage,Back;
    BookPackage(String username){
        this.username=username;
        
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Book Package");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
          
        lblun=new JLabel("Username");
        lblun.setBounds(40,70,100,20);
        lblun.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblun);
        
        lblusername=new JLabel();
        lblusername.setBounds(250,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblusername);
        
         JLabel lblchoice=new JLabel("Select Package");
        lblchoice.setBounds(40,110,150,20);
        lblchoice.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblchoice);
        
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,100,20);
        add(cpackage);
        
        
         JLabel labelid=new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);
        
        lbnumber=new JLabel("Total Persons");
        lbnumber.setBounds(40,150,150,25);
        lbnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbnumber);
        
         persons=new JTextField("1");
         persons.setBounds(250,150,200,25);
         add(persons);
         
        
         lblname=new JLabel("ID");
        lblname.setBounds(40,190,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);
        
         labelname=new JLabel();
        labelname.setBounds(250,190,200,25);
        add(labelname);
        
        lblgender=new JLabel("Number");
        lblgender.setBounds(40,230,150,25);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblgender);
        
        labelgender=new JLabel();
        labelgender.setBounds(250,230,150,25);
        add(labelgender);
        
        
        lblcountry=new JLabel("Phone");
        lblcountry.setBounds(40,270,150,20);
        lblcountry.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcountry);
        
        labelcountry=new JLabel();
        labelcountry.setBounds(250,270,200,25);
        add(labelcountry);
        
        
        lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,310,200,25);
        add(labelprice);
        
        try{
            Conn c=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
           
                     labelname.setText(rs.getString("id"));
                labelcountry.setText(rs.getString("email"));
                labelgender.setText(rs.getString("gender"));
                
                    
                
            }
            
        }catch(Exception e)
        {
            
            e.printStackTrace();
        }
        
         checkprice=new JButton("Check Price");
    checkprice.setBackground(Color.black);
    checkprice.setForeground(Color.white);
    checkprice.setBounds(60,380,120,25);
    checkprice.addActionListener(this);
    add(checkprice);

    
     bookpackage=new JButton("Book Package");
    bookpackage.setBackground(Color.black);
    bookpackage.setForeground(Color.white);
    bookpackage.setBounds(200,380,120,25);
    bookpackage.addActionListener(this);
    add(bookpackage);
    
    
     Back=new JButton("Back");
    Back.setBackground(Color.black);
    Back.setForeground(Color.white);
    Back.setBounds(340,380,120,25);
    Back.addActionListener(this);
    add(Back);

    
     
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);

        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==checkprice)
       {
           String pack = cpackage.getSelectedItem();
           int  cost=0;
           if(pack.equals("Gold Package"))
           {
               cost+=12000;
           }
           else if(pack.equals("Silver Package"))
           {
               cost+=25000;
               
           }
           else{
               
              cost+=32000; 
               
           }
           int person=Integer.parseInt(persons.getText());
           cost*=person;
           labelprice.setText("Rs "+cost);
       }
       else if(ae.getSource()==bookpackage)
       {
           try{
               Conn c=new Conn();
               c.s.executeUpdate("insert into bookpackage values('"+lblusername.getText()+"','"+cpackage.getSelectedItem()+"','"+persons.getText()+"','"+labelname.getText()+"','"+labelgender.getName()+"','"+labelcountry.getText()+"','"+labelprice.getText()+"')");
               JOptionPane.showMessageDialog(null, "Package Booked Successfully");
               setVisible(false);
           }catch(Exception e){
               e.printStackTrace();
           }
       }
       else
       {
           setVisible(false);
           
       }
    }
                                               
    public static void main(String args[])
    {
        new BookPackage("Parth");
    }
    
}
