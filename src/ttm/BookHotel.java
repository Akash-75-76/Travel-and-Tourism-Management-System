
package ttm;
import java.awt.*;
import javax.swing.*;
import java. awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField tfdays,persons;
    String username;
    JLabel lblun,lblusername,lbnumber, lblname,  labelname,lblfood,lblgender,labelgender,lblcountry,labelcountry,lbltotal,labelprice,lbldays,lblac;
    JButton checkprice,bookpackage,Back;
    BookHotel(String username){
        this.username=username;
        
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Book Hotel");
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
        
         JLabel lblchoice=new JLabel("Select Hotel");
        lblchoice.setBounds(40,110,150,20);
        lblchoice.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblchoice);
        
        chotel=new Choice();
        chotel.setBounds(250,110,100,20);
        add(chotel);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next())
            {
                chotel.add(rs.getString("name"));
                
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        
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
         
         lbldays=new JLabel("No Of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbldays);
        
         tfdays=new JTextField("1");
         tfdays.setBounds(250,190,200,25);
         add(tfdays);
         
         lblac=new JLabel("AC/NON-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblac);
        
        cac=new Choice();
        cac.add("AC");
        cac.add("NON-AC");
        cac.setBounds(250,230,100,20);
        add(cac);
        
        lblfood=new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfood);
        
        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,100,20);
        add(cfood);
        
   
         
         
        
         lblname=new JLabel("ID");
        lblname.setBounds(40,310,150,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);
        
         labelname=new JLabel();
        labelname.setBounds(250,310,200,25);
        add(labelname);
        
        lblgender=new JLabel("Number");
        lblgender.setBounds(40,350,150,25);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblgender);
        
        labelgender=new JLabel();
        labelgender.setBounds(250,350,150,25);
        add(labelgender);
        
        
        lblcountry=new JLabel("Phone");
        lblcountry.setBounds(40,390,150,20);
        lblcountry.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcountry);
        
        labelcountry=new JLabel();
        labelcountry.setBounds(250,390,200,25);
        add(labelcountry);
        
        
        lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,430,200,25);
        add(labelprice);
        
        try{
            Conn c=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
           
                     labelname.setText(rs.getString("id"));
                labelcountry.setText(rs.getString("phone"));
                labelgender.setText(rs.getString("gender"));
                
                    
                
            }
            
        }catch(Exception e)
        {
            
            e.printStackTrace();
        }
        
    checkprice=new JButton("Check Price");
    checkprice.setBackground(Color.black);
    checkprice.setForeground(Color.white);
    checkprice.setBounds(60,490,120,25);
    checkprice.addActionListener(this);
    add(checkprice);

    
     bookpackage=new JButton("Book Hotel");
    bookpackage.setBackground(Color.black);
    bookpackage.setForeground(Color.white);
    bookpackage.setBounds(200,490,120,25);
    bookpackage.addActionListener(this);
    add(bookpackage);
    
    
     Back=new JButton("Back");
    Back.setBackground(Color.black);
    Back.setForeground(Color.white);
    Back.setBounds(340,490,120,25);
    Back.addActionListener(this);
    add(Back);

    
     
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
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
           try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
           while(rs.next())
           {
               
               int cost=Integer.parseInt(rs.getString("cost"));
               int food=Integer.parseInt(rs.getString("foodincluded"));
               int ac=Integer.parseInt(rs.getString("acroom"));
               
               int person=Integer.parseInt(persons.getText());
               int days=Integer.parseInt(tfdays.getText());
               String acselected=cac.getSelectedItem();
               String foodselected =cfood.getSelectedItem(); 
               
               if(person*days>0)
               {
                   int total=0;
                   total+=acselected.equals("AC")? ac:0;
                   total+=foodselected.equals("Yes")?food:0;
                   total+=cost;
                   total=total*person*days;
                   labelprice.setText("Rs "+total);
                   
               }else
               {
                  JOptionPane.showMessageDialog(null, "Please Enter valid Number");
                   
               }
           }
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       }
       else if(ae.getSource()==bookpackage)
       {
           try{
               Conn c=new Conn();
               c.s.executeUpdate("insert into HotelBook values('"+lblusername.getText()+"','"+chotel.getSelectedItem()+"','"+persons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelprice.getText()+"')");
               JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
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
        new BookHotel("Parth");
    }
    
}
