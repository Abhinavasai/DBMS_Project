use groceries_portal;

CREATE TABLE customer (
  cus_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  phno CHAR(10) NOT NULL,
  address1 VARCHAR(100) NOT NULL,
  address2 VARCHAR(100) NULL,
  state VARCHAR(20) NOT NULL,
  city VARCHAR(20) NOT NULL,
  pincode CHAR(6) NOT NULL,
  PRIMARY KEY (cus_id),
  UNIQUE INDEX phno_UNIQUE (phno ASC) VISIBLE);
  
ALTER TABLE customer
ADD COLUMN dob DATE NOT NULL AFTER name,
ADD COLUMN gender CHAR(1) NULL AFTER dob,
CHANGE COLUMN city city VARCHAR(20) NOT NULL AFTER address2;
  
  
INSERT INTO customer (name, phno, address1, address2, state, city, pincode) VALUES ('Tirunagari Abhinava Sai', '8187020374', '17-1-391\\s\\521 ', 'Singareni Colony', 'Telangana', 'Hyderabad', '500059');
INSERT INTO customer (name, phno, address1, address2, state, city, pincode) VALUES ('Nikhil Sai Reddy', '7330990690', 'Flat No 102, Dreams Apartments', 'Rd No 3 BanjaraHills', 'Telangana', 'Hyderabad', '500034');