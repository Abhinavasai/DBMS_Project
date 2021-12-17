import java.sql.*; 
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;

public class LoginFrame extends JFrame implements ActionListener{
	JTextField t1;
	JPasswordField t2;
        JButton b1,b2;
        JCheckBox showPass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginFrame() {
		ImageIcon g0 = new ImageIcon("logo.jpg");
                JLabel label=new JLabel(g0);
                label.setBounds(50, 89, 710, 513);
                getContentPane().add(label);
                getContentPane().setBackground(new Color(0, 206, 209));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1300, 650);
		getContentPane().setLayout(null);

                JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("lg.jpg"));
		lblNewLabel_5.setBounds(218, 50, 400, 61);
		getContentPane().add(lblNewLabel_5);

		JPanel p = new JPanel();
		p.setBackground(new Color(0, 206, 209));
		p.setBounds(50, 50, 710, 513);
		getContentPane().add(p);
		p.setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(153, 255, 255));
		p1.setBounds(808, 50, 424, 513);
		getContentPane().add(p1);
		p1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 40));
		lblNewLabel.setBounds(21, 44, 136, 67);
		p1.add(lblNewLabel);

		JLabel l1 = new JLabel("Username :");
		l1.setFont(new Font("Calibri", Font.BOLD, 25));
		l1.setBounds(21, 122, 136, 41);
		p1.add(l1);

		t1 = new JTextField();
		t1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t1.setBackground(Color.WHITE);
		t1.setBounds(21, 174, 373, 41);
		p1.add(t1);
		t1.setColumns(10);

		JLabel l2 = new JLabel("Password :");
		l2.setFont(new Font("Calibri", Font.BOLD, 25));
		l2.setBounds(21, 238, 136, 33);
		p1.add(l2);

		t2 = new JPasswordField();
		t2.setEchoChar('*');
		t2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		t2.setBackground(Color.WHITE);
		t2.setBounds(21, 282, 373, 41);
		p1.add(t2);

		showPass = new JCheckBox("Show Password");
		showPass.setBackground(new Color(224, 255, 255));
		showPass.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		showPass.setBounds(21, 339, 164, 41);
		p1.add(showPass);

		JLabel l3 = new JLabel("Not a member ?");
		l3.setFont(new Font("Arial", Font.PLAIN, 20));
		l3.setBounds(21, 459, 156, 24);
		p1.add(l3);

		b2 = new JButton("SIGNUP");
		b2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		b2.setBackground(Color.WHITE);
		b2.setBounds(187, 456, 136, 33);
		p1.add(b2);

		b1 = new JButton("Login");
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		b1.setBounds(295, 391, 99, 33);
		p1.add(b1);
                b1.addActionListener(this);
                b2.addActionListener(this);
                showPass.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
        {
          int count=0;
          if(e.getSource() == b1)
          {
              String usertxt,pass;
              usertxt = t1.getText();
              pass    = t2.getText();
              ArrayList<Item> cart=new ArrayList<Item>();
              try
              {

                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                 Statement stmt=con.createStatement();
                 ResultSet rs=stmt.executeQuery("select * from login");

                  while(rs.next())
                  {
                      String user=rs.getString(2);
                      String pwd=rs.getString(3);
                      if(usertxt.equals(user) && pass.equals(pwd))
                      {
                           String role=rs.getString(4);
                           if(role.equals("C"))
                           {
                               int cid=rs.getInt(1);
                               new MainFrame(cid,cart);
                               count++;
                  	       this.dispose();
                           }else if(role.equals("M"))
                           {
                               int eid=rs.getInt(1);
                               new EmployeeFrame(eid);
                               count++;
                  	       this.dispose();
                           }
                      }

                  }
                  if(count==0)
                  {
                      JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                  }

                 con.close();

         }

         catch(Exception ex)
         {
             System.out.println("Error");
         }

      }

          if(e.getSource() == b2)
          {
              new RegistrationFrame();
              this.dispose();
          }
          

          if (e.getSource() == showPass)
          {
            if (showPass.isSelected())
            {
                t2.setEchoChar((char) 0);
            }
            else
            {
                t2.setEchoChar('*');
            }
          }


      }
}