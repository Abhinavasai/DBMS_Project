# DBMS_Project

** DOWNLOAD JAR FILES

Project Name :- Online Groceries Portal

Team Members :- Rithwik Lagishetty (19XJ1A0536)
                Nikhil Sai Reddy (19XJ1A0544) 
                T.Abhinavasai (19XJ1A0581) 

Idea:- To Design a Groceries Portal which is functional to both customer and employee.


**File To Execute :- LoginFrame.java

Database Info:- 
  -Name: groceries_portal.
  -Username: root.
  -password: respective database password.
  -localhost: localhost:3306.


Login Credentials :- Refer to database(Login Table).


Various files and their functions:-

*Every file except Item.java has connection to the MySql database.

1) Item.java :-            Each product is represented as an object called Item with the attributes : id,name,price, category 
                           and stock.Object(Item) instantiation is done in this file.
  

2) LoginFrame.java :-      Contains code for Login Frame, checks whether the username and password match in the database from
                           login table and if password match it will enter into MainFrame and if there is a new user the to 
                           Registration Frame.

3)RegistrationFrame.java :-Opens when a customer clicks signup button and asks to enter the details and it checks whether the 
                           phone number is a 10-digit number and does to confirm password entry match, etc and adds the user to 
                           customer table.

4) MainFrame.java :-       Contains code for the Main Frame of the project which contains the various categories available 
                           in the store and cutomer can add different categories into cart and each category will diplay their
                           products and finally customer can checkout to cart and it will call the CartFrame, also we have a button to 
                           print all the user details(user info from cutomer table).

5)TableFrame.java :-       Contains code for table which contains a list of items belonging to their respective categories 
                           from which user can select items and add them to cart and checkout to bill which will call the 
                           LastFrame(uses product table) on closing will lead to MainFrame.
 

6) CartFrame.java :-       Contains code for the Cart and the total cost of all items and will update the total cost and date 
                           of order placed along with user info in the transaction table and once clicked on checkout will lead 
                           customer to Thankyou page(LastFrame).

7) LastFrame.java :-       Contains the final window of the entire project/ checkout page with order detalis and user info(ph.no,addr etc).


8)Employee.java :-         Contains code for the EmployeeFrame where an employee can either add a product, or remove a product
                           ,or change the price of the product.Contains functions relating to the EmployeeFrame.

   
   Functions :-
 
  * changePrice : method which helps in changing price of a product.

  * removeProduct : method which helps is removing a product from the portal. 
 
  * addProduct : method which helps in adding a certain product to the portal.
 
  * Sales Graph: Graph for viewing sales distribution over a week(day vs cost).



Point to Note while executing :-

In Signup page the cutomer must enter the date of birth, for the rest of the entries a pop up message will be shown!


  



