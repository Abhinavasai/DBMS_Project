import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowEvent;


public class CartFrame
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


    CartFrame()
    {
        JButton j1=new JButton("Checkout"); 
        j1.setBounds(450,450,100,40);
        JButton j2=new JButton("Back");
        j2.setBounds(20,450,80,40);
        ArrayList<Item> cart=new ArrayList<Item>();
        try
        {
            File input=new File("cart.txt");
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
                cart.add(i1);
            }
        }    
        catch(FileNotFoundException e)
        {
            System.out.println("Error");
        }
  
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
        
        int size=cart.size();
        String data[][]=new String[size+1][4];
        int j=0;
        int total=0;
        for(Item i:cart)
        {
            data[j][0]=i.name;
            data[j][1]=i.stock+"";
            data[j][2]=i.price+"";
            total=total+(i.stock*i.price);
            data[j][3]=(i.stock*i.price)+"";
            j++;
        }
         data[j][0]="";
         data[j][1]="";
         data[j][2]="Total";
         data[j][3]=total+"";
        
        JFrame f = new JFrame("Cart");
                          
                          
        String coloumn[] = {"NAME", "QUANTITY", "PRICE","AMOUNT"};

         
             ImageIcon g0 = new ImageIcon("backgr.jpeg");
             JLabel  ba = new JLabel("",g0,JLabel.CENTER);
             ba.setBounds(0,0,400,400); 
             f.add(ba);
      

       // Dimension dim = new Dimension(20,100);
               
        JTable tb = new JTable(data,coloumn); 
      //  tb.setBounds(0,0,500,300);
        JScrollPane jp = new JScrollPane(tb);
        jp.setBounds(40,40,500,300);
         //jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
       //  tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

         JLabel  b = new JLabel("Please pay the amount "+total+" on delivery",JLabel.CENTER);
         b.setFont(new Font("Serif", Font.BOLD, 20));
         b.setBounds(50,200,400,400);
        
        
      
        j1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try{
            FileWriter fwOb = new FileWriter("cart.txt", false); 
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
            }
            catch(IOException ex)
            {
                System.out.println("Error");
            }

            for(Item i1 : cart)
            {
                for(Item i2 :list)
                {
                    if(i1.name.equals(i2.name))
                    {   
                        if(i2.stock-i1.stock<=10)
                        {
                            i2.stock=50;
                        }else{
                            i2.stock=i2.stock-i1.stock;
                            break;
                        }
                        
                    }
                }
            }

            updateFile(list);
            new FinalFrame();
            f.dispose();
        }
        });

        j2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            f.dispose();
        }
        });

        ba.add(j1);
        ba.add(j2);
        ba.add(jp);
        ba.add(b);
        f.setSize(600,600);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
        
        public void windowClosing(WindowEvent w)
        {
            f.dispose();
        }       
        });
        
       
     }
 
}