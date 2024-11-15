--Unit 3 Assignment No.2
--Entertainment Agency Database
--#1
SELECT EngagementNumber, StartDate, EndDate
FROM Engagements
WHERE StartDate >= '2017-10-01' AND EndDate <= '2017-10-31'

--#2
SELECT EngagementNumber, StartDate, Enddate
FROM engagements
WHERE StartDate >= '2017-10-01 ' 
AND EndDate <= '2017-10-31 '
AND StartTime BETWEEN '12:00:00' AND '17:00:00'

--#3
SELECT EngagementNumber, StartDate, EndDate
FROM engagements
WHERE StartDate = EndDate
 
