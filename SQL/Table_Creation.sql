CREATE TABLE sales (
  customer_id VARCHAR(1) NOT NULL,
  order_date DATE,
  product_id INTEGER 
);
CREATE TABLE members (
  customer_id VARCHAR(1) NOT NULL,
  join_date DATE,
  customer_name VARCHAR(30)
);
CREATE TABLE menu (
  product_id INTEGER NOT NULL,
  product_name VARCHAR(5),
  price INTEGER
  PRIMARY KEY (product_id),
);
