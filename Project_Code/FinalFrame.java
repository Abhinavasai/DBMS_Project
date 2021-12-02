import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalFrame
{
   FinalFrame()
   {
     JFrame f = new JFrame("Checkout");
     ImageIcon g0 = new ImageIcon("checkout.jpg");
     //f.setLayout(new FlowLayout(FlowLayout.CENTER));

      JLabel j1 = new JLabel("",g0,JLabel.CENTER);
  

     j1.setBounds(0,0,800,800);
     f.add(j1);
     f.setSize(850,850);
	   f.setVisible(true);
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


   }

   public static void main(String[] args)
    {
     new FinalFrame();
   }

}
