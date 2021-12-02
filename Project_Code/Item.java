
import java.io.*;
import java.util.*;

public class Item
{
String name;
int price;
String cat;
int stock;


Item(String name,int price,String cat,int stock)
{
    this.name=name;
    this.price=price;
    this.cat=cat;
    this.stock=stock;
}


public static void printCart(ArrayList<Item> cart)
{
    for(Item i :cart)
    {
        try{
            FileWriter fstream = new FileWriter("cart.txt",true);
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write(i.name + " " + i.price + " " + i.cat + " " + i.stock + "\n");
            out.close();
        }catch (Exception e){
            System.err.println("Error while writing to file: " +
            e.getMessage());
        }
    }
}


}