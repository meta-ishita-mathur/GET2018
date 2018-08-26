USE StoreFront;

#Assignment2:
#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT P.ProductID, P.Product_Name, COUNT(C.ProductID) AS Count_Categories
FROM Product P INNER JOIN Product_Categorized C
ON C.ProductID = P.ProductID
GROUP By P.ProductID
HAVING Count_Categories > 1;

#Display Count of products as per below price range
SELECT (CASE WHEN Product_Price >= 0 AND Product_Price <= 500 THEN '0-500'
               WHEN Product_Price > 500 AND Product_Price <= 2000 THEN '500-2000'
                ELSE 'Above 2000'
           END) AS Price_Range, Count(ProductID) As Count_Of_Products 
FROM Product
GROUP BY Price_Range;

#Display the Categories along with number of products under each category
SELECT C.CategoryID, C.Category_Name, COUNT(PC.CategoryID)
FROM Product_Category C INNER JOIN Product_Categorized PC
ON C.CategoryID = PC.CategoryID
GROUP BY PC.CategoryID;

#Assignment3:
#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT U.UserID, CONCAT(U.First_Name, ' ', U.Last_Name) AS Name, COUNT(O.UserID) AS Count_Of_Order
FROM User U INNER JOIN Orders O
ON U.UserID = O.UserID
WHERE O.Order_Date > (DATE_SUB(CURDATE(), INTERVAL 30 DAY))
GROUP BY O.UserID;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days
SELECT U.UserID, CONCAT(First_Name, ' ', Last_Name) AS Name, SUM(O.Total_Price) AS Amount_Spent
FROM Orders O INNER JOIN User U
ON O.UserID = U.UserID
WHERE O.Order_Date > (DATE_SUB(CURDATE(), INTERVAL 30 DAY))
GROUP BY O.UserID
ORDER BY Amount_Spent DESC
LIMIT 10;

#Display top 20 Products which are ordered most in last 30 days along with numbers
SELECT P.ProductID,  P.Product_Name, COUNT(OI.ProductID) AS Count_Of_Products_Sold
FROM Product P INNER JOIN Order_Items OI
ON P.ProductID = OI.ProductID
INNER JOIN Orders O
ON OI.OrderID = O.OrderID
WHERE O.Order_Date > (DATE_SUB(CURDATE(), INTERVAL 60 DAY))
GROUP BY OI.ProductID
ORDER BY Count_Of_Products_Sold DESC
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT SUM(Total_Price) AS Monthly_Revenue, MONTH(Order_Date) AS Month
FROM Orders
WHERE Order_Date >= Date_Sub(NOW(), INTERVAL 6 MONTH)
Group By Month(Order_Date)
ORDER BY Monthly_Revenue DESC;

#Mark the products as Inactive which are not ordered in last 6 MONTHS
SET SQL_SAFE_UPDATES = 0;
UPDATE Product
SET Is_Active = FALSE
WHERE Product.ProductID NOT IN 
    (SELECT OI.ProductID
     FROM Orders O INNER JOIN Order_Items OI
     ON O.OrderID = OI.OrderID
     WHERE O.Order_Date > (DATE_SUB(CURDATE(), INTERVAL 90 DAY))
    );

#Given a category search keyword, display all the Products present in this category/categories.
SELECT P.Product_Name
FROM Product AS P
INNER JOIN Product_Categorized AS PC ON P.ProductID = PC.ProductID
INNER JOIN Product_Category AS C ON PC.CategoryID = C.CategoryID
WHERE C.Category_Name = "MOBILE";

#Display top 10 Items which were cancelled most.
SELECT P.ProductID, P.Product_Name, COUNT(OI.Shipping_Info) AS Times_Cancelled
FROM Product P INNER JOIN Order_Items OI
ON P.ProductID = OI.ProductID
WHERE OI.Shipping_Info = "CANCELLED"
GROUP BY OI.ProductID
ORDER BY Times_Cancelled DESC
LIMIT 10;

#Assignment4:
CREATE TABLE Zipcode
(
    Zip INT NOT NULL,
    City VARCHAR(50) NOT NULL,
    State VARCHAR(50) NOT NULL,
    PRIMARY KEY(Zip)
);

INSERT INTO Zipcode VALUES
(313001, 'Udaipur', 'Rajasthan'),
(302019, 'Jaipur', 'Rajasthan'),
(302020, 'Jaipur', 'Rajasthan'), 
(302021, 'Jaipur', 'Rajasthan');

SELECT Zip, City, State
FROM Zipcode
ORDER BY State, City;

#Assignment5:

#Create a view displaying the order information (Id, Title, Price, Shopper’s name,
#Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
CREATE OR REPLACE VIEW Order_Information AS
		SELECT O.OrderID, OI.ProductID, OI.Product_Quantity, P.Product_Name, O.Total_Price,
           CONCAT(U.First_Name, ' ', U.Last_Name) AS Name, U.Email, O.Order_Date, OI.Shipping_Info
		FROM User U INNER JOIN Orders O ON O.UserID = U.UserID
               INNER JOIN Order_Items OI ON O.OrderID = OI.OrderID
               INNER JOIN Product P ON P.ProductID = OI.ProductID
    WHERE O.Order_Date > (DATE_SUB(CURDATE(), INTERVAL 60 DAY))
    ORDER BY O.Order_Date DESC;
        
SELECT * FROM Order_Information;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT ProductID, Product_Name
FROM Order_Information
WHERE Shipping_Info = "SHIPPED";

#Use the above view to display the top 5 most selling products
SELECT Product_Name, SUM(Product_Quantity) AS No_Of_Products_Sold
FROM Order_Information
GROUP BY Product_Name
ORDER BY No_Of_Products_Sold DESC 
LIMIT 5;
