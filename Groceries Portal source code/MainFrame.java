import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


class MainFrame extends JFrame {

	JPanel contentPane;

        public static ArrayList<Item> catList(ArrayList<Item> list,String category)
    {
    ArrayList<Item> catlist=new ArrayList<Item>();
    for(Item i:list)
    {
        if(i.cat.equals(category))
        {
            catlist.add(i);
        }   
    }   
    return catlist;
    }

        String username="";
	MainFrame(int cid,ArrayList<Item> cart) {

        ArrayList<Item> list=new ArrayList<Item>();
        
        try
         {

             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
             Statement stmt=con.createStatement();
             ResultSet rs=stmt.executeQuery("select * from product");

              while(rs.next())
              {
                  int id=rs.getInt(1);
                  String n=rs.getString(2);
                  int pr=rs.getInt(4);
                  String c=rs.getString(3);
                  int st=rs.getInt(5);
                  Item i1=new Item(id,n,pr,c,st);
                  list.add(i1);
              }

              PreparedStatement s=con.prepareStatement("select * from login where id=? and role=?"); 
              s.setInt(1,cid);
              s.setString(2,"C");
              ResultSet r=s.executeQuery();
              while(r.next())
              {
                  username=r.getString(2);
              }
              
             con.close();
         }

         catch(Exception e)
         {
             System.out.println("Error");
         }
         JFrame j=new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 1300, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton j2 = new JButton("");
		j2.setIcon(new ImageIcon("Veg.jpg"));
		j2.setBounds(50, 125, 250, 150);
		contentPane.add(j2);

		JButton j1 = new JButton("");
		j1.setIcon(new ImageIcon("Staples.jpg"));
		j1.setBounds(360, 125, 250, 150);
		contentPane.add(j1);

		JButton j3 = new JButton("");
		j3.setIcon(new ImageIcon("Breakfast.jpg"));
		j3.setBounds(675, 125, 250, 150);
		contentPane.add(j3);

		JButton j6 = new JButton("");
		j6.setIcon(new ImageIcon("snacks.jpg"));
		j6.setBounds(986, 125, 250, 150);
		contentPane.add(j6);

		JButton j7 = new JButton("");
		j7.setIcon(new ImageIcon("Bev.jpg"));
		j7.setBounds(194, 365, 250, 150);
		contentPane.add(j7);

		JButton j4 = new JButton("");
		j4.setIcon(new ImageIcon("pc.jpg"));
		j4.setBounds(514, 365, 250, 150);
		contentPane.add(j4);

		JButton j5 = new JButton("");
		j5.setIcon(new ImageIcon("household.jpg"));
		j5.setBounds(838, 365, 250, 150);
		contentPane.add(j5);

		JButton b1 = new JButton("");
		b1.setToolTipText("Profile");
		b1.setIcon(new ImageIcon("User1.jpg"));
		b1.setBounds(1090, 29, 50, 46);
		contentPane.add(b1);

		JLabel l1 = new JLabel("Welcome "+username + " !!!");
		l1.setForeground(new Color(240, 255, 255));
		l1.setBackground(new Color(240, 240, 240));
		l1.setFont(new Font("Arial", Font.BOLD, 40));
		l1.setBounds(50, 29, 683, 54);
		contentPane.add(l1);

		JLabel l2 = new JLabel("Vegetables & Fruits");
		l2.setBackground(new Color(248, 248, 255));
		l2.setForeground(new Color(248, 248, 255));
		l2.setFont(new Font("Arial", Font.BOLD, 20));
		l2.setBounds(90, 287, 204, 27);
		contentPane.add(l2);

		JLabel l3 = new JLabel("Staples");
		l3.setForeground(new Color(255, 250, 250));
		l3.setFont(new Font("Arial", Font.BOLD, 20));
		l3.setBounds(446, 287, 77, 27);
		contentPane.add(l3);

		JLabel l4 = new JLabel("Breakfast & Dairy");
		l4.setForeground(new Color(255, 250, 250));
		l4.setFont(new Font("Arial", Font.BOLD, 20));
		l4.setBounds(720, 287, 189, 27);
		contentPane.add(l4);

		JLabel l5 = new JLabel("Snacks");
		l5.setForeground(new Color(255, 250, 250));
		l5.setFont(new Font("Arial", Font.BOLD, 20));
		l5.setBounds(1080, 287, 82, 27);
		contentPane.add(l5);

		JLabel l6 = new JLabel("Beverages");
		l6.setForeground(new Color(255, 250, 250));
		l6.setFont(new Font("Arial", Font.BOLD, 20));
		l6.setBounds(275, 526, 114, 27);
		contentPane.add(l6);

		JLabel l7 = new JLabel("Personal Care");
		l7.setForeground(new Color(255, 250, 250));
		l7.setFont(new Font("Arial", Font.BOLD, 20));
		l7.setBounds(571, 526, 176, 27);
		contentPane.add(l7);

		JLabel l8 = new JLabel("Household Products");
		l8.setForeground(new Color(255, 250, 250));
		l8.setFont(new Font("Arial", Font.BOLD, 20));
		l8.setBounds(873, 526, 215, 27);
		contentPane.add(l8);

		JButton g = new JButton("");
		g.setToolTipText("CART");
		g.setIcon(new ImageIcon("Cart1.jpg"));
		g.setBounds(1166, 29, 70, 50);
		contentPane.add(g);
                contentPane.setVisible(true);
                j.add(contentPane);
                j.setVisible(true);
                j.setResizable(false);


        g.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new CartFrame(cart,cid);
              j.dispose();
          }
          });

       b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new UserFrame(cid);
          }
          });

        j1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Staples";
              String cat = "ST";

             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });

         j2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Vegetables&Fruits";
              String cat="VF";


             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });


         j3.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Breakfast&Dairy";
              String cat = "BF";

             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });

         j4.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="PersonalCare";
              String cat = "PC";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });

         j5.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="HouseholdItems";
              String cat = "HH";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });

         j6.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Snacks";
              String cat = "S";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });

         j7.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Beverages";
              String cat = "BV";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][5];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 data[k][4]=i.id+"";
                 k++;
             }
             new TableFrame(data,cat,cart,cid);
             j.dispose();
         }
         });
	}

}
