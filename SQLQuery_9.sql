--Unit 5 assignment no.2
--School scheduling database
--#1
SELECT AVG(duration) AS average_class_duration
FROM Classes

--#3
SELECT COUNT(*) AS Number_of_Classes
FROM Classes
WHERE ClassRoomID = 3346

--Unit 5 Assignment no.3
--School Scheduling Database
--#1
SELECT Categories.CategoryID, COUNT(classes.ClassID) AS classes_offered
FROM Categories
   INNER JOIN classes ON Categories.CategoryID = classes.categoryID
   INNER JOIN staff ON classes.staffID = staff.StaffID
GROUP BY Categories.CategoryDescription


--#2
SELECT staff.StfFirstName, COUNT(classes.ClassID) AS classes_scheduled
FROM staff
    INNER JOIN classes ON staff.StaffID = classes.staffID
GROUP BY staff.StfFirstName
