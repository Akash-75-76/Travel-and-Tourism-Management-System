package ttm;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener
{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;
    JRadioButton male,female;
    JButton add,back;
    

    AddCustomer(String username)
   {
      
     setBounds(450,200,850,550);
     setLayout(null);

     getContentPane().setBackground(Color.white);

     JLabel lblusername=new JLabel ("Username");
     lblusername.setBounds(30,50,150,25);
     add(lblusername);

     labelusername=new JLabel ();
     labelusername.setBounds(220,50,150,25);
     add(labelusername);
     
     JLabel IbIid=new JLabel ("ID");
     IbIid.setBounds(30,90,150,25);
     add(IbIid);
     
    comboid=new JComboBox(new String[] {"Passport","Aadhar","Pan Card","Ration Card"});
    comboid.setBounds(220,90,150,25);
    comboid.setBackground(Color.white);
    add(comboid);

    JLabel Lblnumber =new JLabel("Number");
    Lblnumber.setBounds(30,130,150,25);
    add(Lblnumber);

    tfnumber=new JTextField();
    tfnumber.setBounds(220,130,150,25);
    add(tfnumber);

    JLabel lblname=new JLabel ("Name");
    lblname.setBounds(30,170,150,25);
    add(lblname);

    labelname=new JLabel ();
    labelname.setBounds(220,170,150,25);
    add(labelname);
    
    
    JLabel lblgender=new JLabel ("Gender");
    lblgender.setBounds(30,210,150,25);
    add(lblgender);
    male=new JRadioButton("Male");
    male.setBounds(220,210,70,25);
    male.setBackground(Color.white);
    add(male);

    female=new JRadioButton("Female");
    female.setBounds(300,210,70,25);
    female.setBackground(Color.white);
    add(female);

    ButtonGroup bg=new ButtonGroup();
    bg.add(male);
    bg.add(female);

    JLabel Lblcountry =new JLabel("Country");
    Lblcountry.setBounds(30,250,150,25);
    add(Lblcountry);

    tfcountry=new JTextField();
    tfcountry.setBounds(220,250,150,25);
    add(tfcountry);

    JLabel Lbladdress =new JLabel("Address");
    Lbladdress.setBounds(30,290,150,25);
    add(Lbladdress);

    tfaddress=new JTextField();
    tfaddress.setBounds(220,290,150,25);
    add(tfaddress);

    JLabel Lblphone =new JLabel("Phone");
    Lblphone.setBounds(30,330,150,25);
    add(Lblphone);

    tfphone=new JTextField();
    tfphone.setBounds(220,330,150,25);
    add(tfphone);

    JLabel Lblemail =new JLabel("Email");
    Lblemail.setBounds(30,370,150,25);
    add(Lblemail);

    tfemail=new JTextField();
    tfemail.setBounds(220,370,150,25);
    add(tfemail);

    add=new JButton("Add");
    add.setBackground(Color.black);
    add.setForeground(Color.white);
    add.setBounds(70,430,100,25);
    add.addActionListener(this);
    add(add);

    back=new JButton("back");
    back.setBackground(Color.black);
    back.setForeground(Color.white);
    back.setBounds(220,430,100,25);
    back.addActionListener(this);
    add(back);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
    Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(400,40,450,420);
    add(image);

    try{
        Conn c =new Conn();
       ResultSet rs= c.s.executeQuery("select* from Account where username='"+username+"'");
       while(rs.next()){
        labelusername.setText(rs.getString("username"));
        labelname.setText(rs.getString("name"));
       }
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add)
        {
          String username=labelusername.getText();
          String id=(String)comboid.getSelectedItem();
          String number=tfnumber.getText();
          String name=labelname.getText();
          String gender=null;
          if(male.isSelected())
          {
            gender="Male";
          }
          else{
            gender="Female";
          }
        String country =tfcountry.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();

        try{
            Conn c =new Conn();
            String query ="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Succssfully!!");
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
    public static void main (String args[]){
        new AddCustomer("");
    }
}