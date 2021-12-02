import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyTable 
{
    JButton j1,j2,j3;
    MyTable(String data[][],String cat)
    {
        
   
        JLabel bg= new JLabel("");
         ImageIcon g0;
         
        // f.setLayout(new BorderLayout());
        String type="";
        String bgforCat = cat;
        switch(bgforCat)
        {
          case "ST":
               g0 = new ImageIcon("ST.jpg");
               bg = new JLabel("",g0,JLabel.CENTER);
               type="Staples";
               break;
          case "VF":
                g0 = new ImageIcon("VF.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Vegetables & Fruits";
               break;
          case "BF":
                g0 = new ImageIcon("BF.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Breakfast & Dairy";
               break;
          case "PC":
                g0 = new ImageIcon("PC.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Personal Care";
               break;
          case "HH":
                g0 = new ImageIcon("HH.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Household Items";
               break;
          case "S":
                g0 = new ImageIcon("S.jpg");
               bg = new JLabel("",g0,JLabel.CENTER);
               type=type+"Snacks";
               break;
          case "BV":
               g0 = new ImageIcon("BV.jpeg");
               bg = new JLabel("",g0,JLabel.CENTER);
               type=type+"Beverages";
               break;           
         

        }

        JFrame f = new JFrame(type);
        bg.setBounds(0,0,400,400); 
        f.add(bg);
                                          
        String coloumn[] = {"NAME", "PRICE", "STOCK","QUANTITY"};

        JTable tb = new JTable(data,coloumn);
        tb.setBounds(40,100,200,200);
        JScrollPane jp = new JScrollPane(tb);
        jp.setBounds(10,10,350,200);

        j1=new JButton("Go to Cart");
        j1.setBounds(300,300,90,40);
  
        j2=new JButton("Add to Cart");
        j2.setBounds(150,300,100,40);

        j3=new JButton("Back");
        j3.setBounds(10,300,90,40);


        j1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             new CartFrame();
             f.dispose();
        }
        });
 
        j2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             int size=data.length;
             int arr[]=new int[size];
             for(int i=0;i<size;i++)
             {
                 Object ob=tb.getValueAt(i,3);
                 String st=String.valueOf(ob);
                 if(st.equals(""))
                 {
                     st="0";
                 }
                 arr[i]=Integer.parseInt(st);
             }
             ArrayList<Item> cart=new ArrayList<Item>();
             for(int i=0;i<size;i++)
             {
                 if(arr[i]!=0)
                 {
                     String name=data[i][0];
                     int price=Integer.parseInt(data[i][1]);
                     String cat="";
                     int stock=arr[i];
                     Item it=new Item(name,price,cat,stock);
                     cart.add(it);
                 }
             }
             Item.printCart(cart);
             for(int i=0;i<size;i++)
             {
                 tb.setValueAt((Object)"0",i,3);
             }
        }
        });

        j3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             f.dispose();
        }
        });

        bg.add(j1);
        bg.add(j2);
        bg.add(j3);
        bg.add(jp);
        f.setSize(400,400);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
        
        public void windowClosing(WindowEvent w)
        {
        f.dispose();
        }       
        });
        
       
     }

     
}