create database groceries_portal;


use groceries_portal;



CREATE TABLE `product` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `category` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`prod_id`)
);


select * from product;

INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (1,'Rice','Staples',25,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (2,'Dal','Staples',55,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (3,'Sugar','Staples',40,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (4,'Tomato','Vegetables&Fruits',100,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (5,'Onion','Vegetables&Fruits',48,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (6,'Potato','Vegetables&Fruits',35,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (7,'Banana','Vegetables&Fruits',20,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (8,'Bread','Breakfast&Dairy',35,30);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (9,'Cornflakes','Breakfast&Dairy',80,25);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (10,'Milk','Breakfast&Dairy',30,30);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (11,'Eggs','Breakfast&Dairy',40,15);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (12,'Soap','PersonalCare',50,35);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (13,'Toothbrush','PersonalCare',35,25);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (14,'Toothpaste','PersonalCare',50,40);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (15,'Shampoo','PersonalCare',150,20);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (16,'Detergent','HouseholdItems',200,25);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (17,'Repellent','HouseholdItems',50,15);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (18,'Battery','HouseholdItems',13,40);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (19,'Broomstick','HouseholdItems',35,15);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (20,'Cookies','Snacks',20,50);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (21,'Chocolate','Snacks',10,90);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (22,'Chips','Snacks',25,45);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (23,'Cake','Snacks',120,20);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (24,'Juice','Beverages',20,30);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (25,'Coke','Beverages',35,40);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (26,'ColdCoffee','Beverages',50,25);
INSERT INTO product (`prod_id`,`name`,`category`,`price`,`stock`) VALUES (27,'IceCream','Snacks',30,30);


select * from product;

