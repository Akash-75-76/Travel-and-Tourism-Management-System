package ttm;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable
{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
            for(int i=1;i<=101;i++)
            {
                int max=bar.getMaximum();
                int value=bar.getValue();
                if(value < max)
                {
                    bar.setValue(bar.getValue()+1);;
              
                }
                else 
                {
                    setVisible(false);
                }
                Thread.sleep(50);
            }
            new DashBoard(username);
            
        }catch(Exception e)
        {
           e.printStackTrace();
        }
        
    }
    Loading(String username)
    {
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel and Tourism Application");
        text.setForeground(Color.BLUE);
        text.setBounds(50,20,600,40);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
         bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading=new JLabel("Loading Plz wait");
        loading.setForeground(Color.RED);
        loading.setBounds(230,140,150,30);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);
        
        JLabel user=new JLabel("Welcome "+username);
        user.setForeground(Color.RED);
        user.setBounds(20,310,400,40);
        user.setFont(new Font("Raleway",Font.BOLD,16));
        add(user);
        t.start();
        
        setVisible(true);
        
    }
    


    public static void main(String args[])
    {
        new Loading("");
    }
    
}
