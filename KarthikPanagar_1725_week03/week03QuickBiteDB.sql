drop database quickbite;
CREATE DATABASE quickbite;

USE quickbite;

CREATE TABLE Item (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Cost DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Customer (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Mobile VARCHAR(15) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL UNIQUE,
    Order_date DATE
);

CREATE TABLE `Order` (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Date DATE NOT NULL,
    CustomerId INT,
    TotalCost DECIMAL(10, 2),
    FOREIGN KEY (CustomerId) REFERENCES Customer(Id)
);

CREATE TABLE OrderItem (
    OrderId INT,
    ItemId INT,
    Quantity INT,
    PRIMARY KEY (OrderId, ItemId),
    FOREIGN KEY (OrderId) REFERENCES `Order`(Id),
    FOREIGN KEY (ItemId) REFERENCES Item(Id)
);

select*from customer;
select*from Item;
select*from customer;


delete from customer 
where id=4;

