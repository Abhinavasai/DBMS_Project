import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.text.SimpleDateFormat;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

class RegistrationFrame extends JFrame {

	private JPanel contentPane;
	
	RegistrationFrame() {
                JFrame j=new JFrame();
		j.setResizable(false);
		j.setBackground(new Color(240, 240, 240));
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(100, 100, 1190, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                j.add(contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 594, 561);
		panel.setBackground(new Color(51, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel l1 = new JLabel("User Info");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Nirmala UI", Font.PLAIN, 22));
		l1.setBounds(243, 11, 97, 33);
		panel.add(l1);

		JLabel lName = new JLabel("Name");
		lName.setBackground(Color.WHITE);
		lName.setForeground(Color.WHITE);
		lName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lName.setBounds(10, 80, 76, 33);
		panel.add(lName);

		JTextPane tName = new JTextPane();
		tName.setBackground(new Color(224, 255, 255));
		tName.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tName.setBounds(132, 80, 243, 32);
		panel.add(tName);

		JLabel lDob = new JLabel("Date of Birth\r\n");
		lDob.setForeground(Color.WHITE);
		lDob.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lDob.setBounds(10, 163, 112, 33);
		panel.add(lDob);

		JDateChooser date = new JDateChooser();
		date.setBounds(149, 163, 160, 33);
		panel.add(date);


		JLabel lAddress1 = new JLabel("Address Line 1");
		lAddress1.setForeground(Color.WHITE);
		lAddress1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lAddress1.setBounds(10, 240, 135, 33);
		panel.add(lAddress1);

		JTextPane tAdd1 = new JTextPane();
		tAdd1.setBackground(new Color(224, 255, 255));
		tAdd1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tAdd1.setBounds(164, 240, 420, 33);
		panel.add(tAdd1);

		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		exit.setBounds(10, 517, 97, 33);
		panel.add(exit);

		JLabel lCity = new JLabel("City");
		lCity.setForeground(Color.WHITE);
		lCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lCity.setBounds(10, 366, 57, 33);
		panel.add(lCity);

		JTextPane tCity = new JTextPane();
		tCity.setBackground(new Color(224, 255, 255));
		tCity.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tCity.setBounds(132, 366, 177, 33);
		panel.add(tCity);

		JLabel lPost = new JLabel("Postal code");
		lPost.setForeground(Color.WHITE);
		lPost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lPost.setBounds(330, 366, 97, 33);
		panel.add(lPost);

		JTextPane tPost = new JTextPane();
		tPost.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tPost.setBackground(new Color(224, 255, 255));
		tPost.setBounds(437, 366, 115, 33);
		panel.add(tPost);

		JLabel lState = new JLabel("State");
		lState.setForeground(Color.WHITE);
		lState.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lState.setBounds(10, 424, 97, 33);
		panel.add(lState);

		JTextPane tState = new JTextPane();
		tState.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tState.setBackground(new Color(224, 255, 255));
		tState.setBounds(132, 424, 177, 33);
		panel.add(tState);

		JLabel lMobile = new JLabel("Mobile");
		lMobile.setForeground(Color.WHITE);
		lMobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lMobile.setBounds(330, 424, 97, 33);
		panel.add(lMobile);

		JTextPane tMobile = new JTextPane();
		tMobile.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tMobile.setBackground(new Color(224, 255, 255));
		tMobile.setBounds(392, 424, 192, 33);
		panel.add(tMobile);

		JLabel lGender = new JLabel("Gender\r\n");
		lGender.setForeground(Color.WHITE);
		lGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lGender.setBounds(345, 163, 82, 33);
		panel.add(lGender);



		Choice c1 = new Choice();
		c1.setForeground(Color.BLACK);
		c1.setBackground(new Color(224, 255, 255));
		c1.setBounds(437, 163, 115, 33);
		//c1.setBackground(new Color(224, 255, 255));
		c1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		c1.add("");
		c1.add("M");
		c1.add("F");
		panel.add(c1);


		JLabel lAddress2 = new JLabel("Address Line 2");
		lAddress2.setForeground(Color.WHITE);
		lAddress2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lAddress2.setBounds(10, 291, 135, 33);
		panel.add(lAddress2);

		JTextPane tAdd2 = new JTextPane();
		tAdd2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tAdd2.setBackground(new Color(224, 255, 255));
		tAdd2.setBounds(164, 291, 420, 33);
		panel.add(tAdd2);


		JLabel l2 = new JLabel("Sign Up");
		l2.setBounds(837, 11, 85, 33);
		l2.setFont(new Font("Nirmala UI", Font.PLAIN, 22));
		contentPane.add(l2);

		JLabel lUsername = new JLabel("Username");
		lUsername.setForeground(Color.WHITE);
		lUsername.setBounds(604, 80, 85, 33);
		lUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lUsername);


		JTextPane tUsername = new JTextPane();
		tUsername.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		tUsername.setBackground(SystemColor.inactiveCaptionBorder);
		tUsername.setBounds(757, 80, 243, 32);
		contentPane.add(tUsername);

		JLabel lPass1 = new JLabel("Password");
		lPass1.setForeground(Color.WHITE);
		lPass1.setBounds(604, 163, 76, 33);
		lPass1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lPass1);

		JTextPane pass1 = new JTextPane();
                pass1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		pass1.setBackground(SystemColor.inactiveCaptionBorder);
		pass1.setBounds(757, 163, 243, 33);
		contentPane.add(pass1);

		JLabel lPass2 = new JLabel("Confirm Password");
		lPass2.setForeground(Color.WHITE);
		lPass2.setBounds(604, 240, 143, 33);
		lPass2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lPass2);

		JTextPane pass2 = new JTextPane();
                pass2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
		pass2.setBackground(SystemColor.inactiveCaptionBorder);
		pass2.setBounds(757, 243, 243, 33);
		contentPane.add(pass2);

		JButton save = new JButton("Save");
		save.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		save.setBounds(1067, 517, 97, 33);
		contentPane.add(save);

        exit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            LoginFrame frame = new LoginFrame();
	    frame.setVisible(true);
            j.dispose();

        }
        });

        save.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name=tName.getText();
            String add1=tAdd1.getText();
            String add2=tAdd2.getText();
            String city=tCity.getText();
            String state=tState.getText();
            String mobile=tMobile.getText();
            String post=tPost.getText();
            String gender=c1.getSelectedItem();
            String p1=pass1.getText();
            String p2=pass2.getText();
            String user=tUsername.getText();
            
            java.sql.Date sqldate = new java.sql.Date(date.getDate().getTime());
            int count=0;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                Statement st=conn.createStatement(); 
                ResultSet sr=st.executeQuery("select * from login");
                while(sr.next())
                {
                    String uName=sr.getString("username");
                    if(user.equals(uName))
                    {
                        count++;
                    }
                }
            }
            catch(Exception ex)
            {
                 System.out.println("Error");
            }
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter your Name");
            }else if(mobile.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter your mobile number");
            }
            else if(add1.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter adsress line 1");
            }else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter your city");
            }else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter your state");
            }else if(post.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter postal code");
            }else if(user.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter your username");
            }else if(p1.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please enter your password");
            }else if(p2.equals(""))
            {
                JOptionPane.showMessageDialog(j, "Please confirm your password");
            }else if(count>0)
            {
                JOptionPane.showMessageDialog(j, "Username is already taken");
                tUsername.setText("");
            }
            else if(!p1.equals(p2))
            {
                JOptionPane.showMessageDialog(j, "Password entries don't match");
                pass1.setText("");
                pass2.setText("");
            }else if(post.length()!=6) {
                JOptionPane.showMessageDialog(j, "Enter a valid Postal Code");
                tPost.setText("");
            }else if(mobile.length()!=10) {
                JOptionPane.showMessageDialog(j, "Enter a valid Phone Number");
                tMobile.setText("");
            }
            else{
            

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
                PreparedStatement stmt=conn.prepareStatement("INSERT INTO `customer` (`name`,`dob`,`gender`,`phno`,`address1`,`address2`,`city`,`state`,`pincode`) values(?,?,?,?,?,?,?,?,?)");
                stmt.setString(1,name);
                stmt.setDate(2,sqldate);
                stmt.setString(3,gender);
                stmt.setString(4,mobile);
                stmt.setString(5,add1);
                stmt.setString(6,add2);
                stmt.setString(7,city);
                stmt.setString(8,state);
                stmt.setString(9,post);
                stmt.executeUpdate();
                
                Statement st=conn.createStatement(); 
                ResultSet sr=st.executeQuery("select * from customer order by cus_id desc limit 1");
                int cid=0;
                if(sr.next())
                {
                    cid=sr.getInt("cus_id");
                }
                PreparedStatement s=conn.prepareStatement("INSERT INTO `login` (`id`,`username`,`password`,`role`) values (?,?,?,?) ");
                s.setInt(1,cid);
                s.setString(2,user);
                s.setString(3,p1);
                s.setString(4,"C");
                s.executeUpdate();
            }
            catch(Exception ex)
            {
                 System.out.println("Error");
            } 
            LoginFrame f=new LoginFrame();
            f.setVisible(true);
            j.dispose();

            } 
            
        }
        });

        j.setVisible(true);
        
	}
}
