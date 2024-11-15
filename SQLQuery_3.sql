--Unit 3 Assignment No.1
--Sales Order Database pages 235-236
--#1
SELECT VendName,VendCity
FROM Vendors 
WHERE  VendCity IN ('Ballard', 'Bellevue', 'Redmond')

--#2
SELECT ProductName 
FROM Products
WHERE RetailPrice >= $125.00 
ORDER BY ProductName

--#3
SELECT VendName
FROM Vendors
WHERE VendWebPage IS NULL