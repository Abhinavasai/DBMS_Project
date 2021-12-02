import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class EmployeeFrame
{

public static void updateFile(ArrayList<Item> list)
{
    try
    {
        FileWriter fwOb = new FileWriter("input.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
    catch(IOException ex)
    {
        System.out.println("Error");
    }

    try
    {
        File input=new File("input.txt");
        FileOutputStream fos = new FileOutputStream(input);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for(Item i:list)
        {
            String line=i.name + " " + i.price + " " + i.cat + " " + i.stock;
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }catch(IOException ex)
    {
        System.out.println("Error");
    }
        
}

EmployeeFrame()
{
    JFrame j=new JFrame("Employee Page");

    ArrayList<Item> list=new ArrayList<Item>();
    try
    {
        File input=new File("input.txt");
        Scanner sc=new Scanner(input);
        while(sc.hasNextLine())
        {
            String line=sc.nextLine();
            String elements[]=line.split("\\s");
            String n=elements[0];
            int pr=Integer.parseInt(elements[1]);
            String c=elements[2];
            int st=Integer.parseInt(elements[3]);
            Item i1=new Item(n,pr,c,st);
            list.add(i1);
        }
    }       
    catch(FileNotFoundException ex)
    {
        System.out.println("Error");
    }



    Container c=j.getContentPane();
    c.setLayout(null);
    JLabel l0=new JLabel("Welcome Employee");
    Button b0=new Button("EXIT");
    b0.setBounds(420,20,100,40);
    b0.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        j.dispose();
        
    }  
    }); 
    JLabel l1=new JLabel("To ADD a Product :");
    JLabel l2=new JLabel("To REMOVE a Product :");
    JLabel l3=new JLabel("To CHANGE PRICE of a Product :");
    JLabel s1=new JLabel("Product Name :-");
    JTextField t1,t2,t4;
    t1=new JTextField();
    JLabel s2=new JLabel("Price :-");
    t2=new JTextField();
    JLabel s3=new JLabel("Category :-");
    Choice t3=new Choice();
    t3.add("");
    t3.add("Staples");
    t3.add("Vegetables&Fruits");
    t3.add("Breakfast&Dairy");
    t3.add("PersonalCare");
    t3.add("HouseholdItems");
    t3.add("Snacks");
    t3.add("Beverages");
    JLabel s4=new JLabel("Stock :-");
    t4=new JTextField();
    l0.setBounds(20,20,200,40);
    l0.setFont(new Font("Serif", Font.BOLD, 20));
    l1.setBounds(20,70,300,40);
    s1.setBounds(30,100,100,30);
    t1.setBounds(150,105,100,20);
    s2.setBounds(30,130,100,30);
    t2.setBounds(150,135,100,20);
    s3.setBounds(30,160,100,30);
    t3.setBounds(150,165,100,20);
    s4.setBounds(30,190,100,30);      
    t4.setBounds(150,195,100,20);
 
                                               //Code for removing product 
 
    JLabel r1=new JLabel("Category :-");
    JLabel r2=new JLabel("Product Name :-");
    Button b1=new Button("Select category");
    b1.setBounds(300,290,100,20);
    Button b2=new Button("Refresh");
    b2.setBounds(450,290,100,20);
    Choice c2=new Choice();
    c2.add("");
    c2.add("Staples");
    c2.add("Vegetables&Fruits");
    c2.add("Breakfast&Dairy");
    c2.add("PersonalCare");
    c2.add("HouseholdItems");
    c2.add("Snacks");
    c2.add("Beverages");
    b2.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        new EmployeeFrame();
        j.dispose();
        
    }  
    }); 
    Choice c3=new Choice();
    b1.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        c3.setBounds(150,320,100,20);
        c3.add("");      
        String cat=c2.getSelectedItem();
        for(Item i1:list)
        {
            if(i1.cat.equals(cat))
            {
                String st=i1.name;
                c3.add(st);
            }
        }
        c.add(c3);
    }  
    });           
    
    l2.setBounds(20,240,300,40);
    r1.setBounds(30,290,100,30);
    c2.setBounds(150,290,100,20);
    r2.setBounds(30,320,100,30);
    
                                               //Code for changing Price
    JLabel r3=new JLabel("Category :-");
    JLabel r4=new JLabel("Product Name :-");
    JLabel r5=new JLabel("New Price :-");
    JTextField t5=new JTextField();
    Button b3=new Button("Select category");
    b3.setBounds(300,420,100,20);
    Button b4=new Button("Refresh");
    b4.setBounds(450,420,100,20);
    Button b5=new Button("Select product");
    b5.setBounds(300,450,100,20); 
    Choice c4=new Choice();
    c4.add("");
    c4.add("Staples");
    c4.add("Vegetables&Fruits");
    c4.add("Breakfast&Dairy");
    c4.add("PersonalCare");
    c4.add("HouseholdItems");
    c4.add("Snacks");
    c4.add("Beverages");
    b4.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        new EmployeeFrame();
        j.dispose();
        
    }  
    }); 
    Choice c5=new Choice();
    b3.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) {   
        c5.setBounds(150,450,100,20);
        c5.add("");      
        String cat=c4.getSelectedItem();
        for(Item i1:list)
        {
            if(i1.cat.equals(cat))
            {
                String st=i1.name;
                c5.add(st);
            }
        }
        c.add(c5);
    }  
    });     
    JLabel pric=new JLabel();
    pric.setBounds(300,480,200,20);   
    b5.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        String nam=c5.getSelectedItem();
        int price=0;
        for(Item i1:list)
        {
            if(i1.name.equals(nam))
            {
                price=i1.price;
                break;
            }
        }
        String pri="The old price is " + price;
        pric.setText(pri);
    }   
    }); 

    
    c.add(pric);

    l3.setBounds(20,370,300,40);
    r3.setBounds(30,420,100,30);
    c4.setBounds(150,420,100,20);
    r4.setBounds(30,450,100,30);       
    r5.setBounds(30,480,100,30);
    t5.setBounds(150,485,100,20);

    Button addP=new Button("ADD");
    addP.setBounds(300,200,60,30);
    Button remove=new Button("REMOVE");
    remove.setBounds(300,330,60,30);
    Button change=new Button("CHANGE");
    change.setBounds(300,510,60,30);

    addP.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        String name=t1.getText();
        int price=Integer.parseInt(t2.getText());
        String category=t3.getSelectedItem();
        int stock=Integer.parseInt(t4.getText());
        Employee.addProduct(list,name,price,category,stock);
        updateFile(list);
        new EmployeeFrame();
        j.dispose();
    }  
    }); 

    remove.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        String name=c3.getSelectedItem();
        Employee.removeProduct(list,name);
        updateFile(list);
        new EmployeeFrame();
        j.dispose();
    }  
    }); 

    change.addActionListener(new ActionListener() {  
    public void actionPerformed(ActionEvent e) { 
        String name=c5.getSelectedItem();
        int nprice=Integer.parseInt(t5.getText());
        Employee.changePrice(list,name,nprice);
        updateFile(list);
        new EmployeeFrame();
        j.dispose();
    }  
    }); 
    
    c.add(b0);
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.add(b4);
    c.add(b5);
    c.add(addP);
    c.add(remove);
    c.add(change);
    c.add(l0);
    c.add(l1);
    c.add(l2);
    c.add(l3);
    c.add(s1);
    c.add(s2);
    c.add(s3);
    c.add(s4);
    c.add(t1);
    c.add(t2);
    c.add(t3);
    c.add(t4);
    c.add(t5);
    c.add(r1);
    c.add(r2);
    c.add(r3);
    c.add(r4);
    c.add(r5);
    c.add(c2);
    c.add(c4);
    
    j.setSize(600,600);
    j.setVisible(true);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}


}