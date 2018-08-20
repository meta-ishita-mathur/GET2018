USE StoreFront;

#Assignment 1:

#Create a function to calculate number of orders in a month. Month and
#year will be input parameter to function.
DELIMITER $$
DROP FUNCTION IF EXISTS CalculateNumberOfOrdersInMonth $$

CREATE FUNCTION CalculateNumberOfOrdersInMonth(Month int, Year int) RETURNS int
    BEGIN
        DECLARE No_Of_Orders int;
        SELECT COUNT(OrderID) INTO No_Of_Orders
        FROM Order_Details
        WHERE Month(Order_Date) = Month AND YEAR(Order_Date) = Year;
    RETURN No_Of_Orders;
    END $$
    
SELECT CalculateNumberOfOrdersInMonth(07, 2018);

#Create a function to return month in a year having maximum orders. 
#Year will be input parameter.
DELIMITER $$
DROP FUNCTION IF EXISTS GetMonthHavingMaximumOrder $$

CREATE FUNCTION GetMonthHavingMaximumOrder(Year int) RETURNS int
    BEGIN
        DECLARE Month int;
        SELECT orderMonth INTO Month
        FROM
        ( SELECT COUNT(OrderID) AS CountOfOrders, MONTH(Order_Date) AS OrderMonth
        FROM Order_Details
        WHERE YEAR(Order_Date) = Year
        GROUP BY Month(Order_Date)
        ORDER BY CountOfOrders DESC) AS F
        LIMIT 1;
    RETURN Month;
    END $$

SELECT GetMonthHavingMaximumOrder(2018);

#Assignment 2:

#Create a Stored procedure to retrieve average sales of each product in a month.
#Month and year will be input parameter to function.

DELIMITER $$
DROP PROCEDURE IF EXISTS GetAverageSalesOfEachProduct $$

CREATE PROCEDURE GetAverageSalesOfEachProduct(Month int, Year int)
    BEGIN
        SELECT P.ProductID, ROUND(SUM(P.Product_Price * O.Product_Quantity) / DAY(LAST_DAY(OD.Order_Date)), 2) AS ProductAverage 
        FROM Product P INNER JOIN Cart_Items O ON P.ProductID = O.ProductID
        INNER JOIN Order_Details OD ON OD.CartID = O.CartID
        WHERE MONTH(OD.Order_Date) = Month AND YEAR(OD.Order_Date) = Year
        GROUP BY P.ProductID;
    END$$
    
CALL GetAverageSalesOfEachProduct(05, 2018);

#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter.
#Put validation on input dates like start date is less than end date. 
#If start date is greater than end date take first date of month as start date.

DELIMITER $$
DROP PROCEDURE IF EXISTS GetOrderDetails $$

CREATE PROCEDURE GetOrderDetails(StartDate DATE, EndDate DATE)
    BEGIN
        IF StartDate > EndDate THEN
        SET StartDate = DATE_FORMAT(EndDate, '%Y-%m-01');
    END IF;
        SELECT O.OrderID, C.ProductID, Shipping_Info
        FROM Order_Details O, Cart_Items C
        WHERE O.CartID = C.CartID AND Order_Date >= StartDate AND Order_Date <= EndDate;        
    END$$
DELIMITER ;

CALL GetOrderDetails('2018-05-29', '2018-05-20');

#Identify the columns require indexing in order, product, 
#category tables and create indexes
ALTER TABLE Product ADD INDEX index_On_Product_Id(ProductID);
ALTER TABLE Product ADD FULLTEXT index_On_Product_Name(Prdouct_Name);

ALTER TABLE Category ADD INDEX index_On_Category_Id(CategoryID);
ALTER TABLE Category ADD UNIQUE index_On_Parent_Id(Parent_CategoryID);
ALTER TABLE Caterory ADD FULLTEXT index_On_Category_Name(Category_Name);

ALTER TABLE Order_Details ADD INDEX index_On_Order_Id(OrderID);
ALTER TABLE Order_Details ADD INDEX index_On_Date_Of_Order(Order_Date);