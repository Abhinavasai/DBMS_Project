import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class EmployeeFrame extends JFrame {

	//private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t4;
	private JTextField t5;




	public EmployeeFrame(int eid) {
        String u="";
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
              s.setInt(1,eid);
              s.setString(2,"M");
              ResultSet r=s.executeQuery();
              while(r.next())
              {
                  u=r.getString(2);
              }

                 con.close();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }



	    JFrame j=new JFrame("Employee Page");
            ImageIcon g0=new ImageIcon("emp.jpg");
            JLabel bg=new JLabel("",g0,JLabel.CENTER);
                j.getContentPane().setLayout(null);
                bg.setBounds(0,0,1300,650);
                j.add(bg);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 1320, 650);
		/*contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		j.add(contentPane);*/

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(100, 84, 300, 474);
		bg.add(panel);
		panel.setLayout(null);

		//Code for adding a product

		JLabel l1 = new JLabel("Add Product :");
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		l1.setBounds(10, 11, 125, 34);
		panel.add(l1);

		JLabel s1 = new JLabel("Product Name :-");
		s1.setFont(new Font("Arial", Font.BOLD, 15));
		s1.setBounds(10, 56, 125, 27);
		panel.add(s1);

		Choice t3=new Choice();
        t3.setBounds(10,288,218,18);
        t3.add("");
        t3.add("Staples");
        t3.add("Vegetables&Fruits");
        t3.add("Breakfast&Dairy");
        t3.add("PersonalCare");
        t3.add("HouseholdItems");
        t3.add("Snacks");
        t3.add("Beverages");
        panel.add(t3);

		t1 = new JTextField();
		t1.setBounds(10, 95, 218, 34);
		panel.add(t1);
		//t1.setColumns(10);

		JLabel s2 = new JLabel("Price :-");
		s2.setFont(new Font("Arial", Font.BOLD, 15));
		s2.setBounds(10, 148, 125, 27);
		panel.add(s2);

		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(10, 186, 218, 34);
		panel.add(t2);

		JLabel s3 = new JLabel("Category :-");
		s3.setFont(new Font("Arial", Font.BOLD, 15));
		s3.setBounds(10, 245, 125, 27);
		panel.add(s3);

		JLabel s4 = new JLabel("Stock :-");
		s4.setFont(new Font("Arial", Font.BOLD, 15));
		s4.setBounds(10, 333, 125, 27);
		panel.add(s4);

		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(10, 371, 218, 34);
		panel.add(t4);

		JButton addP = new JButton("Add");
		addP.setFont(new Font("Tahoma", Font.BOLD, 13));
		addP.setBounds(10, 429, 113, 34);
		panel.add(addP);

		addP.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name=t1.getText();
            int price=Integer.parseInt(t2.getText());
            String category=t3.getSelectedItem();
            int stock=Integer.parseInt(t4.getText());
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                PreparedStatement stmt=conn.prepareStatement("INSERT INTO `product` (`name`,`category`,`price`,`stock`) values(?,?,?,?)");
                stmt.setString(1,name);
                stmt.setString(2,category);
                stmt.setInt(3,price);
                stmt.setInt(4,stock);
                stmt.executeUpdate();
            }
            catch(Exception ex)
            {
                 System.out.println("Error");
            }
            new EmployeeFrame(eid);
            j.dispose();
        }
        });

        //Code for removing a product

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(499, 84, 300, 474);
		bg.add(panel_1);
		panel_1.setLayout(null);

		JLabel l2 = new JLabel("Remove Product :");
		l2.setFont(new Font("Calibri", Font.BOLD, 20));
		l2.setBounds(10, 11, 172, 34);
		panel_1.add(l2);

		JLabel r1 = new JLabel("Category :-");
		r1.setFont(new Font("Arial", Font.BOLD, 15));
		r1.setBounds(10, 56, 125, 27);
		panel_1.add(r1);

		JLabel r2 = new JLabel("Product Name :-");
		r2.setFont(new Font("Arial", Font.BOLD, 15));
		r2.setBounds(10, 205, 125, 27);
		panel_1.add(r2);

		Choice c2 = new Choice();
		c2.setBounds(10, 100, 227, 45);
        c2.add("");
        c2.add("Staples");
        c2.add("Vegetables&Fruits");
        c2.add("Breakfast&Dairy");
        c2.add("PersonalCare");
        c2.add("HouseholdItems");
        c2.add("Snacks");
        c2.add("Beverages");
		panel_1.add(c2);

		JButton b1 = new JButton("Select Category");
		b1.setFont(new Font("Tahoma", Font.BOLD, 13));
		b1.setBounds(10, 145, 172, 34);
		panel_1.add(b1);

		JButton b2 = new JButton("Refresh");
		b2.setFont(new Font("Tahoma", Font.BOLD, 13));
		b2.setBounds(178, 289, 112, 34);
		panel_1.add(b2);

		b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new EmployeeFrame(eid);
            j.dispose();

        }
        });





		Choice c3 = new Choice();
		c3.setBounds(10, 250, 227, 18);
		c3.add("");
		panel_1.add(c3);
		b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String cat=c2.getSelectedItem();
                    for(Item i1:list)
                    {
                	if(i1.cat.equals(cat))
                	{
                    	String st=i1.name;
                    	c3.add(st);
                	}
            	    }
        	}
        	});

		JButton remove = new JButton("Remove");
		remove.setFont(new Font("Tahoma", Font.BOLD, 13));
		remove.setBounds(10, 289, 139, 34);
		panel_1.add(remove);


		remove.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String n=c3.getSelectedItem();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                PreparedStatement stmt=conn.prepareStatement("DELETE FROM `product` WHERE name=?");
                stmt.setString(1,n);
                stmt.executeUpdate();
            }
            catch(Exception ex)
            {
                 System.out.println("Error");
            }
            new EmployeeFrame(eid);
            j.dispose();
        }
        });


        //Code for changing Price


		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBounds(898, 84, 300, 474);
		bg.add(panel_2);
		panel_2.setLayout(null);

		JLabel l3 = new JLabel("Change Price :");
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		l3.setBounds(10, 11, 172, 34);
		panel_2.add(l3);

		JLabel r3 = new JLabel("Category :-");
		r3.setFont(new Font("Arial", Font.BOLD, 15));
		r3.setBounds(10, 56, 125, 27);
		panel_2.add(r3);

		JButton b3 = new JButton("Select Category");
		b3.setFont(new Font("Tahoma", Font.BOLD, 13));
		b3.setBounds(10, 145, 172, 34);
		panel_2.add(b3);

		Choice c4 = new Choice();
		c4.setBounds(10, 105, 227, 18);
		c4.add("");
        c4.add("Staples");
        c4.add("Vegetables&Fruits");
        c4.add("Breakfast&Dairy");
        c4.add("PersonalCare");
        c4.add("HouseholdItems");
        c4.add("Snacks");
        c4.add("Beverages");
		panel_2.add(c4);

		JLabel r4 = new JLabel("Product Name :-");
		r4.setFont(new Font("Arial", Font.BOLD, 15));
		r4.setBounds(10, 205, 125, 27);
		panel_2.add(r4);

		Choice c5 = new Choice();
		c5.setBounds(10, 250, 227, 18);
		c5.add("");
                panel_2.add(c5);
		b3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String cat=c4.getSelectedItem();
            for(Item i1:list)
            {
                if(i1.cat.equals(cat))
                {
                    String st=i1.name;
                    c5.add(st);
                }
            }  
        }
        });

		JButton b5 = new JButton("Select Product");
		b5.setFont(new Font("Tahoma", Font.BOLD, 13));
		b5.setBounds(10, 285, 139, 34);
		panel_2.add(b5);

		JLabel r5 = new JLabel("New Price :-");
		r5.setFont(new Font("Arial", Font.BOLD, 15));
		r5.setBounds(10, 342, 125, 27);
		panel_2.add(r5);

		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(10, 380, 218, 34);
		panel_2.add(t5);

		
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
            t5.setText(""+price);
        }
        });



		JButton change = new JButton("Change");
		change.setFont(new Font("Tahoma", Font.BOLD, 13));
		change.setBounds(10, 429, 113, 34);
		panel_2.add(change);

		change.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name=c5.getSelectedItem();
            int nprice=Integer.parseInt(t5.getText());
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                PreparedStatement stmt=conn.prepareStatement("UPDATE `product` SET `price` = ? WHERE `name` = ?");
                stmt.setInt(1,nprice);
                stmt.setString(2,name);
                stmt.executeUpdate();
            }
            catch(Exception ex)
            {
                 System.out.println("Error");
            }
            new EmployeeFrame(eid);
            j.dispose();
        }
        });

		JButton b4 = new JButton("Refresh");
		b4.setFont(new Font("Tahoma", Font.BOLD, 13));
		b4.setBounds(178, 285, 112, 34);
		panel_2.add(b4);

		b4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new EmployeeFrame(eid);
            j.dispose();

        }
        });

		JLabel l4 = new JLabel("Welcome "+ u + "!!!");
		l4.setForeground(Color.BLACK);
		l4.setBackground(new Color(240, 255, 255));
		l4.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		l4.setBounds(100, 11, 650, 48);
		bg.add(l4);

		JButton logout = new JButton("Logout");
		logout.setFont(new Font("Arial", Font.BOLD, 15));
		logout.setBounds(1095, 11, 102, 48);
		bg.add(logout);

                logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            		LoginFrame frame = new LoginFrame();
			frame.setVisible(true);
                        j.dispose();
	        }
        	});

                JButton sales = new JButton("View Sales");
		sales.setFont(new Font("Arial", Font.BOLD, 15));
		sales.setBounds(898, 11, 135, 48);
		bg.add(sales);

                

                sales.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            		SwingUtilities.invokeLater(() -> {
      			TimeSeriesChartExample example = new TimeSeriesChartExample("Time Series Chart");
      			example.setSize(800, 400);
      			example.setLocationRelativeTo(null);
     			example.setVisible(true);
      			//example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        WindowListener exitListener = new WindowAdapter() {

    		@Override
    		public void windowClosing(WindowEvent e) {	
            	example.dispose();	
             	//System.exit(0);
    		}
		};
                        example.addWindowListener(exitListener);
   		        });
	        }
        	});

		j.setVisible(true);
	}
}
