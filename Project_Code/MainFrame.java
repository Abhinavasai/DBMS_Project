import java.sql.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

class MainFrame extends JFrame
{
    JButton j1,j2,j3,j4,j5,j6,j7;
    JButton d1,d2;
    //static String category;

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
  

    MainFrame()
    {
         JFrame j=new JFrame("Categories");
         
         ArrayList<Item> list=new ArrayList<Item>();
         try
         {

             Class.forName("com.mysql.jdbc.Driver");  
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Nikhil2202#");
             Statement stmt=con.createStatement(); 
             ResultSet rs=stmt.executeQuery("select * from product");  
            
              while(rs.next())
              {
                  String n=rs.getString(2);
                  int pr=rs.getInt(4);
                  String c=rs.getString(3);
                  int st=rs.getInt(5);
                  Item i1=new Item(n,pr,c,st);
                  list.add(i1);
              }

             con.close();
         } 

         catch(Exception e)
         {
             System.out.println("Error");
         }
         Container c = j.getContentPane();

         ImageIcon i0 = new ImageIcon("bg.jpg");
         JLabel bg = new JLabel("",i0,JLabel.CENTER);
         bg.setBounds(0,0,800,800);
         //bg.setLayout(new BorderLayout());
         c.add(bg);

          JLabel w = new JLabel("Welcome to Groceries On Go!!");
          w.setBounds(210,10,400,60);
          w.setFont(new Font("Serif", Font.ITALIC, 30));
          bg.add(w);
         
         
        ImageIcon i1 = new ImageIcon("staples.jpg");
        ImageIcon i2 = new ImageIcon("veg.jpeg");
        ImageIcon i3 = new ImageIcon("bfast.jpg");
        ImageIcon i4 = new ImageIcon("personalcare.jpg");
        ImageIcon i5 = new ImageIcon("household.jpg");
        ImageIcon i6 = new ImageIcon("snacks.jpg");
        ImageIcon i7 = new ImageIcon("beverages.jpg");
        
        JButton g = new JButton("Go To Cart");
        j1 = new JButton(i1);
        j2 = new JButton(i2);
        j3 = new JButton(i3);
        j4 = new JButton(i4);
        j5 = new JButton(i5);
        j6 = new JButton(i6);
        j7 = new JButton(i7);
  
        d1 = new JButton();
        d2 = new JButton();


          c.setLayout(null);  

          g.setBounds(680,0,100,60);
          j1.setBounds(200,270,195,160);
          j2.setBounds(200,90,400,160);
          j3.setBounds(405,270,195,160);
          j4.setBounds(200,630,195,160);
          j5.setBounds(405,630,195,160);
          j6.setBounds(200,450,195,160);
          j7.setBounds(405,450,195,160);  
            
          j1.setToolTipText("Staples");
          j2.setToolTipText("Vegetables & Fruits");
          j3.setToolTipText("Breakfast & Dairy");
          j4.setToolTipText("Personal Care");
          j5.setToolTipText("House Hold items");
          j6.setToolTipText("Snacks");  
          j7.setToolTipText("Beverages");

          
          g.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new CartFrame();         
          }
          });

          j1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Staples";
              String cat = "ST";
              
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
         }
         });
   
          j2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Vegetables&Fruits";
              String cat="VF";
              
              
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
           
         }
         });

         j3.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Breakfast&Dairy";
              String cat = "BF";
              
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
            
         }
         });

         j4.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="PersonalCare";
              String cat = "PC";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
             
         }
         });

         j5.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="HouseholdItems";
              String cat = "HH";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
             
         }
         });

        j6.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Snacks";
              String cat = "S";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
            
         }
         });

         j7.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              String category="Beverages";
              String cat = "BV";
             ArrayList<Item> catlist=catList(list,category);  //list of all elements in the category;
             int size=catlist.size();
             String data[][] =new String[size][4];
             int k=0;
             for(Item i:catlist)
             {
                 data[k][0]=i.name;
                 data[k][1]=i.price+"";
                 data[k][2]=i.stock+"";
                 data[k][3]="0";
                 k++;
             }
             new MyTable(data,cat);
             
         }
         });
        
      //  c.add(d1);
       bg.add(j2);
      //  c.add(d2);
        bg.add(j1);
        bg.add(j3);
        bg.add(j4);
       bg.add(j5);
       bg.add(j6);
        bg.add(j7);  
         bg.add(g); 
  
                j.setTitle("Welcome") ;
		j.setSize(800,835);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setResizable(false);
       
     }
        
               
    
}