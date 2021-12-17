import java.awt.Color;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.sql.*;
import java.io.*;
import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import java.util.ArrayList;
import java.util.List;


public class TimeSeriesChartExample extends JFrame {

  private static final long serialVersionUID = 1L;

  public TimeSeriesChartExample(String title) {
    super(title);
    // Create dataset
    XYDataset dataset = createDataset();
    // Create chart
    JFreeChart chart = ChartFactory.createTimeSeriesChart(
        "Sales", // Chart
        "Date", // X-Axis Label
        "Number", // Y-Axis Label
        dataset);

    //Changes background color
    XYPlot plot = (XYPlot)chart.getPlot();
    plot.setBackgroundPaint(new Color(255,228,196));
    
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private XYDataset createDataset() {
    
    ArrayList<Integer> list=new ArrayList<Integer>();
    ArrayList<String> d = new ArrayList<String>();
    
    int i=0;

    TimeSeriesCollection dataset = new TimeSeriesCollection();

    TimeSeries series1 = new TimeSeries("Series1");

    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groceries_portal","root","Abhinav1#");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from transaction where DATEDIFF(now(),date_time) <= 7");
           
           
            while(rs.next() )
            {
                
                String date =  rs.getString(4).substring(0,10);
                //System.out.println(date);
                if(d.contains(date)==true)
                {
                    //System.out.println("Entered");
                    int ind=d.indexOf(date);
                    int x=list.get(ind);
                    int amt = rs.getInt(3);
                    x=x+amt;
                    list.set(ind,x);
                }else
                {
                    d.add(date);
                    //System.out.println(d.get(list.size()-1));
                    int amt = rs.getInt(3);
                    list.add(amt);    
                }  
               // System.out.println(amt+ "\n\n" +date);
                
            }
            con.close();
        }
        catch(Exception ae)
        {
            System.out.println("Error");
            
        }

        

        int sizea = list.size();
        //System.out.println("size = " + sizea);

        int myarray[]=new int[sizea];
        String mydate[]=new String[sizea];
        
        i=0;
        while(i<sizea)
        {
            myarray[i] = list.get(i);
            //System.out.println(myarray[i]);
            i++;
        }
        i=0;
           

        for(String b:d)
        {
            mydate[i] = b;
           // System.out.println(mydate[i]);
            i++;
        }

        

       

        for(i=0;i<sizea;i++)
        {
            int day = Integer.parseInt(mydate[i].substring(8,10));
            int month = Integer.parseInt(mydate[i].substring(5,7));
            int year = Integer.parseInt(mydate[i].substring(0,4));
            //System.out.println(day+" "+ month+" "+ year);
            series1.add(new Day(day, month, year), new Double(myarray[i]));

        }
        dataset.addSeries(series1);
        
        return dataset;

  }

  
}