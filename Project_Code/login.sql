use groceries_portal;

CREATE TABLE login (
  id INT NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE);
  
INSERT INTO login (id, username, password) VALUES ('1', 'Abhinav', 'marvel');
INSERT INTO login (id, username, password) VALUES ('2', 'Nikhil', 'superman');