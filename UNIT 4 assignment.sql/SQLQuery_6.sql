--Unit 4 Assignment No.2
--School Scheduloing Database.
--#1
SELECT Buildings.BuildingName, Class_Rooms.ClassRoomID
FROM Buildings
INNER JOIN Class_Rooms ON Buildings.BuildingCode = Class_Rooms.BuildingCode

--#2
SELECT Students.StudFirstName, Students.StudLastName, Student_Schedules.ClassStatus, Classes.Classid, Classes.SemesterNumber
FROM students 
INNER JOIN Student_Schedules ON Students.StudentID = Student_Schedules.studentid
INNER JOIN classes  ON Student_Schedules.ClassID = Classes.ClassID
WHERE Classes.SemesterNumber >= 0

--#3
SELECT Faculty.Title, Faculty.StaffID, Subjects.SubjectName
FROM Faculty 
INNER JOIN Faculty_Subjects ON Faculty.StaffID = Faculty_Subjects.StaffID
INNER JOIN Subjects ON Faculty_Subjects.SubjectID = Subjects.SubjectID