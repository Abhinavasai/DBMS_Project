import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

public class TableFrame
{
    JTextField t1;
	JTextField t2;


    TableFrame(String data[][],String cat,ArrayList<Item> cart,int cid)
    {


        JFrame f = new JFrame();
        JLabel bg= new JLabel("");
        ImageIcon g0=new ImageIcon();
        String type="";
        String bgforCat = cat;
        switch(bgforCat)
        {
          case "ST":
               g0 = new ImageIcon("St.jpg");
               bg = new JLabel("",g0,JLabel.CENTER);
               type=type+"Staples";
               break;
          case "VF":
                g0 = new ImageIcon("v&f.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Vegetables & Fruits";
               break;
          case "BF":
                g0 = new ImageIcon("Bf.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Breakfast & Dairy";
               break;
          case "PC":
                g0 = new ImageIcon("Pr.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Personal Care";
               break;
          case "HH":
                g0 = new ImageIcon("Hh.jpg");
                bg = new JLabel("",g0,JLabel.CENTER);
                type=type+"Household Items";
               break;
          case "S":
                g0 = new ImageIcon("Sn.jpg");
               bg = new JLabel("",g0,JLabel.CENTER);
               type=type+"Snacks";
               break;
          case "BV":
               g0 = new ImageIcon("Bv.jpg");
               bg = new JLabel("",g0,JLabel.CENTER);
               type=type+"Beverages";
               break;


        }

        bg = new JLabel("",g0,JLabel.CENTER);

        f.getContentPane().setLayout(null);
        bg.setBounds(0,0,980,570);
        f.add(bg);

        String coloumn[] = {"NAME", "PRICE", "STOCK"};//,"QUANTITY"};

        JTable tb = new JTable(data,coloumn);
        tb.setBackground(new Color(240, 255, 255));
        tb.setFillsViewportHeight(true);
        tb.setFont(new Font("Calibri", Font.PLAIN, 15));
        tb.setBounds(40,100,200,200);
        JScrollPane jp = new JScrollPane(tb);

        jp.setBounds(52,82,528,372);
        bg.add(jp);

        Panel panel = new Panel();
        panel.setBackground(new Color(240, 255, 255));
        panel.setBounds(632, 82, 295, 372);
        bg.add(panel);
        panel.setLayout(null);

        Choice c1=new Choice();
        c1.add("");
        for(int i=0;i<data.length;i++)
        {
            c1.add(data[i][0]);
        }
        c1.setBounds(174,95,96,18);
        panel.add(c1);

        JLabel l1 = new JLabel("Select Product");
        l1.setFont(new Font("Arial", Font.BOLD, 25));
        l1.setBounds(40, 22, 230, 27);
        panel.add(l1);

        JLabel l2 = new JLabel("Item :");
        l2.setFont(new Font("Calibri", Font.BOLD, 22));
        l2.setBounds(40, 95, 59, 27);
        panel.add(l2);

        JLabel l3 = new JLabel("Quantity :");
        l3.setFont(new Font("Calibri", Font.BOLD, 22));
        l3.setBounds(40, 151, 107, 27);
        panel.add(l3);

        t1 = new JTextField();           //Quantity
        t1.setBounds(174, 153, 96, 20);
        panel.add(t1);
        t1.setColumns(10);

        JButton b1 = new JButton("Add");
        b1.setFont(new Font("Tahoma", Font.BOLD, 15));
        b1.setBounds(102, 228, 96, 36);
        panel.add(b1);

        /*t2 = new JTextField();
        t2.setBounds(174, 190, 96, 20);
        panel.add(t2);
        t2.setColumns(10);*/

        JButton b3 = new JButton("");
        b3.setIcon(new ImageIcon("Cart1.jpg"));
        b3.setToolTipText("CART");
        b3.setBounds(838, 468, 70, 50);
        bg.add(b3);

        JButton b2 = new JButton("Back");
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setBounds(52, 465, 111, 53);
        bg.add(b2);

        JLabel l5 = new JLabel(type);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Arial", Font.BOLD, 30));
        l5.setBounds(52, 21, 344, 37);
        bg.add(l5);
        f.setBounds(100,100,980,570);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){

        public void windowClosing(WindowEvent w)
        {
        f.dispose();
        }
        });

   

        b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int size=data.length;
            String name=c1.getSelectedItem();
            String cat="";
            int quantity=Integer.parseInt(t1.getText());
            if(quantity>0)
       {
            int id=-1,price=0;
            for(int i=0;i<size;i++)
            {
                if(data[i][0].equals(name))
                {
                     id=Integer.parseInt(data[i][4]);
                     price=Integer.parseInt(data[i][1]);
                     break;
                }
            }
            Item it=new Item(id,name,price,cat,quantity);
            cart.add(it);
       }
            c1.select("");
            t1.setText("");
        }
        });

        b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             new MainFrame(cid,cart);
             f.dispose();
        }
        });

        b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             new CartFrame(cart,cid);
             f.dispose();
        }
        });


     }
}
