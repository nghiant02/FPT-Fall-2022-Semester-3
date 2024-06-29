--Q2
SELECT ps.SubcategoryID,ps.Category,ps.Name
FROM ProductSubcategory ps
WHERE ps.Category = 'Accessories'

--Q3
SELECT pdi.ProductID,pdi.LocationID,pdi.Quantity
FROM dbo.ProductInventory pdi
WHERE LocationID ='7'AND Quantity > 250
ORDER BY Quantity DESC

--Q4
SELECT p.ProductID, p.Name AS ProductName, p.Color, p.Cost, p.Price,
l.LocationID, l.Name AS LocationName, piv.Shelf, piv.Bin, piv.Quantity
FROM Product p 
LEFT join ProductInventory piv on p.ProductID = piv.ProductID
LEFT join Location l on l.LocationID = piv.LocationID
WHERE p.Color ='Yellow' AND p.Cost < 400 

--Q5
Select pm.ModelID, pm.Name, COUNT(p.ModelID) AS NumberOfProducts
from ProductModel pm left join Product p on pm.ModelID = p.ModelID
GROUP BY pm.ModelID, pm.Name
HAVING pm.Name LIKE 'Mountain%' OR pm.Name LIKE'ML Mountain%'
ORDER BY COUNT(p.ModelID) desc

--Q6
SELECT p.ProductID, p.Name, SUM(piv.Quantity) AS TotalQuantity
FROM Product p join ProductInventory piv on p.ProductID = piv.ProductID
GROUP BY p.ProductID, p.Name
HAVING SUM(piv.Quantity) >= ALL (SELECT SUM(piv.Quantity) AS TotalQuantity
								FROM Product p join ProductInventory piv on p.ProductID = piv.ProductID
								GROUP BY p.ProductID, p.Name)
--Q7
SELECT i.LocationID, l.Name, p.ProductID, p.Name, A.Quantity FROM [dbo].[Location] L, [dbo].[Product] P , [dbo].[ProductInventory] I, 
(
    select  i.LocationID, MAX(i.Quantity) as Quantity FROM  [dbo].[ProductInventory] I
    INNER join [dbo].[Product] P ON I.ProductID = P.ProductID
    INNER join [dbo].[Location] L ON l.LocationID = i.LocationID
    GROUP BY i.LocationID
) AS A
WHERE l.LocationID = A.LocationID
AND p.ProductID = i.ProductID
AND l.LocationID = i.LocationID
AND a.Quantity = i.Quantity
ORDER BY l.Name asc, p.Name DESC

--Q8
CREATE PROCEDURE proc_product_quantity @productID int,@totalQuantity int OUT
AS
BEGIN
SET @totalQuantity=(SELECT SUM(pdi.Quantity)
FROM dbo.Product p,dbo.ProductInventory pdi
WHERE p.ProductID=pdi.ProductID AND pdi.ProductID=@productID)
END
DECLARE @x INT 
EXEC proc_product_quantity 1,@x OUTPUT
SELECT @x AS TotalQuantity

--Q9
DROP TRIGGER tr_insert_Product

CREATE TRIGGER tr_insert_Product
ON product after INSERT -- INSTEAD of 
as
BEGIN
SELECT p.ProductID,p.Name AS ProductName,pm.ModelID,pm.Name AS ModelName
FROM inserted i,dbo.Product p,dbo.ProductModel pm
WHERE i.ProductID = p.ProductID AND pm.ModelID=i.ModelID
END
INSERT INTO dbo.Product
(
    ProductID,
    Name,
    Cost,
    Price,
    ModelID,
    SellStartDate
)
VALUES
(   1000,         
    'Product Test',      
    12.5,      
    15.5,
	1,
    '2021-10-25'  
)
--Q10
select * FROM dbo.Location

Delete ProductInventory
Where LocationID in (select l.LocationID from dbo.Location l 
where l.Name = 'Tool Crib')
