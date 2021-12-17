import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.TextArea;
import java.sql.*;

public class LastFrame extends JFrame {

	private JPanel contentPane;

	public LastFrame(int cid,int total) {
         
          String name="",address1="",address2="",city="",state="",pin="",phno="";
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
                        name=name+sr.getString("name");
                        phno=phno+sr.getString("phno");
                        address1=address1+sr.getString("address1");
                        address2=address2+sr.getString("address2");
                        city=city+sr.getString("city");
                        state=state+sr.getString("state");
                        pin=pin+sr.getString("pincode");
                        break;
                    }
                }
                }
            catch(Exception ex)
            {
                 System.out.println("Error");
            }

                String details="Name :-" + name + "\n\n\nTotal :- " + total + "\n\n\nAddress :-\n" + address1 + "\n" + address2 + "\n" + city +","+state +"\n" + pin + "\n\n Phone :- " + phno  ;

                JFrame f=new JFrame();
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                f.add(contentPane);

		JLabel l2 = new JLabel("Order Details");
		l2.setBackground(Color.WHITE);
		l2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		l2.setBounds(10, 0, 651, 145);
		contentPane.add(l2);

		Panel panel = new Panel();
		panel.setBounds(39, 133, 507, 386);
		contentPane.add(panel);
		panel.setLayout(null);

		TextArea t1 = new TextArea(details);
                t1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 15));
		t1.setBounds(50, 36, 407, 303);
                t1.setEditable(false);
                
		panel.add(t1);

		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("checkout.jpg"));
		l1.setBounds(628, 28, 500, 500);
		contentPane.add(l1);
                f.setVisible(true);



               WindowListener exitListener = new WindowAdapter() {

    	@Override
    	public void windowClosing(WindowEvent e) {
             LoginFrame lf=new LoginFrame();
             lf.setVisible(true);	
             f.dispose();	
             //System.exit(0);
    	}
	};
	f.addWindowListener(exitListener);
	}
}
