import java.sql.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends JFrame implements ActionListener
{
    JLabel l1,l2; 
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    JCheckBox ShowPass;
    
    LoginFrame(){

        Container c = this.getContentPane();
        ImageIcon g0 = new ImageIcon("logo.jpg");
        JLabel label=new JLabel(g0);
        label.setBounds(40,50,400,60);
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        t1 = new JTextField();
        t2 = new JPasswordField();
        b1 = new JButton("Login");
        b2 = new JButton("Reset");
        ShowPass = new JCheckBox("Show Password");
        c.setLayout(null);
        l1.setBounds(50,150,100,30);
        l2.setBounds(50,220,100,30);
        t1.setBounds(150,150,150,30);
        t2.setBounds(150,220,150,30);
        ShowPass.setBounds(150,250,150,30);
        b1.setBounds(50,300,100,30);
        b2.setBounds(200,300,100,30);
        c.add(label);
        c.add(l1);
        c.add(l2);
        c.add(t1);
        c.add(t2);
        c.add(ShowPass);
        c.add(b1);
        c.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        ShowPass.addActionListener(this);
        
    }
    
      public void actionPerformed(ActionEvent e)
      {
          int count=0;
          if(e.getSource() == b1)
          {
              String usertxt,pass;
              usertxt = t1.getText();
              pass    = t2.getText();
              try
              {

                 Class.forName("com.mysql.jdbc.Driver");  
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Nikhil2202#");
                 Statement stmt=con.createStatement(); 
                 ResultSet rs=stmt.executeQuery("select * from login");  
            
                  while(rs.next())
                  {
                      String user=rs.getString(2);
                      String pwd=rs.getString(3);
                      if(usertxt.equals(user) && pass.equals(pwd))
                      {
                           new MainFrame();
                           count++;
                  	   this.dispose(); 
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
              /*if(usertxt.equals("abhinav") && pass.equals("marvel"))
              {
                  new MainFrame();
                  this.dispose();
              }else if(usertxt.equals("nikhil") && pass.equals("superman"))
              {
                  new MainFrame();
                  this.dispose();
              }else if(usertxt.equals("rithwik") && pass.equals("java"))
              {
                  new MainFrame();
                  this.dispose();
              }else if(usertxt.equals("emp1")&& pass.equals("pass"))
              {
                  new EmployeeFrame();
                  this.dispose();
              }
              else{
                   JOptionPane.showMessageDialog(this, "Invalid Username or Password");
              }*/
          }
          
          if(e.getSource() == b2)
          {
              t1.setText("");
              t2.setText("");
          }
          
          
          if (e.getSource() == ShowPass)
          {
            if (ShowPass.isSelected())
            {
                t2.setEchoChar((char) 0);
            }
            else 
            {
                t2.setEchoChar('*');
            }
          }
 
        
      }
    
    
	public static void main(String[] args) {
		LoginFrame j = new LoginFrame();
                j.setTitle("Login Page") ;
		j.setSize(500,500);
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}