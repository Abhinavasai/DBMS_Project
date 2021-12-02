
import java.io.*;
import java.util.*;


public class Employee
{

public static void changePrice(ArrayList<Item> list,String name,int nprice)
{
    for(Item i:list)
    {
        if(i.name.equals(name))
        {
            i.price=nprice;
        }
    }
}

public static void removeProduct(ArrayList<Item> list,String name)
{
    int i=0;
    for(Item i1:list)
    {
        if(i1.name.equals(name))
        {
            break;
        }
        i++;
    }
    list.remove(i);
}

public static void addProduct(ArrayList<Item> list,String name,int price,String category,int stock)
{
    Item n=new Item(name,price,category,stock);
    int i=0;
    for(Item i1:list)
    {
        if(i1.cat.equals(category))
        {
            break;
        }
        i++;
    }
    list.add(i,n);
    
    
}



}