USE StoreFront;

#Assignment2:
#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT Product.ProductID, Product_Name, Count(CategoryID) AS Count_Of_Categroy 
FROM Product, Product_Category_Bridge
WHERE Product.ProductID = Product_Category_Bridge.ProductID
GROUP BY Product.ProductID
HAVING COUNT(*) > 1;

#Display Count of products as per below price range
SELECT (CASE WHEN Product_Price >= 0 AND Product_Price <= 500 THEN '0-500'
               WHEN Product_Price > 500 AND Product_Price <= 2000 THEN '500-2000'
                ELSE 'Above 2000'
           END) AS Price_Range, Count(ProductID) As Count_Of_Products 
FROM Product
GROUP BY Price_Range;

#Display the Categories along with number of products under each category
SELECT DISTINCT C.Category_Name, COUNT(*) AS Product_Count
FROM Category AS C
LEFT JOIN Product_Category_Bridge AS cpr ON C.CategoryID = cpr.CategoryID
GROUP BY cpr.CategoryID;

#Assignment3:
#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT User.UserID, CONCAT(First_Name, ' ', Last_Name) AS Name, Count(C.Product_Quantity) AS Count_Of_Order
FROM User, Order_Details AS O
LEFT JOIN Cart_Items AS C ON O.CartID = C.CartID
WHERE User.UserID = O.UserID AND Order_Date >= Date_Sub(NOW(), INTERVAL 1 MONTH)
GROUP BY O.UserID;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days
SELECT User.UserID, CONCAT(First_Name, ' ', Last_Name) AS Name, SUM(Order_Details.Total_Price) AS Amount_Spent,
Count(OrderID) AS Count_Of_Order
FROM User, Order_Details
WHERE User.UserID = Order_Details.UserID AND Order_Date >= Date_Sub(NOW(), INTERVAL 1 MONTH)
GROUP BY Order_Details.UserID
Order BY Amount_Spent DESC
LIMIT 3;

#Display top 20 Products which are ordered most in last 30 days along with numbers
SELECT Cart_Items.ProductID, Product_Name, Count(Cart_Items.ProductID) AS Count_Of_Products_Sold
FROM Cart_Items, Order_Details, Product
WHERE Order_Date >= Date_Sub(NOW(), INTERVAL 1 MONTH) AND Order_Details.CartID = Cart_Items.CartID
AND Cart_Items.ProductID = Product.ProductID
GROUP BY Cart_Items.ProductID
Order BY Count_Of_Products_Sold DESC
LIMIT 5;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT SUM(Total_Price) AS Monthly_Revenue, MONTH(Order_Date)
FROM Order_Details
WHERE Order_Date >= Date_Sub(NOW(), INTERVAL 6 MONTH)
Group By Month(Order_Date)
ORDER BY Monthly_Revenue DESC;

#Mark the products as Inactive which are not ordered in last 6 MONTHS
UPDATE Order_Details 
SET Shipping_Info = 'InActive'
WHERE Order_Date <= Date_Sub(NOW(), INTERVAL 6 MONTH);
SELECT * FROM Order_Details;

SELECT P.Product_Name
FROM Product AS P
LEFT JOIN Product_Category_Bridge AS PCB ON P.ProductID = PCB.ProductID
LEFT JOIN Category AS C ON PCB.CategoryID = C.CategoryID
WHERE C.Category_Name IN ("ELECTRONICS");

#Display top 10 Items which were cancelled most.
SELECT Product.ProductID, Product.Product_Name, Count(C.ProductID) AS Times_Cancelled 
FROM Product, Cart_Items AS C
LEFT JOIN Order_Details O ON O.CartID = C.CartID
WHERE Product.ProductID = C.ProductID AND O.Shipping_Info = 'Cancelled'
GROUP BY (C.ProductID)
ORDER BY Times_Cancelled DESC
LIMIT 10;

#Create a view displaying the order information (Id, Title, Price, Shopper’s name,
#Email, Orderdate, Status) with latest ordered items should be displayed first for
#last 60 days.
CREATE VIEW OrderInformation 
    AS 
    SELECT O.Order_Id, P.Product_Name,I.Total_Price,
            CONCAT(U.First_Name, ' ', U.Last_Name) AS User_Name,U.Email_Id,O.Date_Of_Order,I.Order_Status
    FROM OrderDetails O,OrderProductDetails I,Product P,User U
    WHERE U.User_Id = O.User_Id AND O.Order_Id = I.Order_Id 
    AND I.Product_Id = P.Product_Id AND O.Date_Of_Order>=Date_Sub(NOW(), INTERVAL 60 DAY)
    ORDER BY O.Date_Of_Order DESC;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT Order_Id,Product_Name 
FROM OrderInformation
WHERE Order_Status = 'Shipped'; 

#Use the above view to display the top 5 most selling products
SELECT Product_Name, COUNT(Product_Name) AS No_Of_Products_Sold
FROM OrderInformation
GROUP BY Product_Name
ORDER BY No_Of_Products_Sold DESC
LIMIT 3;
