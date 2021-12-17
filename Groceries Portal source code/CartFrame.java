import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.io.*;
import java.util.*;
import java.sql.*;

class CartFrame extends JFrame {

	//private JPanel contentPane;
	private JTable table;



	CartFrame(ArrayList<Item> cart,int cid) {
                JFrame f = new JFrame();
                ImageIcon g0=new ImageIcon("cart.jpg");
                JLabel bg=new JLabel("",g0,JLabel.CENTER);
                f.getContentPane().setLayout(null);
                bg.setBounds(0,0,1180,630);
                f.add(bg);
		f.setResizable(false);
                final int tot;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1180, 630);
		/*contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                f.add(contentPane);*/

		JButton b1 = new JButton("Back\r\n");
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		b1.setBounds(10, 11, 89, 34);
		bg.add(b1);

		JButton b2 = new JButton("Delete");
		b2.setBackground(Color.WHITE);
		b2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		b2.setBounds(10, 546, 160, 34);
		bg.add(b2);

		JButton b3 = new JButton("Checkout");
		b3.setBackground(Color.WHITE);
		b3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		b3.setBounds(1014, 546, 140, 34);
		bg.add(b3);

		JLabel l1 = new JLabel("Cart\r\n");
		l1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 25));
		l1.setBounds(543, 25, 75, 34);
		bg.add(l1);

        int size=cart.size();
        String data[][]=new String[size+1][4];
        int j=0;
        int total=0;
        for(Item i:cart)
        {
            data[j][0]=i.name;
            data[j][2]=i.stock+"";
            data[j][1]=i.price+"";
            total=total+(i.stock*i.price);
            data[j][3]=(i.stock*i.price)+"";
            j++;
        }
        data[j][0]="";
        data[j][1]="";
        data[j][2]="Total";
        data[j][3]=total+"";
        tot=total;

        String[] column = new String[] {"Name","Price", "Quantity", "Total Cost"};

        DefaultTableModel model = new DefaultTableModel(data, column);


		JTable table_1 = new JTable(model);
		table_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBackground(Color.WHITE);
		table_1.setFillsViewportHeight(true);
		//table_1.setModel(data,column);

    
        f.setVisible(true);



         b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             new MainFrame(cid,cart);
             f.dispose(); 
        }
        });



        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int row=table_1.getSelectedRow();
               if(row != -1) {
                  String name=table_1.getModel().getValueAt(row,0).toString();
                  for(Item i : cart)
                  {
                      if(i.name.equals(name))
                      {
                          cart.remove(i);
                          break;
                      }
                  }
                  // remove selected row from the model
                  model.removeRow(table_1.getSelectedRow());
                  JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                  new CartFrame(cart,cid);
                  f.dispose();
               }
            }
         });

        
        b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            try
            {
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
             PreparedStatement stmt=con.prepareStatement("INSERT INTO `transaction` (`customer_id`,`total`,`date_time`) values (?,?,?) "); 
             stmt.setInt(1,cid);
             stmt.setInt(2,tot);
             java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
             stmt.setTimestamp(3,date);
             stmt.executeUpdate();
             Statement st=con.createStatement(); 
             ResultSet sr=st.executeQuery("select * from transaction order by transaction_id desc limit 1");
             int tid=0;
             if(sr.next())
             {
                 tid=sr.getInt("transaction_id");
             }
             for(Item i:cart)
             {
                 PreparedStatement s=con.prepareStatement("INSERT INTO `transaction_details` (`transaction_id`,`product_id`,`quantity`,`total_cost`) values (?,?,?,?) ");
                 s.setInt(1,tid);
                 s.setInt(2,i.id);
                 s.setInt(3,i.stock);
                 s.setInt(4,i.stock*i.price);
                 s.executeUpdate();
             }
             con.close();
             } 

             catch(Exception ex)
             {
                 System.out.println("Error");
             }
             new LastFrame(cid,tot);
             f.dispose();
        }
        });

		JScrollPane jp = new JScrollPane(table_1);
		table_1.setBounds(221, 125, 751, 340);
		jp.setBounds(200, 100, 700, 340);
		bg.add(jp);

	}
}
