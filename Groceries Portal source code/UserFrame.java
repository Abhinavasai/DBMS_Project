import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;



public class UserFrame extends JFrame {

	private JPanel c1;

	
	public UserFrame(int cid) {


                String n="",address1="",address2="",city="",state="",pin="",phn="";
                ArrayList<String> l1=new ArrayList<String>();
                ArrayList<String> l2=new ArrayList<String>();
                ArrayList<String> l3=new ArrayList<String>();
          try{
                Class.forName("com.mysql.jdbc.Driver");
                
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                Statement st=conn.createStatement(); 
                ResultSet sr=st.executeQuery("select * from customer");
                
                while(sr.next())
                {
                    
                    int uid=sr.getInt("cus_id");
                    if(uid==cid)
                    {
                        n=n+sr.getString("name");
                        phn=phn+sr.getString("phno");
                        address1=address1+sr.getString("address1");
                        address2=address2+sr.getString("address2");
                        city=city+sr.getString("city");
                        state=state+sr.getString("state");
                        pin=pin+sr.getString("pincode");
                        break;
                    }
                }
                PreparedStatement s=conn.prepareStatement("select * from transaction where customer_id=?"); 
                s.setInt(1,cid);
                ResultSet r=s.executeQuery();
                while(r.next())
                {
                    l1.add(r.getString(1));   
                    l2.add(r.getString(3));
                    l3.add(r.getString(4));  
                }
                
            }   
            catch(Exception ex)
            {
                 System.out.println("Error");
            }
            String address=address1 + "\n" + address2 + "\n" + city +","+state +"\n" + pin + "." ;
                JFrame f=new JFrame();
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1000, 500);
		c1 = new JPanel();
                c1.setBackground(new Color(224, 255, 255));
		c1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(c1);
		c1.setLayout(null);
		f.add(c1);
		JLabel title = new JLabel("User Details");
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(22, 23, 201, 30);
		c1.add(title);
		
		JLabel lName = new JLabel("Name :-");
		lName.setFont(new Font("Calibri", Font.BOLD, 20));
		lName.setBounds(22, 90, 77, 22);
		c1.add(lName);
		
		JLabel name = new JLabel(n);
		name.setFont(new Font("Calibri", Font.PLAIN, 20));
		name.setBounds(146, 90, 314, 22);
		c1.add(name);
		
		JLabel lid = new JLabel("ID:-");
		lid.setFont(new Font("Calibri", Font.BOLD, 20));
		lid.setBounds(22, 139, 77, 22);
		c1.add(lid);
		
		JLabel ID = new JLabel(""+cid);
		ID.setFont(new Font("Calibri", Font.PLAIN, 20));
		ID.setBounds(148, 139, 160, 22);
		c1.add(ID);
		
		JLabel lPhno = new JLabel("Phone No :-");
		lPhno.setFont(new Font("Calibri", Font.BOLD, 20));
		lPhno.setBounds(22, 182, 107, 22);
		c1.add(lPhno);
		
		JLabel phno = new JLabel(phn);
		phno.setFont(new Font("Calibri", Font.PLAIN, 20));
		phno.setBounds(146, 182, 160, 22);
		c1.add(phno);
		
		JLabel lAdd = new JLabel("Address :-");
		lAdd.setFont(new Font("Calibri", Font.BOLD, 20));
		lAdd.setBounds(22, 234, 107, 22);
		c1.add(lAdd);
		
		JTextArea Address = new JTextArea(address);
                Address.setFont(new Font("Monospaced", Font.PLAIN, 18));
		Address.setBounds(146, 232, 277, 179);
                Address.setEditable(false);
		c1.add(Address);
                JScrollPane jp1 = new JScrollPane(Address);
        	jp1.setBounds(146, 232, 277, 179);
        	c1.add(jp1);

                String [][] data=new String[l1.size()][3];
                int i=0;
                for(String item:l1)
                {
                    data[i][0]=item;
                    i++;
                }
                i=0;
                for(String item:l2)
                {
                    data[i][2]=item;
                    i++;
                }
                i=0;
                for(String item:l3)
                {
                    data[i][1]=item.substring(0,10);
                    i++;
                }
                
		
		String[] column = new String[] {"Order_ID","DATE","Total Cost"};
		DefaultTableModel model = new DefaultTableModel(data, column);
		JTable table1 = new JTable(model);
		table1.setFont(new Font("Arial", Font.PLAIN, 15));
		table1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table1.setBounds(470, 62, 481, 351);
                table1.setFillsViewportHeight(true);
		c1.add(table1);
		JScrollPane jp = new JScrollPane(table1);
        jp.setBounds(470, 62, 481, 351);
        c1.add(jp);
        
        JLabel order = new JLabel("Order Details :-");
        order.setFont(new Font("Arial", Font.BOLD, 15));
        order.setBounds(470, 23, 116, 28);
        c1.add(order);
	f.setVisible(true);	


        WindowListener exitListener = new WindowAdapter() {

    	@Override
    	public void windowClosing(WindowEvent e) {	
             f.dispose();	
    	}
	};
	f.addWindowListener(exitListener);
	}
}
